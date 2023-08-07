package com.example.API.service;

import java.util.List;
import java.util.Optional;

import com.example.API.entity.Employee;


public interface EmployeeService {
	public Employee save(Employee employee);
	public List<Employee> getAll();
	public List<Employee> saveAll(List<Employee> allEmployee);
	public Optional<Employee> getById(int id);
	public void deleteById(int id);
	public void deleteAll();
	public Employee updateById(Employee employee,int Id);
	
}
