package nucleusteq.com.grievance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import nucleusteq.com.grievance.entity.Department;
import nucleusteq.com.grievance.service.DepartmentService;

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

  @Autowired
  private DepartmentService departmentSevice;
  
  @GetMapping("/all")
  public List<Department> getAllDepartment() {
    return departmentSevice.getAllDepartment();
  }

  @PostMapping("/save/{userId}")
  public Department saveDepartment(@PathVariable Integer userId,
  		@RequestBody Department department) {
  	
    return departmentSevice.save(userId,department);
  }

  @DeleteMapping("/delete/{deptId}/{userId}")
  public void deleteDepartment(
  		@PathVariable("userId") Integer userId,
  		@PathVariable("deptId") Integer deptId)
  {
     departmentSevice.delete(userId,deptId);
     return;
  }
}

