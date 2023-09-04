package nucleusteq.com.grievance.serviceimpl;

import nucleusteq.com.grievance.entity.Department;
import nucleusteq.com.grievance.exception.InternalServerError;
import nucleusteq.com.grievance.repository.DepartmentRepo;
import nucleusteq.com.grievance.service.DepartmentService;

import java.util.List;

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
    Department tempDepartment;
    //try {
      tempDepartment = departmentRepo.getDepartmentByName(department.getDeptName());
      if(tempDepartment==null)
       return departmentRepo.save(department);
      else
       throw new InternalServerError("Department Already Exists");
    //} catch (Exception e) {
    //  System.out.println(e.getMessage());
    //}
    //return null;
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

  /**
   * List of Department.
   */
  @Override
  public List<Department> getAllDepartment() {
    return departmentRepo.findAll();
  }

  /**
   * delete department by id.
   */
  @Override
  public void delete(Integer deptId) {
   departmentRepo.deleteById(deptId);
   return ;
  }
}

