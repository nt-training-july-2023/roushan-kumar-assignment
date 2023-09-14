package nucleusteq.com.grievance.serviceimpl;

import java.util.List;
import nucleusteq.com.grievance.entity.TicketType;
import nucleusteq.com.grievance.repository.TicketTypeRepo;
import nucleusteq.com.grievance.service.TicketTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Ticket Type Service Impl.
 */
@Service
public class TicketTypeServiceImpl implements TicketTypeService {

  /**
   * ticket Type Repo.
   */
  @Autowired
  private TicketTypeRepo ticketTypeRepo;

  /**
   * constructor of TicketTypeServiceImpl.
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
   * save ticket type.
   */
  @Override
  public TicketType save(final TicketType ticketType) {
    return ticketTypeRepo.save(ticketType);
  }

  /**
   * get ticket type by name.
   */
  @Override
  public TicketType getTicketTypeByName(final String name) {
    return ticketTypeRepo.getTicketTypeByName(name);
  }
}
