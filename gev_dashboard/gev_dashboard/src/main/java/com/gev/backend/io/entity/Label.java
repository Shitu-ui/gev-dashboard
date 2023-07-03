package com.gev.backend.io.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.util.List;

/**
 * Label entity
 */

@Entity
@Table(name = "labels")
public class Label implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "label_private_id")
    @GenericGenerator(name = "hashed_id_generator", strategy = "com.gev.backend.utils.HashedIdGenerator")
    private Integer labelPrivateId;
    
    @Column(name = "label_public_id", nullable = false, unique = true)
    private String labelPublicId;
    
    @Column(name = "label_name", nullable = false)
    private String labelName;
    
    @Column(name = "created_by", nullable = false)
    private Integer createdBy;
    
    @CreationTimestamp
    @Column(name = "created_on", nullable = false)
    private String createdOn;
    
    @UpdateTimestamp
    @Column(name = "modified_on", nullable = false)
    private String modifiedOn;
    
    @Column(name = "modified_by")
    private Integer modifiedBy;
    
    @Column(name = "mark_for_delete")
    private boolean markForDelete;
    
    @Column(name = "location", nullable = false)
    private Integer location;
    
    @Column(name = "department", nullable = false)
    private Integer department;
    
    @Column(name = "sub-labels")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "label", fetch = FetchType.LAZY)
    private List<SubLabel> subLabels;
    
    public Label() {
    }
    
    public Integer getLabelPrivateId() {
        return labelPrivateId;
    }
    
    public void setLabelPrivateId(Integer labelPrivateId) {
        this.labelPrivateId = labelPrivateId;
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
    
    public boolean isMarkForDelete() {
        return markForDelete;
    }
    
    public void setMarkForDelete(boolean markForDelete) {
        this.markForDelete = markForDelete;
    }
    
    public Integer getLocation() {
        return location;
    }
    
    public void setLocation(Integer location) {
        this.location = location;
    }
    
    public Integer getDepartment() {
        return department;
    }
    
    public void setDepartment(Integer department) {
        this.department = department;
    }
    
    @JsonManagedReference
    public List<SubLabel> getSubLabels() {
        return subLabels;
    }
    
    public void setSubLabels(List<SubLabel> subLabels) {
        this.subLabels = subLabels;
    }
    
    public String getLabelPublicId() {
        return labelPublicId;
    }
    
    public void setLabelPublicId(String labelPublicId) {
        this.labelPublicId = labelPublicId;
    }
}
