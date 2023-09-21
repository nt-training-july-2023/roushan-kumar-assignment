package nucleusteq.com.grievance.serviceimpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.apache.log4j.Logger;

import nucleusteq.com.grievance.dto.AllTicketsDto;
import nucleusteq.com.grievance.dto.ResponseDto;
import nucleusteq.com.grievance.dto.TicketDto;
import nucleusteq.com.grievance.entity.Comments;
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
   * Logger.
   */
  private static final Logger LOGGER = Logger
      .getLogger(TicketServiceImpl.class);

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
   * @param ticketRepoParam          The repository for tickets.
   * @param departmentServiceParam   The service for departments.
   * @param ticketTypeServiceParam   The service for ticket types.
   * @param ticketStatusServiceParam The service for ticket statuses.
   * @param userServiceParam         The service for users.
   */
  public TicketServiceImpl(
      final TicketRepo ticketRepoParam,
      final DepartmentService departmentServiceParam,
      final TicketTypeService ticketTypeServiceParam,
      final TicketStatusService ticketStatusServiceParam,
      final UserService userServiceParam) {
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
    TicketType tType = ticketTypeService
                         .getTicketTypeByName(
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
    LOGGER.info("saving new ticket");
    ticket = ticketRepo.save(ticket);
    ResponseDto response = new ResponseDto(ticket.getTicketId(),
        "New Ticket Created", "SAVE");
    return response;
  }

  /**
   * Update ticket given by user.
   *
   * @param comments comments given by user.
   * @param ticketId ticket id.
   * @param statusId status id.
   */
  @Override
  public ResponseDto updateTicketComments(
      final Comments comments,
      final Integer ticketId,
      final Integer statusId) {
    Optional<Ticket> ticket = ticketRepo.findById(ticketId);
    if (ticket.isPresent()) {
      Ticket ticketData = ticket.get();
      LocalDateTime lastUpdateTime = LocalDateTime.now();
      ticketData.setLastUpdateTime(lastUpdateTime);

      TicketStatus ticketStatus = ticketStatusService.getById(statusId);
      if (ticketStatus != null) {
        ticketData.setTicketStatus(ticketStatus);
      } else {
        throw new BadRequestError("Status Not Found.");
      }
      ticketData.addComments(comments);
      ticketRepo.save(ticketData);
      ResponseDto response = new ResponseDto(ticketId,
          "Ticket Comments Added",
          "UPDATE");
      return response;
    } else {
      ResponseDto response = new ResponseDto(ticketId,
          "Ticket not found",
          "NOT UPDATE");
      return response;
    }
  }

  /**
   * Return single ticket details.
   *
   * @param ticketId id of ticket to search.
   * @return single ticket.
   */
  @Override
  public TicketDto getByTicketId(final Integer ticketId) {

     Optional<Ticket> ticket = ticketRepo.findById(ticketId);
     if (ticket.isPresent()) {
       TicketDto ticketDto = new TicketDto();
       Ticket singleTicket = ticket.get();
       if (singleTicket.getComments() != null) {
         ticketDto.setComments(singleTicket.getComments());
       }
       ticketDto.setTicketId(singleTicket.getTicketId());
       ticketDto.setTitle(singleTicket.getTitle());
       ticketDto.setDescription(singleTicket.getDescription());
       ticketDto.setDepartment(singleTicket.getDepartment());
       ticketDto.setTicketType(singleTicket.getTicketType());
       ticketDto.setTicketStatus(singleTicket.getTicketStatus());
       ticketDto.setUserId(singleTicket.getUser().getUserId());
       ticketDto.setFullName(singleTicket.getUser().getFullName());

       ticketDto.setDate(DateTimeFormatter.ofPattern("dd/MM/yyyy")
         .format(singleTicket.getLastUpdateTime()));

       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("KK:mm:ss a",
           Locale.ENGLISH);
       String lastUpdateTime = singleTicket
           .getLastUpdateTime().format(formatter);

       ticketDto.setTime(lastUpdateTime);

       ticketDto.setCreationTime(singleTicket
           .getCreationTime().format(formatter));
       ticketDto.setCreationDate(DateTimeFormatter.ofPattern("dd/MM/yyyy")
           .format(singleTicket.getCreationTime()));

       return ticketDto;
     } else {
       throw new BadRequestError("Ticket not found");
     }
  }

  /**
   * Return list of all tickets according to condition.
   *
   *@param userId
   *@param departId
   *@param createdByUser
   *@param offSet
   *@param pageSize
   *@param status
   */
  @Override
  public List<AllTicketsDto> getAllByCondition(
      final Integer userId,
      final Integer departId,
      final Boolean createdByUser,
      final int offSet,
      final int pageSize,
      final String status) {

    Integer statusId = 0;
    Integer serialNumber = 1;
    System.err.println(status);
    if (!status.equals("0")) {
       statusId = ticketStatusService.getByName(status).getTicketStatusId();
       System.err.println(statusId);
    }
    List<Ticket> allTickets = new ArrayList<Ticket>();
    Users user = userService.getById(userId);

    if (createdByUser && statusId == 0) {
      // all ticket if user is not admin and filter by created by user

      allTickets = ticketRepo.findByCreateByUserNew(userId, offSet, pageSize);

    } else if (createdByUser && statusId != 0) {
      allTickets = ticketRepo.findByCreateByUserByStatus(userId, offSet,
          pageSize, statusId);

    } else if (user.getRole().getName().equals("Admin") && departId != 0
        && statusId == 0) {
      // return all ticket if user is admin and filter by department

      allTickets = ticketRepo.findByDepartmentNew(departId, offSet, pageSize);

    } else if (!user.getRole().getName().equals("Admin")
        && !createdByUser && statusId == 0) {
      //all ticket if user is non admin and assign to its department

      Integer deptId = user.getDepartment().getDeptId();
      allTickets = ticketRepo.findByDepartmentNew(deptId, offSet, pageSize);

    }  else if (user.getRole().getName().equals("Admin") && statusId == 0) {
      // all ticket.

      allTickets = ticketRepo.findAllSortByStatusNew(offSet, pageSize);
    } else if (user.getRole().getName().equals("Admin")
        && departId != 0 && statusId != 0) {

       allTickets = ticketRepo.findByDepartmentNew(departId, offSet,
           pageSize, statusId);
    } else if (!user.getRole().getName().equals("Admin")
        && !createdByUser && statusId != 0) {

      Integer deptId = user.getDepartment().getDeptId();
      allTickets = ticketRepo.findByDepartmentNew(deptId, offSet,
          pageSize, statusId);
    } else if (user.getRole().getName().equals("Admin") && statusId != 0) {
      allTickets = ticketRepo.findAllFilterSortedByStatusNew(offSet,
          pageSize, statusId);
    }

    if (allTickets.size() <= 0) {
      return null;
    }
    List<AllTicketsDto> allTicketsDto = new ArrayList<AllTicketsDto>();
    for (Ticket t : allTickets) {
      AllTicketsDto ticketDto = new AllTicketsDto();
      ticketDto.setSerialNumber(offSet + serialNumber);
      ticketDto.setTicketId(t.getTicketId());
      ticketDto.setTitle(t.getTitle());
      ticketDto.setDescription(t.getDescription());
      ticketDto.setDepartment(t.getDepartment());
      ticketDto.setTicketType(t.getTicketType());
      ticketDto.setTicketStatus(t.getTicketStatus());
      ticketDto.setUserId(t.getUser().getUserId());
      ticketDto.setFullName(t.getUser().getFullName());

      ticketDto.setDate(DateTimeFormatter.ofPattern("dd/MM/yyyy")
          .format(t.getLastUpdateTime()));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("KK:mm:ss a",
            Locale.ENGLISH);
        String lastUpdateTime = t.getLastUpdateTime().format(formatter);

        ticketDto.setTime(lastUpdateTime);

        ticketDto.setCreationTime(t.getCreationTime().format(formatter));
        ticketDto.setCreationDate(DateTimeFormatter.ofPattern("dd/MM/yyyy")
            .format(t.getCreationTime()));
      allTicketsDto.add(ticketDto);
      serialNumber += 1;
    }

    return allTicketsDto;
  }
}

