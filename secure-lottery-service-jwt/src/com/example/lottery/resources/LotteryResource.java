package com.example.lottery.resources;

import java.security.Principal;
import java.util.Objects;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.example.lottery.service.LotteryService;

@Path("/numbers")
@DeclareRoles({"webuser","admin"})
public class LotteryResource {

	@Inject
	private LotteryService lotteryService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLotteryNumbers(@Context HttpServletRequest request) {
		Principal principal = request.getUserPrincipal();
		if (Objects.nonNull(principal) && request.isUserInRole("webuser")) {
			return Response.ok(lotteryService.draw()).build();
		}
		return Response.status(Response.Status.FORBIDDEN).entity("You are not allowed!").build();
	}

	@GET
	@Path("{n}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMultipleLotteryNumbers(@PathParam("n") int n, @Context HttpServletRequest request) {
		Principal principal = request.getUserPrincipal();
		if (Objects.nonNull(principal) && request.isUserInRole("admin")) {
			return Response.ok(lotteryService.draw(n)).build();
		}
		return Response.status(Response.Status.FORBIDDEN).entity("You are not allowed!").build();
	}
	@GET
	@Path("alternative/{n}")
	@Produces(MediaType.APPLICATION_JSON)
	@RolesAllowed({"admin"})
	public Response getMultipleLotteryNumbers2(@PathParam("n") int n) {
		return Response.ok(lotteryService.draw(n)).build();
	}
}
