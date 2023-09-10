package nucleusteq.com.grievance.serviceimpl;

import java.time.LocalDateTime;
import java.util.Optional;

import nucleusteq.com.grievance.dto.ResponseDto;
import nucleusteq.com.grievance.dto.TicketDto;
import nucleusteq.com.grievance.entity.Department;
import nucleusteq.com.grievance.entity.Ticket;
import nucleusteq.com.grievance.entity.TicketStatus;
import nucleusteq.com.grievance.entity.TicketType;
import nucleusteq.com.grievance.entity.Users;
import nucleusteq.com.grievance.exception.BadRequestError;
import nucleusteq.com.grievance.repository.TicketRepo;
import nucleusteq.com.grievance.service.DepartmentService;
import nucleusteq.com.grievance.service.TicketService;
import nucleusteq.com.grievance.service.TicketStatusService;
import nucleusteq.com.grievance.service.TicketTypeService;
import nucleusteq.com.grievance.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TicketServiceImpl class.
 */
@Service
public class TicketServiceImpl implements TicketService {

 /**
* Variables.
*/
 @Autowired
 private TicketRepo ticketRepo;

 /**
* Department Service.
*/
 private DepartmentService departmentService;

 /**
* Ticket Type Service.
*/
 private TicketTypeService ticketTypeService;

 /**
* Ticket Status Service.
*/
 private TicketStatusService ticketStatusService;

 /**
* User Service.
*/
 private UserService userService;

 /**
* Constructor for TicketServiceImpl.
*
* @param ticketRepoParam         The repository for tickets.
* @param departmentServiceParam  The service for departments.
* @param ticketTypeServiceParam  The service for ticket types.
* @param ticketStatusServiceParam The service for ticket statuses.
* @param userServiceParam        The service for users.
*/
 public TicketServiceImpl(
         final TicketRepo ticketRepoParam,
         final DepartmentService departmentServiceParam,
         final TicketTypeService ticketTypeServiceParam,
         final TicketStatusService ticketStatusServiceParam,
         final UserService userServiceParam
 ) {
     super();
     this.ticketRepo = ticketRepoParam;
     this.departmentService = departmentServiceParam;
     this.ticketTypeService = ticketTypeServiceParam;
     this.ticketStatusService = ticketStatusServiceParam;
     this.userService = userServiceParam;
 }

 /**
* Save a ticket.
*
* @param ticketDto The ticket data transfer object.
* @return A ResponseDto indicating the result of the save operation.
*/
 @Override
 public ResponseDto save(final TicketDto ticketDto) {
     Ticket ticket = new Ticket();
     LocalDateTime currentDateTime = LocalDateTime.now();
     TicketType tType = ticketTypeService.getTicketTypeByName(
                        ticketDto.getTicketType().getTicketName());

     if (tType != null) {
         ticket.setTicketType(tType);
     } else {
         throw new BadRequestError("Not found Ticket Type: "
                  + ticketDto.getTicketType().getTicketName());
   }

   ticket.setTicketId(ticketDto.getTicketId());
   ticket.setTitle(ticketDto.getTitle());
   ticket.setDescription(ticketDto.getDescription());
   ticket.setCreationTime(currentDateTime);
   TicketStatus tStatus = ticketStatusService.getByName("OPEN");

   if (tStatus != null) {
       ticket.setTicketStatus(tStatus);
   } else {
       throw new BadRequestError("Not found Ticket Status: OPEN");
   }

   Department dept = departmentService.getDepartmentByName(
                       ticketDto.getDepartment().getDeptName());

   if (dept != null) {
       ticket.setDepartment(dept);
   } else {
       throw new BadRequestError("Not found Department: "
                        + ticketDto.getDepartment().getDeptName());
   }

   Users user = userService.getById(ticketDto.getUserId());

   if (user != null) {
       ticket.setUser(user);
   } else {
       throw new BadRequestError("Not found User");
   }

   ticket = ticketRepo.save(ticket);
   ResponseDto response = new ResponseDto(ticket.getTicketId(),
                                         "New Ticket Created", "SAVE");
     return response;
 }

 /**
* Update a ticket.
*
* @param ticketDto The ticket data transfer object.
* @return A ResponseDto indicating the result of the update operation.
*/
 @Override
 public ResponseDto update(final TicketDto ticketDto) {
     Optional<Ticket> ticket = ticketRepo
                               .findById(ticketDto.getTicketId());

     if (ticket.isPresent()) {
         Ticket ticketData = ticket.get();
         LocalDateTime lastUpdateTime = LocalDateTime.now();
         ticketData.setLastUpdateTime(lastUpdateTime);
         ticketRepo.save(ticketData);
         ResponseDto response = new ResponseDto(
         ticketDto.getTicketId(),
         "Ticket Update", "UPDATE");
       return response;
   } else {
       ResponseDto response = new ResponseDto(ticketDto.getTicketId(),
         "Ticket not found", "NOT UPDATE");
         return response;
     }
 }
}
