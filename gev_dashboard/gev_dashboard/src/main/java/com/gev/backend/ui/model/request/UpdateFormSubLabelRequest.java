package com.gev.backend.ui.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UpdateFormSubLabelRequest {
    
    @NotBlank(message = "Form public id is required.")
    private String formPublicId;
    
    @NotBlank(message = "SubLabel public id is required.")
    private Integer subLabelId;
    
    @NotBlank(message = "User Id is required.")
    private Integer modifiedBy;
    
    public String getFormPublicId() {
        return formPublicId;
    }
    
    public void setFormPublicId(String formPublicId) {
        this.formPublicId = formPublicId;
    }
    
    public Integer getSubLabelId() {
        return subLabelId;
    }
    
    public void setSubLabelId(Integer subLabelId) {
        this.subLabelId = subLabelId;
    }
    
    public Integer getModifiedBy() {
        return modifiedBy;
    }
    
    public void setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}
