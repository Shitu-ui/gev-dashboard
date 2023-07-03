package com.gev.backend.ui.model.request;

import com.gev.backend.io.entity.Field;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class AddFormFieldsRequest {
    
    @NotBlank(message = "Please provide form public id")
    private String formPublicId;
    
    @NotNull(message = "Please provide the fields to be added")
    private List<Field> fields;
    
    @NotBlank(message = "Please provide the user id")
    private Integer modifiedBy;
    
    public String getFormPublicId() {
        return formPublicId;
    }
    
    public void setFormPublicId(String formPublicId) {
        this.formPublicId = formPublicId;
    }
    
    public List<Field> getFields() {
        return fields;
    }
    
    public void setFields(List<Field> fields) {
        this.fields = fields;
    }
    
    public Integer getModifiedBy() {
        return modifiedBy;
    }
    
    public void setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}
