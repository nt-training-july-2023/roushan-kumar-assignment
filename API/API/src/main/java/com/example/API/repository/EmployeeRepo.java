package com.example.API.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.API.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

}
