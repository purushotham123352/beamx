package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Employee;
import com.example.demo.service.employeeService;

import jakarta.websocket.server.PathParam;

@Controller
@RequestMapping("/emp")
public class EmployeeController {
	@Autowired
	employeeService service;
	@GetMapping("/home")
    public String home() {
        return "home"; // This will resolve to "home.html" in the templates directory
    }
@GetMapping("/getemp/{id}")
public Employee msq(@PathVariable int id) {
	Employee emp1=service.getemp(id);
	return emp1;
}
@PostMapping("/addemp")
public String addemp(@RequestBody Employee emp) {
	service.saveEmp(emp);
	return "redirect:/success";
}
@PostMapping("/addemphome")
public String adduser(@PathParam("id") int id,
		@PathParam("firstName") String firstName,@PathParam("lastName") String lastName,@PathParam("role") String role,@PathParam("salary") int salary) {
	Employee  e=new Employee();
	e.setId(id);
	e.setFirstName(firstName);
	e.setLastName(lastName);
	e.setRole(role);
	e.setSalary(salary);
	service.saveEmp(e);
	
	return "success";
}

@DeleteMapping("/delete")
public String deleteEmp(@PathParam(value = "id") int id) {
	service.deleteEmp(id);
	return "delete success";
}
@PutMapping("/update/{id}")
public String update(@PathVariable int id,@RequestBody Employee emp) {
	service.updateemp(id, emp);
	return "Successfully updated";
}
}
