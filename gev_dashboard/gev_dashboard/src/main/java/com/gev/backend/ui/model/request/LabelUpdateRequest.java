package com.gev.backend.ui.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class LabelUpdateRequest {
    
    @NotBlank(message = "Label public id is required.")
    private String labelPublicId;
    
    @NotBlank(message = "Label name is required.")
    @Pattern(regexp = "^[a-zA-Z\\s]{1,25}$", message = "Invalid pattern. Only alphanumeric characters are allowed.")
    private String labelName;
    
    @NotNull(message = "User id is required.")
    private Integer modifiedBy;
    
    public String getLabelPublicId() {
        return labelPublicId;
    }
    
    public void setLabelPublicId(String labelPublicId) {
        this.labelPublicId = labelPublicId;
    }
    
    public String getLabelName() {
        return labelName;
    }
    
    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }
    
    public Integer getModifiedBy() {
        return modifiedBy;
    }
    
    public void setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
    
}
