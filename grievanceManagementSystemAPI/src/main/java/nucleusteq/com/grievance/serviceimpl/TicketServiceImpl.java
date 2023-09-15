package nucleusteq.com.grievance.serviceimpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
   * Get all tickets with given condition user id, department id.
   * And a boolean value for ticket is created by user.
   */
  @Override
  public List<TicketDto> getAllByCondition(
      final Integer userId,
      final Integer departId,
      final boolean createdByUser) {

    List<Ticket> allTickets = new ArrayList<Ticket>();
    Users user = userService.getById(userId);
    if (user.getRole().getName().equals("Admin") && departId != 0) {
      // return all ticket if user is admin and filter by department
      System.out.println("admin and department");
      allTickets = ticketRepo.findByDepartment(departId);

    } else if (!user.getRole().getName().equals("Admin")
        && !createdByUser) {
      //all ticket if user is non admin and assign to its department
      System.out.println("non admin");
      Integer deptId = user.getDepartment().getDeptId();
      allTickets = ticketRepo.findByDepartment(deptId);

    } else if (createdByUser) {
      // all ticket if user is not admin and filter by created by user
      System.out.println("created by me ticket");
      allTickets = ticketRepo.findByCreateByUser(userId);

    } else if (user.getRole().getName().equals("Admin")) {
      // all ticket.
      System.out.println("all ticket");
      allTickets = ticketRepo.findAll();
    }
    if (allTickets.size() <= 0) {
      System.out.println("in null all ticket");
      return null;
    }
    List<TicketDto> allTicketsDto = new ArrayList<TicketDto>();
    for (Ticket t : allTickets) {
      System.out.println("ticket 1: " + t.toString());
      TicketDto ticketDto = new TicketDto();
      if (t.getComments() != null) {
        ticketDto.setComments(t.getComments());
      } else {
        continue;
      }
      ticketDto.setTicketId(t.getTicketId());
      ticketDto.setTitle(t.getTitle());
      ticketDto.setDescription(t.getDescription());
      ticketDto.setDepartment(t.getDepartment());
      ticketDto.setTicketType(t.getTicketType());
      ticketDto.setTicketStatus(t.getTicketStatus());
      ticketDto.setUserId(t.getUser().getUserId());
      ticketDto.setFullName(t.getUser().getFullName());
      ticketDto.setDate(t.getLastUpdateTime().toLocalDate().toString());
      Integer hour = t.getLastUpdateTime().getHour();
      Integer minute = t.getLastUpdateTime().getMinute();
      ticketDto.setTime(hour + ":" + minute);
      ticketDto.setCreationTime(t.getCreationTime().getHour()
          + ":" + t.getCreationTime().getMinute());
      ticketDto.setCreationDate(t.getCreationTime().toLocalDate().toString());
      allTicketsDto.add(ticketDto);
    }

    return allTicketsDto;
  }
}
