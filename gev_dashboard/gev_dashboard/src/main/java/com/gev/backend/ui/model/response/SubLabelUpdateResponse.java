package com.gev.backend.ui.model.response;

import com.gev.backend.io.entity.SubLabel;

public class SubLabelUpdateResponse {
    
    private String subLabelPublicId;
    private String subLabelName;
    
    private String labelPublicId;
    private String labelName;
    
    private Integer subLableModifiedBy;
    private String subLabelModifiedOn;
    
    public SubLabelUpdateResponse(String subLabelPublicId, String subLabelName, String labelPublicId, String labelName, Integer subLableModifiedBy, String subLabelModifiedOn) {
        this.subLabelPublicId = subLabelPublicId;
        this.subLabelName = subLabelName;
        this.labelPublicId = labelPublicId;
        this.labelName = labelName;
        this.subLableModifiedBy = subLableModifiedBy;
        this.subLabelModifiedOn = subLabelModifiedOn;
    }
    
    public SubLabelUpdateResponse(SubLabel subLabel) {
        this.subLabelPublicId = subLabel.getSubLabelPublicId();
        this.subLabelName = subLabel.getSubLabelName();
        this.labelPublicId = subLabel.getLabel().getLabelPublicId();
        this.labelName = subLabel.getLabel().getLabelName();
        this.subLableModifiedBy = subLabel.getModifiedBy();
        this.subLabelModifiedOn = subLabel.getModifiedOn();
    }
    
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
    
    public Integer getSubLableModifiedBy() {
        return subLableModifiedBy;
    }
    
    public void setSubLableModifiedBy(Integer subLableModifiedBy) {
        this.subLableModifiedBy = subLableModifiedBy;
    }
    
    public String getSubLabelModifiedOn() {
        return subLabelModifiedOn;
    }
    
    public void setSubLabelModifiedOn(String subLabelModifiedOn) {
        this.subLabelModifiedOn = subLabelModifiedOn;
    }
    
}
