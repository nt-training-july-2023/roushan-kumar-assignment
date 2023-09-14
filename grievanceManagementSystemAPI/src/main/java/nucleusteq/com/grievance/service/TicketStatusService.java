package nucleusteq.com.grievance.service;

import java.util.List;

import nucleusteq.com.grievance.entity.TicketStatus;

public interface TicketStatusService {
	TicketStatus getByName(String name);

	TicketStatus getById(Integer statusId);

	List<TicketStatus> getAll();
}

