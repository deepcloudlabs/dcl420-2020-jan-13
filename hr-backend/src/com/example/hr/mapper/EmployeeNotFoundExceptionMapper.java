package com.example.hr.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.example.hr.dto.ErrorMessage;
import com.example.hr.exception.EmployeeNotFoundException;

@Provider
public class EmployeeNotFoundExceptionMapper implements 
             ExceptionMapper<EmployeeNotFoundException>{

	@Override
	public Response toResponse(EmployeeNotFoundException e) {
		ErrorMessage errorMessage = 
				new ErrorMessage(
						e.getMessage(),
						e.getErrorCode(),
						e.getDebugCode()
				);
		return Response.status(Response.Status.NOT_FOUND)
				.entity(errorMessage).build();
	}

}
