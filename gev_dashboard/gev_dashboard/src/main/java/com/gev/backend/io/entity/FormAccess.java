package com.gev.backend.io.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "form_access")
public class FormAccess {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "form_access_private_id")
    private Integer formAccessPrivateId;
    
    @Column(name = "form_access_public_id", unique = true, nullable = false)
    private String formAccessPublicId;
    
    @ManyToOne
    @JoinColumn(name = "form_id", nullable = false)
    private Form form;
    
    @Column(name = "user_id", nullable = false)
    private Integer userId;
    
    @ManyToOne
    @JoinColumn(name = "frequency_id", nullable = false)
    private Frequency frequency;
    
    @ManyToOne
    @JoinColumn(name = "unit_id", nullable = false)
    private Unit unit;
    
    @Column(name = "fill_access", nullable = false)
    private Boolean fillAccess;
    
    @Column(name = "update_access", nullable = false)
    private Boolean updateAccess;
    
    @Column(name = "delete_access", nullable = false)
    private Boolean deleteAccess;
    
    @Column(name = "created_on", nullable = false)
    private String createdOn;
    
    @Column(name = "created_by", nullable = false)
    private Integer createdBy;
    
    @Column(name = "modified_on", nullable = false)
    private String modifiedOn;
    
    @Column(name = "modified_by", nullable = false)
    private Integer modifiedBy;
    
    @Column(name = "mark_for_delete", nullable = false)
    private Boolean markForDelete;
    // Getters and Setters
    // ...
    
    public FormAccess() {
    }
    
    public Integer getFormAccessPrivateId() {
        return formAccessPrivateId;
    }
    
    public void setFormAccessPrivateId(Integer formAccessPrivateId) {
        this.formAccessPrivateId = formAccessPrivateId;
    }
    
    public String getFormAccessPublicId() {
        return formAccessPublicId;
    }
    
    public void setFormAccessPublicId(String formAccessPublicId) {
        this.formAccessPublicId = formAccessPublicId;
    }
    
    public Form getForm() {
        return form;
    }
    
    public void setForm(Form form) {
        this.form = form;
    }
    
    public Integer getUserId() {
        return userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    
    public Frequency getFrequency() {
        return frequency;
    }
    
    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
    }
    
    public Unit getUnit() {
        return unit;
    }
    
    public void setUnit(Unit unit) {
        this.unit = unit;
    }
    
    public Boolean getFillAccess() {
        return fillAccess;
    }
    
    public void setFillAccess(Boolean fillAccess) {
        this.fillAccess = fillAccess;
    }
    
    public Boolean getUpdateAccess() {
        return updateAccess;
    }
    
    public void setUpdateAccess(Boolean updateAccess) {
        this.updateAccess = updateAccess;
    }
    
    public Boolean getDeleteAccess() {
        return deleteAccess;
    }
    
    public void setDeleteAccess(Boolean deleteAccess) {
        this.deleteAccess = deleteAccess;
    }
    
    public String getCreatedOn() {
        return createdOn;
    }
    
    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }
    
    public Integer getCreatedBy() {
        return createdBy;
    }
    
    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }
    
    public String getModifiedOn() {
        return modifiedOn;
    }
    
    public void setModifiedOn(String modifiedOn) {
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
