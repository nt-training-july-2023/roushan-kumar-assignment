package nucleusteq.com.grievance.controller;

import javax.validation.Valid;
import nucleusteq.com.grievance.dto.ResponseDto;
import nucleusteq.com.grievance.dto.TicketDto;
import nucleusteq.com.grievance.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
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
  @Autowired
  private TicketService ticketService;

  @PostMapping("/save")
  public ResponseEntity<?> saveTicket(
    @RequestBody @Valid TicketDto ticket,
    final BindingResult errors
  ) {
    if (errors.hasErrors()) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors.getAllErrors());
    }
    //System.out.println(errors.getAllErrors());
    return ResponseEntity.ok(ticketService.save(ticket));
    //return ticketService.save(ticket);
  }

  @PutMapping("/update")
  public ResponseDto updateTicket(@RequestBody TicketDto ticket) {
    return ticketService.update(ticket);
  }
}
