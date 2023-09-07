package nucleusteq.com.grievance.serviceimpl;

import java.util.List;
import nucleusteq.com.grievance.entity.Department;
import nucleusteq.com.grievance.exception.BadRequestError;
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
  public Department save(Integer userId, Department department) {
    Department tempDepartment;
    //try {
    String deptName = department.getDeptName().toUpperCase();
    department.setDeptName(deptName);
    if (departmentRepo.isAdmin(userId) != 1) {
      throw new BadRequestError("You are not authorized to add department.");
    }

    tempDepartment = departmentRepo.getDepartmentByName(department.getDeptName());
    if (tempDepartment == null) 
    	return departmentRepo.save(department);
    else 
    	throw new BadRequestError("Department Already Exists");
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
  public void delete(Integer userId, Integer deptId) {
    if (departmentRepo.isAdmin(userId) != 1) {
      throw new BadRequestError("You are not authorized to delete department.");
    }
    
    departmentRepo.deleteById(deptId);
    return;
  }
}
