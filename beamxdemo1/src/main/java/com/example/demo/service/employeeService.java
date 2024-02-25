package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepo;

@Service
public class employeeService {
	@Autowired
	EmployeeRepo repo;
public String saveEmp(Employee emp) {
	repo.save(emp);
	return "success";
}
public Employee getemp(int id) {
	Employee emp1=repo.findById(id).orElse(null);
	return emp1;
}
public void deleteEmp(int id) {
	repo.deleteById(id);
}
public void updateemp(int id,Employee em1) {
	Employee em=repo.findById(id).orElse(null);
	em.setSalary(em1.getSalary());
	repo.save(em);
	
}
}
