package nucleusteq.com.grievance.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import nucleusteq.com.grievance.dto.DepartmentDto;
import nucleusteq.com.grievance.entity.Department;
import nucleusteq.com.grievance.service.DepartmentService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Department controller.
 *
 * @author Roushan Kumar
 * @version 1.0.0
 */

@RestController
@RequestMapping("/department")
@CrossOrigin(origins = "http://localhost:3000")
public class DepartmentController {

  /**
   * Logger instance for the TicketServiceImpl class.
   */
  private static final Logger LOGGER = Logger
      .getLogger(DepartmentController.class);

/**
   * Service for managing departments.
   */
  @Autowired
  private DepartmentService departmentService;

  /**
   * Get a list of all departments.
   *
   * @param offSet
   * @param pageSize
   * @return A list of all departments.
   */
  @GetMapping("/all")
  public List<DepartmentDto> getAllDepartment(
      @RequestParam(name = "offSet") final int offSet,
      @RequestParam(name = "pageSize") final int pageSize) {
    LOGGER.info("Getting all departments.");
    return departmentService.getAllDepartment(offSet, pageSize);
  }

  /**
   * Save a department.
   *
   * @param userId      The ID of the user making the request.
   * @param department  The department data to be saved.
   * @param httpHeaders The HTTP headers,
   *       including the "password" header for auth.
   * @return The saved department.
   */
  @PostMapping("/admin/save/{userId}")
  public Department saveDepartment(
    @PathVariable final Integer userId,
    @RequestBody final Department department,
    final HttpServletRequest httpHeaders
  ) {

    return departmentService.save(department);
  }

  /**
   * Delete a department.
   *
   * @param deptId      The ID of the department to be deleted.
   * @param httpHeaders The HTTP headers,
   *      including the "password" header for auth.
   * @return Response.
   */
  @DeleteMapping("/admin/delete/{deptId}")
  public ResponseEntity<?> deleteDepartment(
    @PathVariable("deptId") final Integer deptId,
    final HttpServletRequest httpHeaders
  ) {
    departmentService.delete(deptId);
    return  ResponseEntity.ok("Department deleted successfully.");
  }
}
