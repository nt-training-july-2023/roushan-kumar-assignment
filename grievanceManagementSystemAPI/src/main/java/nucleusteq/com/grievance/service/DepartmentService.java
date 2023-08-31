package nucleusteq.com.grievance.service;

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
}

