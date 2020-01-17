package com.example.hr.dto;

public class RestErrorMessage {
    private String message;
    private String i18n;
    private String debug;

    public RestErrorMessage(String message, String i18n, String debug) {
        this.message = message;
        this.i18n = i18n;
        this.debug = debug;
    }

    public String getMessage() {
        return message;
    }

    public String getI18n() {
        return i18n;
    }

    public String getDebug() {
        return debug;
    }
}

