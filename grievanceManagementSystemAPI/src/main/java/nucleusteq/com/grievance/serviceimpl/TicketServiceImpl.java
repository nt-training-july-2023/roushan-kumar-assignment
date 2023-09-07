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
  @Autowired
  private TicketRepo ticketRepo;
  private DepartmentService departmentService;
  private TicketTypeService ticketTypeService;
  private TicketStatusService ticketStatusService;
  private UserService userService;

   /**
    * constructor.
    *
   * @param ticketRepo
   * @param departmentService
   * @param ticketType
   * @param ticketStatusService
   */
    public TicketServiceImpl(
    TicketRepo ticketRepo,
    DepartmentService departmentService,
    TicketTypeService ticketTypeService,
    TicketStatusService ticketStatusService,
    UserService userService
  ) {
    super();
    this.ticketRepo = ticketRepo;
    this.departmentService = departmentService;
    this.ticketTypeService = ticketTypeService;
    this.ticketStatusService = ticketStatusService;
    this.userService = userService;
  }

    /**
     * save ticket.
     */
  @Override
  public ResponseDto save(TicketDto ticketDto) {
    Ticket ticket = new Ticket();
    LocalDateTime currentDateTime  = LocalDateTime.now();
    //System.out.println(" currentDateTime : "+currentDateTime);
    TicketType tType = ticketTypeService.getTicketTypeByName(ticketDto.getTicketType().getTicketName());
    if(tType!=null) {
    ticket.setTicketType(tType);
    }
    else {
      throw new BadRequestError("Not found Ticket Type : "+ ticketDto.getTicketType().getTicketName());
    }
    ticket.setTicketId(ticketDto.getTicketId());
    ticket.setTitle(ticketDto.getTitle());
    ticket.setDescription(ticketDto.getDescription());
    //Date date = Date.valueOf(LocalDate.now());
    //System.out.println("Creation Time" + date);
    //if(ticketDto.getTicketId()==null) {
     ticket.setCreationTime(currentDateTime);
    //}
    TicketStatus TStatus = ticketStatusService.getByName("OPEN");
    if(TStatus!=null)
    {
      ticket.setTicketStatus(TStatus);
    }
    else
    {
    	throw new BadRequestError("Not found Ticket Staus : OPEN" );
    }
    Department dept = departmentService.getDepartmentByName(ticketDto.getDepartment().getDeptName());
    if(dept!=null) {
    ticket.setDepartment(dept);
    }
    else 
    {
    	throw new BadRequestError("Not found Department : "+ ticketDto.getDepartment().getDeptName());
    }
    
    Users user = userService.getById(ticketDto.getUserId());
    if(user!=null)
    {
    	ticket.setUser(user);
    }
    else
    {
    	throw new BadRequestError("Not found User ");
    }
    ticket = ticketRepo.save(ticket);
//    ticketDto.setTicketId(ticket.getTicketId());
//    ticketDto.setTicketType(ticket.getTicketType());
//    ticketDto.setDepartment(ticket.getDepartment());
    ResponseDto response = new ResponseDto(ticket.getTicketId(),"New Ticket Created","SAVE");
    
    return response;
  }

  /**
   * update ticket.
   */
  @Override
  public ResponseDto update(TicketDto ticketDto) {
  	Optional<Ticket> ticket = ticketRepo.findById(ticketDto.getTicketId());
  	
  	if(ticket.isPresent())
  	{
  		Ticket ticketData;
  		ticketData = ticket.get();
  		LocalDateTime lastUpdateTime = LocalDateTime.now();
  		ticketData.setLastUpdateTime(lastUpdateTime);
  		ticketRepo.save(ticketData);
  		ResponseDto response = new ResponseDto(ticketDto.getTicketId(),"Ticket Update","UPDATE");
      return response;
  	}
  	else
  	{
  		ResponseDto response = new ResponseDto(ticketDto.getTicketId(),"Ticket not found","NOT UPDATE");
      return response;
  	}
  }
}
