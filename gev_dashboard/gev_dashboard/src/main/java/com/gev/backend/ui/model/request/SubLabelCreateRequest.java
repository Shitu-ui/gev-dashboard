package com.gev.backend.ui.model.request;

import com.gev.backend.io.entity.Label;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class SubLabelCreateRequest {
    
    @NotBlank(message = "Sub-Label name is required.")
    @Pattern(regexp = "^[a-zA-Z\\s]{1,25}$", message = "Invalid pattern. Only alphanumeric characters are allowed.")
    private String subLabelName;
    //TODO : why we are passing private or public-id
    
    @NotNull(message = "Label id is required.")
    private Label label;
    @NotNull(message = "User id is required.")
    private Integer createdBy;
    
    public SubLabelCreateRequest(String subLabelName, Label label, Integer createdBy) {
        this.subLabelName = subLabelName;
        this.label = label;
        this.createdBy = createdBy;
    }
    
    public String getSubLabelName() {
        return subLabelName;
    }
    
    public void setSubLabelName(String subLabelName) {
        this.subLabelName = subLabelName;
    }
    
    public Label getLabel() {
        return label;
    }
    
    public void setLabel(Label label) {
        this.label = label;
    }
    
    public Integer getCreatedBy() {
        return createdBy;
    }
    
    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }
}
