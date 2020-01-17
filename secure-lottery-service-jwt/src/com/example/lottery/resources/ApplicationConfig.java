package com.example.lottery.resources;

import static com.example.lottery.security.Constants.ADMIN;
import static com.example.lottery.security.Constants.WEB_USER;

import javax.annotation.security.DeclareRoles;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@DeclareRoles({ADMIN, WEB_USER})
@ApplicationPath(value = "/api/v1")
public class ApplicationConfig extends Application {
}
