package nucleusteq.com.grievance.serviceimpl;

import java.io.Serializable;
import java.util.Comparator;

import nucleusteq.com.grievance.entity.Ticket;

/**
 * Sort by ticket id.
 */
class SortById implements Comparator<Ticket>, Serializable {

  /**
   * serialVersionUID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * compare.
   */
  @Override
  public int compare(
      final Ticket t1,
      final Ticket t2) {

    Integer ticketId1 = t1.getTicketId();
    Integer ticketId2 = t2.getTicketId();

    if (ticketId1.compareTo(ticketId2) == 1) {
      return -1;
    } else if (ticketId1.compareTo(ticketId2) < 0) {
      return 1;
    }

    return ticketId1.compareTo(ticketId2);
  }
}
