package com.gev.backend.io.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "form")
public class Form {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "form_private_id")
    private Integer formPrivateId;
    
    @Column(name = "form_public_id", unique = true, nullable = false)
    private String formPublicId;
    
    @Column(name = "google_form_id", nullable = false)
    private String googleFormId;
    
    @Column(name = "google_form_link", nullable = false)
    private String googleFormLink;
    
    @Column(name = "google_form_title", nullable = false)
    private String googleFormTitle;
    
    @Column(name = "sub_label_id", nullable = false)
    private Integer subLabelId;
    
    @Column(name = "created_on", nullable = false)
    private Timestamp createdOn;
    
    @Column(name = "created_by", nullable = false)
    private Integer createdBy;
    
    @Column(name = "modified_on", nullable = false)
    private Timestamp modifiedOn;
    
    @Column(name = "modified_by", nullable = false)
    private Integer modifiedBy;
    
    @Column(name = "mark_for_delete", nullable = false)
    private Boolean markForDelete;
    // Getters and Setters
    // ...
    
    public Form() {
    }
    
    public Integer getFormPrivateId() {
        return formPrivateId;
    }
    
    public void setFormPrivateId(Integer formPrivateId) {
        this.formPrivateId = formPrivateId;
    }
    
    public String getFormPublicId() {
        return formPublicId;
    }
    
    public void setFormPublicId(String formPublicId) {
        this.formPublicId = formPublicId;
    }
    
    public String getGoogleFormId() {
        return googleFormId;
    }
    
    public void setGoogleFormId(String googleFormId) {
        this.googleFormId = googleFormId;
    }
    
    public String getGoogleFormLink() {
        return googleFormLink;
    }
    
    public void setGoogleFormLink(String googleFormLink) {
        this.googleFormLink = googleFormLink;
    }
    
    public String getGoogleFormTitle() {
        return googleFormTitle;
    }
    
    public void setGoogleFormTitle(String googleFormTitle) {
        this.googleFormTitle = googleFormTitle;
    }
    
    public Integer getSubLabelId() {
        return subLabelId;
    }
    
    public void setSubLabelId(Integer subLabelId) {
        this.subLabelId = subLabelId;
    }
    
    public Timestamp getCreatedOn() {
        return createdOn;
    }
    
    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }
    
    public Integer getCreatedBy() {
        return createdBy;
    }
    
    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }
    
    public Timestamp getModifiedOn() {
        return modifiedOn;
    }
    
    public void setModifiedOn(Timestamp modifiedOn) {
        this.modifiedOn = modifiedOn;
    }
    
    public Integer getModifiedBy() {
        return modifiedBy;
    }
    
    public void setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
    
    public Boolean getMarkForDelete() {
        return markForDelete;
    }
    
    public void setMarkForDelete(Boolean markForDelete) {
        this.markForDelete = markForDelete;
    }
}
