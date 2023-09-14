package nucleusteq.com.grievance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nucleusteq.com.grievance.entity.TicketStatus;
import nucleusteq.com.grievance.service.TicketStatusService;

/**
 * TicketStatusController.
 *
 * @author roush
 * @version 1.0.0
 */

@RestController
@RequestMapping("/ticketStatus")
@CrossOrigin(origins = "http://localhost:3000")
public class TicketStatusController {
	
	@Autowired
	private TicketStatusService statusService;
	
	@GetMapping("/all")
	public List<TicketStatus> getAllStatus()
	{
		return statusService.getAll();
	}

}
