package com.example.lottery.application;

import javax.annotation.security.DeclareRoles;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api/v1")
@ApplicationScoped
@DeclareRoles({ "webuser", "admin" })
public class LotteryApplication extends Application {

}
