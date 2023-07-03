package com.gev.backend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class InvalidLabelCreateRequest extends RuntimeException {
    
    private static final long serialVersionUID = 1L;
    
    private String message;
    
    public InvalidLabelCreateRequest(String message) {
        super(message);
    }
    
    public InvalidLabelCreateRequest(String message, Throwable cause) {
        super(message, cause);
    }
    
    
}

