package com.example.API.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.API.entity.Employee;
import com.example.API.service.EmployeeService;

@Controller
@RequestMapping("/api/employee")
@RestController()
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	@PostMapping("/save")
	public  Employee save(@RequestBody Employee employee)
	{
		return employeeService.save(employee);
	}
	
	@GetMapping("/getAll")
	public List<Employee> getAll()
	{
		return employeeService.getAll();
	}
	
	@PostMapping("/saveAll")
	public  List<Employee> saveAll(@RequestBody List<Employee> allEmployee)
	{
		return employeeService.saveAll(allEmployee);
	}
	
	@GetMapping("/{id}")
	public Optional<Employee> getById(@PathVariable("id") int id)
	{
		
		return employeeService.getById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void>  deleteById(@PathVariable("id") int id)
	{
		try {
			employeeService.deleteById(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
	@DeleteMapping("/deleteAll")
	public ResponseEntity<Void>  deleteAll()
	{
		try {
			employeeService.deleteAll();
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
	@PutMapping("/update/{id}")
	public Employee updateById(@RequestBody Employee employee,@PathVariable("id") int id )
	{
		return employeeService.updateById(employee, id);
	}
}
