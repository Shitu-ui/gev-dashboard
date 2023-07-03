package com.gev.backend.ui.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserAccessDeleteRequest {
    
    @NotBlank(message = "Form Access Public id is required.")
    private String formAccessPublicId;
    
    @NotBlank(message = "Please provide user id")
    private Integer modifiedBy;
    
    public String getFormAccessPublicId() {
        return formAccessPublicId;
    }
    
    public void setFormAccessPublicId(String formAccessPublicId) {
        this.formAccessPublicId = formAccessPublicId;
    }
    
    public Integer getModifiedBy() {
        return modifiedBy;
    }
    
    public void setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}
