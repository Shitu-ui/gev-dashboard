package com.gev.backend.io.repository;

import com.gev.backend.io.entity.SubLabel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubLabelRepository extends JpaRepository<SubLabel, Long> {
    // Additional custom queries can be defined here if needed
	boolean existsBySubLabelPrivateId(Integer publicId);
	boolean existsBySubLabelPublicId(String publicId);
	boolean existsBySubLabelName(String labelName);

	Optional<SubLabel> findBySubLabelName(String subLabelName);

	Optional<SubLabel>findBySubLabelPublicId(String labelPublicId);
}
