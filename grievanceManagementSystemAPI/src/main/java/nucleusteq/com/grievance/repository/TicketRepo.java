package nucleusteq.com.grievance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import nucleusteq.com.grievance.entity.Ticket;

public interface TicketRepo extends JpaRepository<Ticket, Integer> {

//  /**
//   * find By Admin Department.
//   */
//  String FIND_BY_DEPARTMENT = "select * from ticket "
//      + "where department_id=:departId order by ticket_status_id ASC";
//
//  /**
//   * find By Admin Department.
//   *
//   * @param departId find by department id.
//   * @return list all ticket orber by satuts.
//   */
//  @Query(value = FIND_BY_DEPARTMENT, nativeQuery = true)
//  List<Ticket> findByDepartment(Integer departId);
//
//  /**
//   * created by user.
//   */
//  String CREATED_BY_USER = "select * from ticket "
//      + "where user_id =:userId order by ticket_status_id ASC";
//
//  /**
//   * created by user.
//   *
//   * @param userId for find by user.
//   * @return List of all ticket orber by satuts.
//   */
//  @Query(value = CREATED_BY_USER, nativeQuery = true)
//  List<Ticket> findByCreateByUser(Integer userId);
//
//  /**
//   * Find all ticket orber by satuts.
//   */
//  String FIND_ALL = "select * from ticket "
//      + " order by ticket_status_id ASC";
//
//  /**
//   * Find all ticket orber by satuts.
//   *
//   * @return list of all ticket.
//   */
//  @Query(value = FIND_ALL, nativeQuery = true)
//  List<Ticket> findAllSortByStatus();

  /////////////////////////////////////////////////////////
  /**
   * Find all ticket orber by satuts.
   */
  String FIND_ALL_NEW = "select * from ticket "
      + "order by ticket_status_id ASC "
      + "OFFSET :offSet rows fetch next :pageSize rows only";

  /**
   * Find all ticket orber by satuts.
   *
   * @return list of all ticket.
   */
  @Query(value = FIND_ALL_NEW, nativeQuery = true)
  List<Ticket> findAllSortByStatusNew(int offSet,int pageSize);


  /**
   * find By  Department.
   */
  String FIND_BY_DEPARTMENT_NEW = "select * from ticket "
      + "where department_id=:departId order by ticket_status_id ASC "
      + "OFFSET :offSet rows fetch next :pageSize rows only";

  /**
   * find By  Department.
   *
   * @param departId find by department id.
   * @return list all ticket orber by satuts.
   */
  @Query(value = FIND_BY_DEPARTMENT_NEW, nativeQuery = true)
  List<Ticket> findByDepartmentNew(Integer departId,int offSet,int pageSize);

  /**
   * created by user.
   */
  String CREATED_BY_USER_NEW = "select * from ticket "
      + "where user_id =:userId order by ticket_status_id ASC "
      + "OFFSET :offSet rows fetch next :pageSize rows only";

  /**
   * created by user.
   *
   * @param userId for find by user.
   * @return List of all ticket orber by satuts.
   */
  @Query(value = CREATED_BY_USER_NEW, nativeQuery = true)
  List<Ticket> findByCreateByUserNew(
      Integer userId,
      Integer offSet,
      Integer pageSize);

  String FIND_BY_DEPARTMENT_AND_STATUS_NEW = "select * from ticket "
      + "where department_id=:departId and ticket_status_id=:statusId order by ticket_status_id ASC "
      + "OFFSET :offSet rows fetch next :pageSize rows only";
  
  /**
  * find ticket if department and status is given.
  *
  * @param departId find by department id.
  * @return list all ticket orber by satuts.
  */
  @Query(value = FIND_BY_DEPARTMENT_AND_STATUS_NEW, nativeQuery = true)
  List<Ticket> findByDepartmentNew(
      Integer departId,
      int offSet,
      int pageSize,
      Integer statusId);

  /**
   * Find all ticket orber by satuts and filter by status.
   */
  String FIND_ALL_FILTER_STATUS_NEW = "select * from ticket where ticket_status_id=:statusId "
      + "OFFSET :offSet rows fetch next :pageSize rows only";

  /**
   * Find all ticket orber by satuts and filter by status.
   *
   * @return list of all ticket.
   */
  @Query(value = FIND_ALL_FILTER_STATUS_NEW, nativeQuery = true)
  List<Ticket> findAllFilterSortedByStatusNew(
      int offSet,
      int pageSize,
      Integer statusId);

  /**
   * created by user filter by status.
   */
  String CREATED_BY_USER_BY_FILTER_STATUS_NEW = "select * from ticket "
      + "where user_id =:userId and ticket_status_id=:statusId "
      + "OFFSET :offSet rows fetch next :pageSize rows only";

  /**
   * created by user.
   *
   * @param userId for find by user.
   * @return List of all ticket orber by satuts.
   */
  @Query(value = CREATED_BY_USER_BY_FILTER_STATUS_NEW, nativeQuery = true)
  List<Ticket> findByCreateByUserByStatus(
      Integer userId,
      Integer offSet,
      Integer pageSize,
      Integer statusId);


  
}

