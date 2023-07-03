package com.gev.backend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class LabelNotFoundException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;
    
    private String message;
    
    public LabelNotFoundException(String message) {
        super(message);
        this.message = message;
    }
    
    public LabelNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
