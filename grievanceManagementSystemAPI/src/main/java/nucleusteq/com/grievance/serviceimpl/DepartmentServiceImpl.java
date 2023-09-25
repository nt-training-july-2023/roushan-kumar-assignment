package nucleusteq.com.grievance.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import nucleusteq.com.grievance.dto.DepartmentDto;
import nucleusteq.com.grievance.entity.Department;
import nucleusteq.com.grievance.exception.BadRequestError;
import nucleusteq.com.grievance.exception.InternalServerError;
import nucleusteq.com.grievance.repository.DepartmentRepo;
import nucleusteq.com.grievance.service.DepartmentService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Department service impl class.
 *
 * @author Roushan kumar
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

  /**
   * Logger instance for the TicketServiceImpl class.
   */
  private static final Logger LOGGER = Logger
      .getLogger(DepartmentServiceImpl.class);

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
      final Department department) {
    Department tempDepartment;
    Locale locale = Locale.ENGLISH;
    String deptName = department.getDeptName().toUpperCase(locale);
    department.setDeptName(deptName);
    tempDepartment = departmentRepo
                     .getDepartmentByName(department.getDeptName());
    if (tempDepartment == null) {
      return departmentRepo.save(department);
    } else {
      throw new BadRequestError("Department Already Exists");
    }
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
  public List<DepartmentDto> getAllDepartment(
      final Integer offSet,
      final Integer pageSize) {
    AtomicInteger serialNumber = new AtomicInteger(offSet + 1);
    List<Department> allDepartment;
    List<DepartmentDto> allDepartmentDto = new ArrayList<DepartmentDto>();
    if (pageSize == 0) {
     allDepartment = departmentRepo.findAll();
     for (Department department : allDepartment) {
       DepartmentDto departmentDto = new DepartmentDto();
       departmentDto.setSerialNumber(serialNumber.getAndIncrement());
       departmentDto.setDeptId(department.getDeptId());
       departmentDto.setDeptName(department.getDeptName());
       allDepartmentDto.add(departmentDto);
     }
     return allDepartmentDto;
    } else {

      allDepartment = departmentRepo.findAllWithPageSize(offSet, pageSize);
      for (Department department : allDepartment) {
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setSerialNumber(serialNumber.getAndIncrement());
        departmentDto.setDeptId(department.getDeptId());
        departmentDto.setDeptName(department.getDeptName());
        allDepartmentDto.add(departmentDto);
      }
      return allDepartmentDto;
    }
  }

  /**
   * delete department by id.
   */
  @Override
  public void delete(
      final Integer deptId) {
      if (!departmentRepo.findById(deptId).isPresent()) {
        throw new InternalServerError("Department not found!");
      }
      departmentRepo.deleteById(deptId);
    return;
  }

  /**
   * Get department by department Id.
   *
   * @param id Department name.
   * @return Department.
   */
  @Override
  public Department getDepartmentById(Integer id) {
  Optional<Department> department = departmentRepo.findById(id);
  if (department.isPresent()) {
     return department.get();
  }
  return null;
  }
}
