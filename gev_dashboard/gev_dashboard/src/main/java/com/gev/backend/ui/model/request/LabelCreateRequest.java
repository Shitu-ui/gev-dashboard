package com.gev.backend.ui.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class LabelCreateRequest {
    
    @NotBlank(message = "Label name is required.")
    @Pattern(regexp = "^[a-zA-Z\\s]{1,25}$", message = "Invalid pattern. Only alphanumeric characters are allowed.")
    private String labelName;
    
    @NotNull(message = "User id is required.")
    private Integer createdBy;
    
    @NotNull(message = "Location id is required.")
    private Integer location;
    
    @NotNull(message = "Department id is required.")
    private Integer department;
    
    public String getLabelName() {
        return labelName;
    }
    
    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }
    
    public Integer getCreatedBy() {
        return createdBy;
    }
    
    public void setCreatedBy(Integer createBy) {
        this.createdBy = createBy;
    }
    
    public Integer getLocation() {
        return location;
    }
    
    public void setLocation(Integer location) {
        this.location = location;
    }
    
    public Integer getDepartment() {
        return department;
    }
    
    public void setDepartment(Integer department) {
        this.department = department;
    }
    
}
