package nucleusteq.com.grievance.serviceimpl;

import java.util.List;
import java.util.Locale;
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
  public DepartmentServiceImpl(
      final DepartmentRepo departmentRepoParam) {
    super();
    this.departmentRepo = departmentRepoParam;
  }

  /**
   * to save Department.
   */
  @Override
  public Department save(
      final Integer userId,
      final String password,
      final Department department) {
    Department tempDepartment;
    //try {
    Locale locale = Locale.ENGLISH;
    String deptName = department.getDeptName().toUpperCase(locale);
    department.setDeptName(deptName);
    if (departmentRepo.isAdmin(userId, password) != 1) {
      throw new BadRequestError("You are not authorized to add department.");
    }

    tempDepartment = departmentRepo
                     .getDepartmentByName(department.getDeptName());
    if (tempDepartment == null) {
      return departmentRepo.save(department);
    } else {
      throw new BadRequestError("Department Already Exists");
    }
    //} catch (Exception e) {
    //  System.out.println(e.getMessage());
    //}
    //return null;
  }

  /**
   * to get department by department name.
   */
  @Override
  public Department getDepartmentByName(final String name) {
    Department department;
    try {
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
  public void delete(
      final Integer userId,
      final String password,
      final Integer deptId) {
    if (departmentRepo.isAdmin(userId, password) != 1) {
      throw new BadRequestError("You are not authorized to delete department.");
    }

    departmentRepo.deleteById(deptId);
    return;
  }
}
