package com.example.hr.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hr.entity.Employee;
import com.example.hr.service.EmployeeService;
import com.example.hr.validation.TcKimlikNo;

@RestController
@RequestMapping("employees")
@CrossOrigin
@Validated
public class EmployeeResource {
	@Autowired
	private EmployeeService employeeSrv;

	@GetMapping("{id}")
	public Employee getEmployee(@PathVariable @Validated @TcKimlikNo String id) {
			return employeeSrv.findById(id);
	}

	@GetMapping
	public List<Employee> getEmployees(@RequestParam int page,
			@RequestParam int size) {
		return employeeSrv.findAll(page, size);
	}

	@PostMapping
	public Employee createEmployee(@RequestBody Employee emp) {
		return employeeSrv.addEmployee(emp);
	}

	@PutMapping
	public Employee updateEmployee(@RequestBody Employee emp) {
		return employeeSrv.updateEmployee(emp);
	}

	@DeleteMapping("{id}")
	public Employee deleteEmployee(@PathVariable @Validated @TcKimlikNo String id) {		
		return employeeSrv.removeById(id);
	}
}
