package com.gev.backend.ui.model.response;

import com.gev.backend.io.entity.Label;

public class LabelUpdateResponse {
    
    private String labelPublicId;
    private String labelName;
    private Integer modifiedBy;
    
    private String modifiedOn;
    
    public LabelUpdateResponse(String labelPublicId, String labelName, Integer modifiedBy, String modifiedOn) {
        this.labelPublicId = labelPublicId;
        this.labelName = labelName;
        this.modifiedBy = modifiedBy;
        this.modifiedOn = modifiedOn;
    }
    
    public LabelUpdateResponse(Label label) {
        this.labelPublicId = label.getLabelPublicId();
        this.labelName = label.getLabelName();
        this.modifiedBy = label.getModifiedBy();
        this.modifiedOn = label.getModifiedOn();
    }
    
    public String getModifiedOn() {
        return modifiedOn;
    }
    
    public void setModifiedOn(String modifiedOn) {
        this.modifiedOn = modifiedOn;
    }
    
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
