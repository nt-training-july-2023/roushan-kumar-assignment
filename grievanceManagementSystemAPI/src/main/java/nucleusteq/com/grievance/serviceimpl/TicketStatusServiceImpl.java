package nucleusteq.com.grievance.serviceimpl;

import nucleusteq.com.grievance.entity.TicketStatus;
import nucleusteq.com.grievance.repository.TicketStatusRepo;
import nucleusteq.com.grievance.service.TicketStatusService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Ticket status.
 */
@Service
public class TicketStatusServiceImpl implements TicketStatusService {

  /**
   * Variable.
   */
  @Autowired
  private TicketStatusRepo ticketStatusRepo;

  /**
   * Constructor to initialize TicketStatusRepo object.
   * @param ticketStatusRepoParam
   */
  public TicketStatusServiceImpl(
      final TicketStatusRepo ticketStatusRepoParam) {
    super();
    this.ticketStatusRepo = ticketStatusRepoParam;
  }

  /**
   * Get ticket status by name.
   */
  @Override
  public TicketStatus getByName(
      final String name) {
    return ticketStatusRepo.getTicketStatsByName(name);
  }

  /**
   * Get ticket status by id.
   */
  @Override
  public TicketStatus getById(
      final Integer statusId) {

    return ticketStatusRepo.findById(statusId).get();
  }

  /**
   * All ticket status.
   */
  @Override
  public List<TicketStatus> getAll() {
    return ticketStatusRepo.findAll();
  }
}

