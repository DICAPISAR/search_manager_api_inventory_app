package com.dicapisar.SearchManagerAPI.exceptions;

import org.springframework.http.HttpStatus;

public class SessionErrorException extends SearchManagerException{

    public SessionErrorException() {
        super("Session error, try to login again.", HttpStatus.FORBIDDEN);
    }
}
