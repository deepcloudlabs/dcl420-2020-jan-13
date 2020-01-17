package com.example.hr.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.hr.entity.Employee;
import com.example.hr.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee findById(String id) {
		return employeeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Cannot find employee!"));
	}

	public List<Employee> findAll(int page, int size) {
		return employeeRepository.findAll(PageRequest.of(page, size)).getContent();
	}

	public Employee addEmployee(@Valid Employee emp) {
		String id = emp.getIdentityNo();
		Optional<Employee> found = employeeRepository.findById(id);
		if (found.isPresent())
			throw new IllegalArgumentException("Employee already exists!");
		return employeeRepository.save(emp);
	}

	public Employee updateEmployee(@Valid Employee emp) {
		String id = emp.getIdentityNo();
		Optional<Employee> found = employeeRepository.findById(id);
		if (found.isPresent()) {
			return employeeRepository.save(emp);
		}
		throw new IllegalArgumentException("Cannot find employee!");
	}

	public Employee removeById(String id) {
		Optional<Employee> emp = employeeRepository.findById(id);
		if (emp.isPresent()) {
			employeeRepository.deleteById(id);
			return emp.get();
		}
		throw new IllegalArgumentException("Cannot find employee!");
	}

}
