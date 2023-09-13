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
import org.springframework.web.bind.annotation.RestController;

/**
 * UserController.
 *
 * @author roush
 * @version 1.0.0
 */
@RestController
@RequestMapping("/api/ticket")
@CrossOrigin(origins = "http://localhost:3000")
public class TicketController {

  /**
   * Ticket service object.
   */
  @Autowired
  private TicketService ticketService;

  /**
   * save ticket.
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
    //System.out.println(errors.getAllErrors());
    return ResponseEntity.ok(ticketService.save(ticket));
    //return ticketService.save(ticket);
  }

  /**
   * update ticket.
   *
   * @param ticket ticket.
   * @return response of update.
   */
  @PutMapping("/update")
  public ResponseDto updateTicket(
     @RequestBody final TicketDto ticket) {
    return ticketService.update(ticket);
  }
  

  @PutMapping("/updates/ticketcomments/{ticketId}")
  public ResponseDto updateTicketComments(
     @RequestBody final  Comments comments,
     @PathVariable("ticketId") final Integer ticketId) {
  	System.out.println("comments "+comments.getComments());
    return ticketService.updateTicketComments(comments,ticketId);
  }

  @GetMapping("/all")
  public List<TicketDto> getAllTickets()
  {
  	return ticketService.getAll();
  }
  
  
  
}
