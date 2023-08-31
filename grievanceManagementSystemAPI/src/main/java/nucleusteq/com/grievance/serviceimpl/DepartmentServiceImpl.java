package nucleusteq.com.grievance.serviceimpl;

import nucleusteq.com.grievance.entity.Department;
import nucleusteq.com.grievance.repository.DepartmentRepo;
import nucleusteq.com.grievance.service.DepartmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Department service impl class.
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

  /**
   * class variables.
   */
  @Autowired
  private DepartmentRepo departmentRepo;

  /**
   * All args constructor.
   *
  * @param departmentRepoParam department repo is interface.
  */
  public DepartmentServiceImpl(DepartmentRepo departmentRepoParam) {
    
    super();
    this.departmentRepo = departmentRepoParam;
  }

  /**
   * to save Department.
   */
  @Override
  public Department save(Department department) {
    try {
      return departmentRepo.save(department);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return null;
  }

  /**
   * to get department by department name.
   */
  @Override
  public Department getDepartmentByName(String name) {
    Department department;
    try {
      //System.out.println("depart_Name "+departmentRepo.getDepartmentByName(name));
      department = departmentRepo.getDepartmentByName(name);
      return department;
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return null;
  }
}

