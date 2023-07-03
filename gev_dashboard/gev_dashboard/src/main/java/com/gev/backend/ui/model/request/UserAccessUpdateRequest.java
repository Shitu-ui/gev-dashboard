package com.gev.backend.ui.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserAccessUpdateRequest {
    
    @NotBlank(message = "Form Access Public id is required.")
    private String formAccessPublicId;
    
    @NotBlank(message = "Please provide the fill access")
    private Boolean fillAccess;
    
    @NotBlank(message = "Please provide the update access")
    private Boolean updateAccess;
    
    @NotBlank(message = "Please provide the delete access")
    private Boolean deleteAccess;
    
    @NotBlank(message = "Please provide the user id")
    private Integer modifiedBy;
    
    public String getFormAccessPublicId() {
        return formAccessPublicId;
    }
    
    public void setFormAccessPublicId(String formAccessPublicId) {
        this.formAccessPublicId = formAccessPublicId;
    }
    
    public Boolean getFillAccess() {
        return fillAccess;
    }
    
    public void setFillAccess(Boolean fillAccess) {
        this.fillAccess = fillAccess;
    }
    
    public Boolean getUpdateAccess() {
        return updateAccess;
    }
    
    public void setUpdateAccess(Boolean updateAccess) {
        this.updateAccess = updateAccess;
    }
    
    public Boolean getDeleteAccess() {
        return deleteAccess;
    }
    
    public void setDeleteAccess(Boolean deleteAccess) {
        this.deleteAccess = deleteAccess;
    }
    
    public Integer getModifiedBy() {
        return modifiedBy;
    }
    
    public void setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
    
}
