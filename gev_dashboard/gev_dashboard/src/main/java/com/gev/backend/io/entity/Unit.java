package com.gev.backend.io.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "unit")
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "unit_private_id")
    private Integer unitPrivateId;
    
    @Column(name = "unit_public_id", unique = true, nullable = false)
    private String unitPublicId;
    
    @Column(name = "unit_name", unique = true, nullable = false)
    private String unitName;
    
    @Column(name = "unit_abbrev", unique = true, nullable = false)
    private Integer unitAbbrev;
    
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
    
    public Unit() {
    }
    
    public Integer getUnitPrivateId() {
        return unitPrivateId;
    }
    
    public void setUnitPrivateId(Integer unitPrivateId) {
        this.unitPrivateId = unitPrivateId;
    }
    
    public String getUnitPublicId() {
        return unitPublicId;
    }
    
    public void setUnitPublicId(String unitPublicId) {
        this.unitPublicId = unitPublicId;
    }
    
    public String getUnitName() {
        return unitName;
    }
    
    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }
    
    public Integer getUnitAbbrev() {
        return unitAbbrev;
    }
    
    public void setUnitAbbrev(Integer unitAbbrev) {
        this.unitAbbrev = unitAbbrev;
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
