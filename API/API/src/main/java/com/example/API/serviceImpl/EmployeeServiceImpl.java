package com.example.API.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.API.entity.Employee;
import com.example.API.repository.EmployeeRepo;
import com.example.API.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	
	
	public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
		super();
		this.employeeRepo = employeeRepo;
	}

	@Override
	public Employee save(Employee employee) {
		
		return employeeRepo.save(employee);
	}

	@Override
	public List<Employee> getAll() {
		
		return employeeRepo.findAll();
	}

	@Override
	public List<Employee> saveAll(List<Employee> allEmployee) {
		
		return employeeRepo.saveAll(allEmployee);
	}

	@Override
	public Optional<Employee> getById(int id) {
		
		return employeeRepo.findById(id);
	}

	@Override
	public void deleteById(int id) {
		 employeeRepo.deleteById(id);
		 return ;
		
	}

	@Override
	public void deleteAll() {
		
		employeeRepo.deleteAll();
		return ;
	}

	@Override
	public Employee updateById(Employee employee, int id) {
		
		Optional<Employee> tempEmp ;
		Employee emp;
		tempEmp = employeeRepo.findById(id);
		emp=tempEmp.get();
		System.out.println(emp.toString());
		emp.setName(employee.getName());
		emp.setAddress(employee.getAddress());
		emp.setSalary(employee.getSalary());
		return employeeRepo.save(emp);
	}

}
