package com.example.hr.resources;

import java.util.List;
import java.util.Objects;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.example.hr.entity.Employee;
import com.example.hr.repository.EmployeeRepository;

@Path("/employees")
@RequestScoped
public class EmployeeResource {
	@Inject
	private EmployeeRepository employeeRepo;

	// /api/v1/employees/11111111110?type=identity
	// /api/v1/employees/1?type=id
	// /api/v1/employees/1
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Employee getEmployee(@PathParam("id") String id, @QueryParam("type") String type) {
		if (Objects.isNull(type))
			type = "identity";
		switch (type) {
		case "id":
			return employeeRepo.findEmployeeById(Long.parseLong(id));
		case "identity":
			return employeeRepo.findEmployeeByIdentity(id);
		default:
			return employeeRepo.findEmployeeById(Long.parseLong(id));
		}
	}

	// /api/v1/employees?page=0&size=10
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getEmployees(@QueryParam("page") int page, @QueryParam("size") int size) {
		return employeeRepo.findEmployees(page, size);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Employee createEmployee(@Valid Employee emp) {
		return employeeRepo.addEmployee(emp);
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Employee updateEmployee(@Valid Employee emp) {
		return employeeRepo.updateEmployee(emp);
	}

	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Employee deleteEmployee(@PathParam("id") String id, @QueryParam("type") String type) {
		if (Objects.isNull(type))
			type = "identity";
		switch (type) {
		case "id":
			return employeeRepo.removeEmployeeById(Long.parseLong(id));
		case "identity":
			return employeeRepo.removeEmployeeByIdentity(id);
		default:
			return employeeRepo.removeEmployeeById(Long.parseLong(id));
		}

	}
}
