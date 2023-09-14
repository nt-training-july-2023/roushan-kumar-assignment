package nucleusteq.com.grievance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import nucleusteq.com.grievance.entity.Ticket;

public interface TicketRepo extends JpaRepository<Ticket,Integer> {

	/**
   * find By Admin Department.
   */
  String FIND_BY_DEPARTMENT = "select * from ticket "
  		+ "where department_id=:departId";

  /**
   * find By Admin Department.
   * 
   * @param departId find by department id.
   */
  @Query(value = FIND_BY_DEPARTMENT, nativeQuery = true)
	List<Ticket> findByDepartment(Integer departId);

  
  /**
   * created by user.
   */
  String CREATED_BY_USER = "select * from ticket "
  		+ "where user_id =:userId";

  /**
   * created by user.
   * 
   * @param userId for find by user.
   */
  @Query(value = CREATED_BY_USER, nativeQuery = true)
	List<Ticket> findByCreateByUser(Integer userId);

}

