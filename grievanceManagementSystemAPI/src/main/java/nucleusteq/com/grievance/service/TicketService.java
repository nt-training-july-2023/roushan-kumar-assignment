package nucleusteq.com.grievance.service;

import nucleusteq.com.grievance.dto.ResponseDto;
import nucleusteq.com.grievance.dto.TicketDto;

public interface TicketService {
	
	ResponseDto save(TicketDto ticketDto);
}

