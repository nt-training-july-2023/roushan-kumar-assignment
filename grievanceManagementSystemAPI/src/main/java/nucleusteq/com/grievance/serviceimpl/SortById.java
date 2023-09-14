package nucleusteq.com.grievance.serviceimpl;

import java.io.Serializable;
import java.util.Comparator;

import nucleusteq.com.grievance.entity.Ticket;

class SortById implements Comparator<Ticket> , Serializable
{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public int compare(Ticket t1, Ticket t2) {
		
		Integer ticketId1 = t1.getTicketId();
    Integer ticketId2 = t2.getTicketId();
		
//		if(ticketId1==ticketId2)
//			return 0;
//		else if(ticketId1>=ticketId2)
//			return -1;
//		else 
//			return 1;
    if (ticketId1.compareTo(ticketId2) ==1) {
    	return -1;
    } else if (ticketId1.compareTo(ticketId2) < 0)
    	return 1;
    
    return ticketId1.compareTo(ticketId2);
	}

	
}
