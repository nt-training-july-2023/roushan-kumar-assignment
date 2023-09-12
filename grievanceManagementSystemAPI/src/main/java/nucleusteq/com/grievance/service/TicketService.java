package nucleusteq.com.grievance.service;

import java.util.List;

import nucleusteq.com.grievance.dto.ResponseDto;
import nucleusteq.com.grievance.dto.TicketDto;
import nucleusteq.com.grievance.entity.Comments;

public interface TicketService {
	
	ResponseDto save(TicketDto ticketDto);

  ResponseDto update(TicketDto ticketDto);

  ResponseDto updateTicketComments(Comments comments,Integer  ticketId);

	List<TicketDto> getAll();
}

