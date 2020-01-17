package com.example.lottery.security;

public final class Constants {

    public static final String AUTHORIZATION_HEADER = "Authorization";

    public static final String BEARER = "Bearer ";

    public static final String ADMIN = "ADMIN";

    public static final String WEB_USER = "WEBUSER";

    public static final int REMEMBERME_VALIDITY_SECONDS = 24 * 60 * 60; //24 hours

    // Load the TokenProvider configuration[secretKey,tokenValidity] and REMEMBERME_VALIDITY_SECONDS from config
}
