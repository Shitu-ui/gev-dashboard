package com.gev.backend.exceptions;


public enum ErrorMessages {

    DUPLICATE_ID("Duplicate Id"),
    PLEASE_PROVIDE_LABEL_ID("Please provide label Id");

    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    private ErrorMessages(String errorMessage) {
        this.errorMessage = errorMessage;
    }


}

