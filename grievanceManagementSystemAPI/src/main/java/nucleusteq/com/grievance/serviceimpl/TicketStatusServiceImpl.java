package nucleusteq.com.grievance.serviceimpl;

import nucleusteq.com.grievance.entity.TicketStatus;
import nucleusteq.com.grievance.repository.TicketStatusRepo;
import nucleusteq.com.grievance.service.TicketStatusService;
import org.apache.log4j.Logger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Ticket status.
 *
 * @author Roushan kumar
 */
@Service
public class TicketStatusServiceImpl implements TicketStatusService {

  /**
   * Logger instance for the TicketServiceImpl class.
   */
  private static final Logger LOGGER = Logger
      .getLogger(TicketStatusServiceImpl.class);

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
    LOGGER.info("Getting status by id.");
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

