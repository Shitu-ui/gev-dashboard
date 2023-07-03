package com.gev.backend.ui.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class SubLabelUpdateRequest {
    
    @NotBlank(message = "SubLabel public id is required.")
    private String subLabelPublicId;
    
    @NotBlank(message = "SubLabel name is required.")
    @Pattern(regexp = "^[a-zA-Z\\s]{1,25}$", message = "Invalid pattern. Only alphanumeric characters are allowed.")
    private String subLabelName;
    
    @NotNull(message = "User id is required.")
    private Integer modifiedBy;
    
    public String getSubLabelPublicId() {
        return subLabelPublicId;
    }
    
    public void setSubLabelPublicId(String subLabelPublicId) {
        this.subLabelPublicId = subLabelPublicId;
    }
    
    public String getSubLabelName() {
        return subLabelName;
    }
    
    public void setSubLabelName(String subLabelName) {
        this.subLabelName = subLabelName;
    }
    
    public Integer getModifiedBy() {
        return modifiedBy;
    }
    
    public void setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
    
}
