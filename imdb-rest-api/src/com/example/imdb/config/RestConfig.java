package com.example.imdb.config;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

// http://localhost:8080/imdb/api/v1/...
// JAX-RS Configuration 
@ApplicationPath("/api/v1")
public class RestConfig extends Application {

}
