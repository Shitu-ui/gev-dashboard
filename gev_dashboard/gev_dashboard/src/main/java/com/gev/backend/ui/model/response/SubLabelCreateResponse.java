package com.gev.backend.ui.model.response;

import com.gev.backend.io.entity.SubLabel;

public class SubLabelCreateResponse {
    
    private String subLabelPublicId;
    private String subLabelName;
    
    private Integer createdBy;
    private String createdOn;
    
    public SubLabelCreateResponse(String subLabelPublicId, String subLabelName, String labelPublicId, String labelName, Integer createdBy, String createdOn) {
        this.subLabelPublicId = subLabelPublicId;
        this.subLabelName = subLabelName;
        this.createdBy = createdBy;
        this.createdOn = createdOn;
    }
    
    public SubLabelCreateResponse(SubLabel subLabel) {
        this.subLabelPublicId = subLabel.getSubLabelPublicId();
        this.subLabelName = subLabel.getSubLabelName();
        this.createdBy = subLabel.getCreatedBy();
        this.createdOn = subLabel.getCreatedOn();
    }
    
    public String getPublicId() {
        return subLabelPublicId;
    }
    
    public void setPublicId(String publicId) {
        this.subLabelPublicId = publicId;
    }
    
    public String getSubLabelName() {
        return subLabelName;
    }
    
    public void setSubLabelName(String subLabelName) {
        this.subLabelName = subLabelName;
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
    
}
