package nucleusteq.com.grievance.serviceimpl;

import java.util.List;
import nucleusteq.com.grievance.entity.TicketType;
import nucleusteq.com.grievance.repository.TicketTypeRepo;
import nucleusteq.com.grievance.service.TicketTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketTypeServiceImpl implements TicketTypeService {
  @Autowired
  private TicketTypeRepo ticketTypeRepo;

  /**
   * @param ticketTypeRepo
   */public TicketTypeServiceImpl(TicketTypeRepo ticketTypeRepo) {
    super();
    this.ticketTypeRepo = ticketTypeRepo;
  }

  @Override
  public List<TicketType> getAll() {
    return ticketTypeRepo.findAll();
  }

  @Override
  public TicketType save(TicketType ticketType) {
    return ticketTypeRepo.save(ticketType);
  }

  @Override
  public TicketType getTicketTypeByName(String name) {
   
    return ticketTypeRepo.getTicketTypeByName(name);
  }
}
