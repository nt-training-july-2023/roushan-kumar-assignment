package nucleusteq.com.grievance.service;

import java.util.List;

import nucleusteq.com.grievance.entity.TicketStatus;

public interface TicketStatusService {

  /**
   * Get status by name.
   *
   * @param name name of satus.
   * @return ticket status.
   */
  TicketStatus getByName(String name);

  /**
   * Get status by id.
   *
   * @param statusId status id.
   * @return status.
   */
  TicketStatus getById(Integer statusId);

  /**
   * Get list of status.
   *
   * @return list of status.
   */
  List<TicketStatus> getAll();
}

