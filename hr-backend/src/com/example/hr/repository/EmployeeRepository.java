package com.example.hr.repository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.example.hr.entity.Employee;
import com.example.hr.exception.EmployeeNotFoundException;
import com.example.hr.exception.ErrorCode;

@Stateless
public class EmployeeRepository {
	@PersistenceContext(unitName = "hrPU")
	private EntityManager em;

	public Employee findEmployeeById(Long id) {
		Employee emp = em.find(Employee.class, id);
		if (Objects.isNull(emp))
			throw new EmployeeNotFoundException("Employee is not found", ErrorCode.EMPLOYEE_NOT_FOUND,
					"a2961002-f446-454f-8270-024d440df8a3");
		return emp;
	}

	public Employee findEmployeeByIdentity(String identity) {
		Employee emp = em.createNamedQuery("Employee.findByIdentity", Employee.class).setParameter("identity", identity)
				.getSingleResult();
		if (Objects.isNull(emp))
			throw new EmployeeNotFoundException("Employee is not found", ErrorCode.EMPLOYEE_NOT_FOUND,
					"9617ecb0-57cf-4b80-8f43-1baac898e914");
		return emp;
	}

	public List<Employee> findEmployees(int pageNo, int pageSize) {
		return em.createNamedQuery("Employee.findAll", Employee.class).setFirstResult(pageNo * pageSize)
				.setMaxResults(pageSize).getResultList();
	}

	public Stream<Employee> getEmployees(int pageNo, int pageSize) {
		return em.createNamedQuery("Employee.findAll", Employee.class).setFirstResult(pageNo * pageSize)
				.setMaxResults(pageSize).getResultStream();
	}

	@Transactional
	public Employee addEmployee(Employee employee) {
		employee.setId(null);
		em.persist(employee);
		return employee;
	}

	@Transactional
	public Employee updateEmployee(Employee employee) {
		Long id = employee.getId();
		Employee managedEmp = em.find(Employee.class, id);
		if (Objects.isNull(managedEmp))
			throw new EmployeeNotFoundException("Employee is not found", ErrorCode.EMPLOYEE_NOT_FOUND,
					"d70e5de4-8ac3-4e71-910b-5a4d70b11d2b");
		managedEmp.setSalary(employee.getSalary());
		managedEmp.setFulltime(employee.isFulltime());
		managedEmp.setPhoto(employee.getPhoto());
		managedEmp.setDepartment(employee.getDepartment());
		managedEmp.setIban(employee.getIban());
		return em.merge(managedEmp);
	}

	@Transactional
	public Employee removeEmployee(Employee employee) {
		Long id = employee.getId();
		Employee managedEmp = em.find(Employee.class, id);
		if (Objects.isNull(managedEmp))
			throw new EmployeeNotFoundException("Employee is not found", ErrorCode.EMPLOYEE_NOT_FOUND,
					"70539a1d-e1a4-4c3e-a72a-c94e0c99fc15");
		em.remove(managedEmp);
		return managedEmp;
	}
}
