package nucleusteq.com.grievance.service;

import java.util.List;

import nucleusteq.com.grievance.entity.TicketType;

public interface TicketTypeService {

  /**
   * Get list of all ticket type.
   *
   * @return list of all ticket type.
   */
  List<TicketType> getAll();

  /**
   * Save ticket Type.
   *
   * @param ticketType ticket type.
   * @return ticket type.
   */
  TicketType save(TicketType ticketType);

  /**
   * Get ticket type by name.
   *
   * @param name ticket type name.
   * @return ticket type.
   */
  TicketType getTicketTypeByName(String name);
}

