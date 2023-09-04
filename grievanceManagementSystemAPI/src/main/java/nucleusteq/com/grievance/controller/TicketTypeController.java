package nucleusteq.com.grievance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nucleusteq.com.grievance.entity.TicketType;
import nucleusteq.com.grievance.service.TicketTypeService;

/**
 * UserController.
 *
 * @author roush
 * @version 1.0.0
 */

@RestController
@RequestMapping("/api/ticketType")
@CrossOrigin(origins = "http://localhost:3000")
public class TicketTypeController {

  @Autowired
  private TicketTypeService ticketTypeService;
  
  @GetMapping("/all")
  public List<TicketType> getAllTicketType()
  {
    return ticketTypeService.getAll();
  }
  
  @PostMapping("/save")
  public TicketType saveTicketType(@RequestBody TicketType ticketType)
  {
    return ticketTypeService.save(ticketType);
  }
}

