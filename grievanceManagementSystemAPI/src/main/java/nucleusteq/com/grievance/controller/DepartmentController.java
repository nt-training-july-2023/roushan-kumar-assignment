package nucleusteq.com.grievance.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import nucleusteq.com.grievance.entity.Department;
import nucleusteq.com.grievance.exception.BadRequestError;
import nucleusteq.com.grievance.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserController.
 *
 * @author roush
 * @version 1.0.0
 */

@RestController
@RequestMapping("/api/department")
@CrossOrigin(origins = "http://localhost:3000")
public class DepartmentController {

/**
   * Service for managing departments.
   */
  @Autowired
  private DepartmentService departmentService;

  /**
   * Get a list of all departments.
   *
   * @return A list of all departments.
   */
  @GetMapping("/all")
  public List<Department> getAllDepartment() {
    return departmentService.getAllDepartment();
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
  @PostMapping("/save/{userId}")
  public Department saveDepartment(
    @PathVariable final Integer userId,
    @RequestBody final Department department,
    final HttpServletRequest httpHeaders
  ) {
//    String password,username;
//    if (
//      httpHeaders.getHeader("password") == null
//      || httpHeaders.getHeader("password").equals("")
//    ) {
//      throw new BadRequestError("Header is not found.");
//    }
//    password = httpHeaders.getHeader("password");
//    username = httpHeaders.getHeader("username");
//
//     System.out.println("Header Password: " + password +" "+ username);
//     

    return departmentService.save(department);
  }

  /**
   * Delete a department.
   *
   * @param userId      The ID of the user making the request.
   * @param deptId      The ID of the department to be deleted.
   * @param httpHeaders The HTTP headers,
   *      including the "password" header for auth.
   */
  @DeleteMapping("/delete/{deptId}/{userId}")
  public void deleteDepartment(
    @PathVariable("userId") final Integer userId,
    @PathVariable("deptId") final Integer deptId,
    final HttpServletRequest httpHeaders
  ) {
    String password;
    if (
      httpHeaders.getHeader("password") == null
      || httpHeaders.getHeader("password").equals("")
    ) {
      throw new BadRequestError("Header is not found.");
    }
    password = httpHeaders.getHeader("password");

    departmentService.delete(userId, password, deptId);
  }
}
