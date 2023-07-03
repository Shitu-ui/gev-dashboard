package com.gev.backend.io.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "frequency")
public class Frequency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "frequency_private_id")
    private Integer frequencyPrivateId;
    
    @Column(name = "frequency_public_id", unique = true, nullable = false)
    private String frequencyPublicId;
    
    @Column(name = "frequency_name", unique = true, nullable = false)
    private String frequencyName;
    
    @Column(name = "frequency_duration", unique = true, nullable = false)
    private Integer frequencyDuration;
    
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
    
    public Frequency() {
    }
    
    public Integer getFrequencyPrivateId() {
        return frequencyPrivateId;
    }
    
    public void setFrequencyPrivateId(Integer frequencyPrivateId) {
        this.frequencyPrivateId = frequencyPrivateId;
    }
    
    public String getFrequencyPublicId() {
        return frequencyPublicId;
    }
    
    public void setFrequencyPublicId(String frequencyPublicId) {
        this.frequencyPublicId = frequencyPublicId;
    }
    
    public String getFrequencyName() {
        return frequencyName;
    }
    
    public void setFrequencyName(String frequencyName) {
        this.frequencyName = frequencyName;
    }
    
    public Integer getFrequencyDuration() {
        return frequencyDuration;
    }
    
    public void setFrequencyDuration(Integer frequencyDuration) {
        this.frequencyDuration = frequencyDuration;
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
