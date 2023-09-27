package nucleusteq.com.grievance.serviceimpl;

import java.util.List;
import nucleusteq.com.grievance.entity.TicketType;
import nucleusteq.com.grievance.repository.TicketTypeRepo;
import nucleusteq.com.grievance.service.TicketTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The TicketTypeServiceImpl class provides methods for managing ticket type.
 * It allows you to create, retrieve ticket type information.
 */
@Service
public class TicketTypeServiceImpl implements TicketTypeService {

  /**
   * Ticket Type Repo.
   */
  @Autowired
  private TicketTypeRepo ticketTypeRepo;

  /**
   * Constructor of TicketTypeServiceImpl.
   *
   * @param ticketTypeRepoParam ticketTypeRepo.
   */
    public TicketTypeServiceImpl(
        final TicketTypeRepo ticketTypeRepoParam) {
    super();
    this.ticketTypeRepo = ticketTypeRepoParam;
  }

  /**
   * List of ticket type.
   */
  @Override
  public List<TicketType> getAll() {
    return ticketTypeRepo.findAll();
  }

  /**
   * Save ticket type.
   */
  @Override
  public TicketType save(final TicketType ticketType) {
    return ticketTypeRepo.save(ticketType);
  }

  /**
   * Get all ticket type by name.
   */
  @Override
  public TicketType getTicketTypeByName(final String name) {
    return ticketTypeRepo.getTicketTypeByName(name);
  }
}
