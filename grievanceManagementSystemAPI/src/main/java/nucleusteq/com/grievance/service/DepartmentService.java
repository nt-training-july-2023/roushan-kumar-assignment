package nucleusteq.com.grievance.service;

import java.util.List;

import nucleusteq.com.grievance.dto.DepartmentDto;
import nucleusteq.com.grievance.entity.Department;

/**
 * Department service interface.
 */
public interface DepartmentService {

  /**
   * Save department.
   *
   * @param department
   * @return response of saved details.
   */
  Department save(Department department);

  /**
   * Get department by department name.
   *
   * @param name Department name.
   * @return Department.
   */
  Department getDepartmentByName(String name);

  /**
   * Get department by department Id.
   *
   * @param id Department name.
   * @return Department.
   */
  Department getDepartmentById(Integer id);

  /**
   * Get all department.
   *
   * @param offSet
   * @param pageSize
   * @return all department.
   */
  List<DepartmentDto> getAllDepartment(Integer offSet, Integer pageSize);

  /**
   * Delete a Department.
   *
   * @param deptId as integer.
   */
  void delete(Integer deptId);
}

