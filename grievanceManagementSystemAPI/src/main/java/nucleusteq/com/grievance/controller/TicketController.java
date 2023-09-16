package nucleusteq.com.grievance.controller;

import java.util.List;

import javax.validation.Valid;
import nucleusteq.com.grievance.dto.ResponseDto;
import nucleusteq.com.grievance.dto.TicketDto;
import nucleusteq.com.grievance.entity.Comments;
import nucleusteq.com.grievance.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserController.
 *
 * @author roushan
 * @version 1.0.0
 */
@RestController
@RequestMapping("/ticket")
@CrossOrigin(origins = "http://localhost:3000")
public class TicketController {

  /**
   * Ticket service object.
   */
  @Autowired
  private TicketService ticketService;

  /**
   * save ticket .
   *
   * @param ticket ticket.
   * @param errors BindingResult errors.
   * @return respone of save ticket.
   */
  @PostMapping("/save")
  public ResponseEntity<?> saveTicket(
    @RequestBody @Valid final TicketDto ticket,
    final BindingResult errors
  ) {
    if (errors.hasErrors()) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(errors.getAllErrors());
    }
    return ResponseEntity.ok(ticketService.save(ticket));
  }

  /**
   * For add comments and view tickets.
   *
   * @param statusId changed ticket status id.
   * @param comments comment for tickets
   * @param ticketId id of ticket.
   * @return response of method.
   */
  @PutMapping("/updates/ticketcomments/{ticketId}")
  public ResponseDto updateTicketComments(
     @RequestParam(name = "statusId") final Integer statusId,
     @RequestBody final  Comments comments,
     @PathVariable("ticketId") final Integer ticketId) {
    return ticketService.updateTicketComments(comments, ticketId, statusId);
  }

  //localhost:8080/api/ticket/all/10?departId=1&createdByMe=false
  /**
   * Get all ticket according to conditions.
   *
   * @param userId user id.
   * @param departId department id.
   * @param createdByMe boolean value if user wants own tickets.
   * @return return all tickets according to condition.
   */
  @GetMapping("/all/{userId}")
  public List<TicketDto> getAllTickets(
      @PathVariable("userId") final Integer userId,
      @RequestParam(name = "departId", required = false) final Integer departId,
      @RequestParam(name = "createdByMe") final Boolean createdByMe) {
    return ticketService.getAllByCondition(userId, departId, createdByMe);
  }

  /**
   * Get ticket by ticket id.
   * @param ticketId ticket id for search.
   * @return ticket.
   */
  @GetMapping("/{ticketId}")
  public TicketDto getTicket(
      @PathVariable("ticketId") final Integer ticketId )
  {
    return ticketService.getByTicketId(ticketId);
  }
}
