package nucleusteq.com.grievance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nucleusteq.com.grievance.dto.ResponseDto;
import nucleusteq.com.grievance.dto.TicketDto;
import nucleusteq.com.grievance.service.TicketService;

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
	public ResponseDto saveTicket(@RequestBody TicketDto ticket)
	{
		return ticketService.save(ticket);
	}
	
	@PutMapping("/update")
	public ResponseDto updateTicket(@RequestBody TicketDto ticket)
	{
		return ticketService.update(ticket);
	}
}

