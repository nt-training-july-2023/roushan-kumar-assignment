package nucleusteq.com.grievance.service;

import java.util.List;

import nucleusteq.com.grievance.entity.Department;

/**
 * Department service interface.
 */
public interface DepartmentService {

  /*
   * save department.
   */
  Department save(Department department);

  /*
   * get department by department name.
   */
  Department getDepartmentByName(String name);

  /**
   * get all department.
   *
   * @return all department.
   */
  List<Department> getAllDepartment();

  /**
   * delete Department.
   *
   * @param deptId as integer
   * @return department
   */
  void delete(Integer deptId);
}

