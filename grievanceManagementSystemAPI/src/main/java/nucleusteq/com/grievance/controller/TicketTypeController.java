package nucleusteq.com.grievance.controller;

import java.util.List;
import nucleusteq.com.grievance.entity.TicketType;
import nucleusteq.com.grievance.service.TicketTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Ticket type controller.
 *
 * @author Roushan Kumar
 * @version 1.0.0
 */

@RestController
@RequestMapping("/ticketType")
@CrossOrigin(origins = "http://localhost:3000")
public class TicketTypeController {

  /**
   * Class variables.
   */
  @Autowired
  private TicketTypeService ticketTypeService;

  /**
   * Get all tickets type.
   *
   * @return all tickets type.
   */
  @GetMapping("/all")
  public List<TicketType> getAllTicketType() {
    return ticketTypeService.getAll();
  }

  /**
   * Save a ticket type.
   *
   * @param ticketType Type of ticket.
   * @return Type of ticket.
   */
  @PostMapping("/save")
  public TicketType saveTicketType(
      @RequestBody final TicketType ticketType) {
    return ticketTypeService.save(ticketType);
  }
}
