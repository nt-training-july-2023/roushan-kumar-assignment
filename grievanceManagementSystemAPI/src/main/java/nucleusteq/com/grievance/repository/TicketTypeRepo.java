package nucleusteq.com.grievance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import nucleusteq.com.grievance.entity.TicketType;

public interface TicketTypeRepo extends JpaRepository<TicketType, Integer> {

  /**
   * Get ticket type by name.
   */
  String GET_TICKET_TYPE_BY_NAME = "select * from tickets_type where"
  + " ticket_name=:name";

  /**
   * Get ticket type.
   *
   * @param name Name of ticket type.
   * @return Ticket type of ticket.
   */
  @Query(value = GET_TICKET_TYPE_BY_NAME, nativeQuery = true)
  TicketType getTicketTypeByName(@Param("name") String name);
}

