package com.gev.backend.io.repository;

import com.gev.backend.io.entity.Label;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LabelRepository extends JpaRepository<Label, Integer> {
    // Additional custom queries can be defined here if needed
    //	boolean existsByLabelPrivateId(Integer publicId);
    boolean existsByLabelPrivateId(Integer publicId);
    
    boolean existsByLabelPublicId(String publicId);
    
    @Query(value = "SELECT EXISTS (" +
            "SELECT 1" +
            "FROM labels" +
            "GROUP BY label_name, location, department" +
            "HAVING COUNT(*) > 1" +
            ")")
    Integer existsByLabelNameLocationDepartment(String labelName, Integer location, Integer department);
    
    Optional<Label> findByLabelPublicId(String publicId);
    
    @Query(value = "SELECT IF(COUNT(*) = 1 AND SUM(sub_label_name = 'Default') = COUNT(*), 1, 0) " +
            "FROM labels l " +
            "LEFT JOIN sublabels s ON l.label_private_id = s.label_private_id " +
            "WHERE l.label_public_id = :publicId", nativeQuery = true)
    Integer checkOnlyDefaultSublabelExists(String publicId);
    
    
    List<Label> findByLocationAndDepartment(Integer location, Integer department);
    
    @Query(value = "SELECT label_private_id" +
            "FROM labels" +
            "WHERE label_public_id = :labelPublicId",nativeQuery = true)
    Integer getPrivateId(String labelPublicId);
    
    
}
