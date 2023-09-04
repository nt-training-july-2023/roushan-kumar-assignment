package nucleusteq.com.grievance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nucleusteq.com.grievance.entity.Ticket;

public interface TicketRepo extends JpaRepository<Ticket,Integer> {
	
}

