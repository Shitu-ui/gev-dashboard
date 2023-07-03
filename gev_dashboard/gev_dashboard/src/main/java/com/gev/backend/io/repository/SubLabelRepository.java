package com.gev.backend.io.repository;

import com.gev.backend.io.entity.SubLabel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubLabelRepository extends JpaRepository<SubLabel, Long> {
    // Additional custom queries can be defined here if needed
    boolean existsBySubLabelPrivateId(Integer publicId);
    
    boolean existsBySubLabelPublicId(String publicId);
    
    boolean existsBySubLabelName(String labelName);
    
    Optional<SubLabel> findBySubLabelName(String subLabelName);
    
    Optional<SubLabel> findBySubLabelPublicId(String labelPublicId);
    
    Optional<SubLabel> findBySubLabelId(Integer subLabelId);
    
    @Query(value = "SELECT s.*\n" +
            "FROM sublabels s\n" +
            "JOIN labels l ON s.label_private_id = l.label_private_id\n" +
            "WHERE l.label_private_id = :labelPrivateId\n" +
            "  AND s.sub_label_name = :subLabelName", nativeQuery = true)
    Optional<SubLabel> findBySubLabelNameAndLabelPrivateId(String subLabelName, Integer labelPrivateId);
    
    @Query(value = "SELECT EXISTS (" +
            "SELECT 1 " +
            "FROM sublabels s " +
            "JOIN labels l ON s.label_private_id = l.label_private_id " +
            "WHERE l.label_private_id = :privateId " +
            "AND s.sub_label_name = :sublabelName" +
            ")",
            nativeQuery = true)
    Integer existsByPrivateIdAndSublabelName(Integer privateId, String sublabelName);
    
}


