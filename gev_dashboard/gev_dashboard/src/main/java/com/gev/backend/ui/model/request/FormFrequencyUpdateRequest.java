package com.gev.backend.ui.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class FormFrequencyUpdateRequest {
    
    @NotBlank(message = "Form Access Public id is required.")
    private String formAccessPublicId;
    
    @NotBlank(message = "Frequency id is required.")
    private String frequencyPublicId;
    
    @NotNull(message = "User id is required.")
    private Integer modifiedBy;
    
    public String getFormAccessPublicId() {
        return formAccessPublicId;
    }
    
    public void setFormAccessPublicId(String formAccessPublicId) {
        this.formAccessPublicId = formAccessPublicId;
    }
    
    public String getFrequencyPublicId() {
        return frequencyPublicId;
    }
    
    public void setFrequencyPublicId(String frequencyPublicId) {
        this.frequencyPublicId = frequencyPublicId;
    }
    
    public Integer getModifiedBy() {
        return modifiedBy;
    }
    
    public void setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
    
}
