package nucleusteq.com.grievance.service;

import java.util.List;

import nucleusteq.com.grievance.entity.TicketType;

public interface TicketTypeService {
  List<TicketType> getAll();
  TicketType save(TicketType ticketType);
  TicketType getTicketTypeByName(String name);
}

