package nucleusteq.com.grievance.serviceimpl;

import nucleusteq.com.grievance.entity.TicketStatus;
import nucleusteq.com.grievance.repository.TicketStatusRepo;
import nucleusteq.com.grievance.service.TicketStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketStatusServiceImpl implements TicketStatusService {
  @Autowired
  private TicketStatusRepo ticketStatusRepo;

  /**
   * @param ticketStatusRepo
   */
  public TicketStatusServiceImpl(TicketStatusRepo ticketStatusRepo) {
    super();
    this.ticketStatusRepo = ticketStatusRepo;
  }

  @Override
  public TicketStatus getByName(String name) {
    return ticketStatusRepo.getTicketStatsByName(name);
  }
}
