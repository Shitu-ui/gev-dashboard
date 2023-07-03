package com.gev.backend.io.entity;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public class Field {
    
    @NotBlank(message = "Please provide the fieldType")
    private Integer fieldType;
    
    @NotBlank(message = "Please provide the field name")
    private String fieldName;
    
    @NotBlank(message = "Please provide the unit")
    private String unit;
    
    @NotBlank(message = "Please provide the list of field options to be addedsss")
    private List<String> fieldOptions;
}
