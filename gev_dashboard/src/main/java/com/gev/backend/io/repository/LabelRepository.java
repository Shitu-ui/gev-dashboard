package com.gev.backend.io.repository;

import com.gev.backend.io.entity.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LabelRepository extends JpaRepository<Label, Integer> {
    // Additional custom queries can be defined here if needed
    //	boolean existsByLabelPrivateId(Integer publicId);
	boolean existsByLabelPrivateId(Integer publicId);
	boolean existsByLabelPublicId(String publicId);

	boolean existsByLabelName(String labelName);

	Optional<Label> findByLabelPublicId(String publicId);
	
}
