package com.gev.backend.exceptions;

public enum ErrorMessages {
    
    DUPLICATE_ID("Duplicate Id"), PLEASE_PROVIDE_LABEL_ID("Please provide label Id"),
    PLEASE_PROVIDE_VALID_ID("Please provide valid Id"),
    THIS_LABEL_HAS_SOME_SUB_LABELS("this labels has some sublabels"),
    LABEL_WITH_GIVEN_ID_DOES_NOT_EXISTS("Label with given Id does not exist"),
    
    FREQUENCY_WITH_GIVEN_ID_DOES_NOT_EXISTS("Frequency with given Id does not exists"),
    FORM_WITH_GIVEN_ID_DOES_NOT_EXISTS("Form with given id does not exist");
    private String errorMessage;
    
    private ErrorMessages(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    
    public String getErrorMessage() {
        return errorMessage;
    }
    
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    
    
}

