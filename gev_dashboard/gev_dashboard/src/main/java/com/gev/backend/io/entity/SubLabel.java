package com.gev.backend.io.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * SubLabel Entity
 */
@Entity
@Table(name = "sublabels")
public class SubLabel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sub_label_private_id", nullable = false)
    private Integer subLabelPrivateId;
    
    @Column(name = "sub_label_public_id", nullable = false)
    private String subLabelPublicId;
    
    @Column(name = "sub_label_name", nullable = false)
    private String subLabelName;
    
    @Column(name = "created_by", nullable = false)
    private Integer createdBy;
    
    @CreationTimestamp
    @Column(name = "created_on")
    private String createdOn;
    
    @UpdateTimestamp
    @Column(name = "modified_on")
    private String modifiedOn;
    
    @Column(name = "modified_by")
    private Integer modifiedBy;
    
    @Column(name = "mark_for_delete")
    private boolean markForDelete;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "label_private_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Label label;
    
    public Integer getSubLabelPrivateId() {
        return subLabelPrivateId;
    }
    
    public void setSubLabelPrivateId(Integer subLabelPrivateId) {
        this.subLabelPrivateId = subLabelPrivateId;
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
    
    @JsonBackReference
    public Label getLabel() {
        return label;
    }
    
    public void setLabel(Label label) {
        this.label = label;
    }
//	public Integer getLocation() {
//		return location;
//	}
//
//
//	public void setLocation(Integer location) {
//		this.location = location;
//	}
//
//
//	public Integer getDepartment() {
//		return department;
//	}
//
//
//	public void setDepartment(Integer department) {
//		this.department = department;
//	}
    

}
