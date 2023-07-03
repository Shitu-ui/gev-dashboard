package com.gev.backend.ui.model.response;

import com.gev.backend.io.entity.Label;

public class LabelCreateResponse {
    
    private String labelPublicId;
    private String labelName;
    private Integer createdBy;
    private String createdOn;
    
    public LabelCreateResponse(String labelPublicId, String labelName, Integer createdBy, String createdOn) {
        this.labelPublicId = labelPublicId;
        this.labelName = labelName;
        this.createdBy = createdBy;
        this.createdOn = createdOn;
    }
    
    public LabelCreateResponse(Label label) {
        this.labelPublicId = label.getLabelPublicId();
        this.labelName = label.getLabelName();
        this.createdBy = label.getCreatedBy();
        this.createdOn = label.getCreatedOn();
    }
    
    public String getLabelName() {
        return labelName;
    }
    
    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }
    
    public Integer getCreatedBy() {
        return createdBy;
    }
    
    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }
    
    public String getCreatedOn() {
        return createdOn;
    }
    
    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }
    
    public String getLabelPublicId() {
        return labelPublicId;
    }
    
    public void setLabelPublicId(String labelPublicId) {
        this.labelPublicId = labelPublicId;
    }
}
