package nucleusteq.com.grievance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import nucleusteq.com.grievance.entity.TicketStatus;

public interface TicketStatusRepo extends JpaRepository<TicketStatus, Integer> {

  /**
   * Get ticket status by name.
   */
  String GET_TICKET_STATUS_BY_NAME = "SELECT * from ticket_status where "
  + " ticket_status_name=:name";

  /**
   * Get ticket status by name.
   * @param name Name of ticket status.
   * @return Ticket status by name.
   */
  @Query(value = GET_TICKET_STATUS_BY_NAME, nativeQuery = true)
  TicketStatus getTicketStatsByName(@Param("name") String name);
}

