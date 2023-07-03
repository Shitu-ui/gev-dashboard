package com.gev.backend.io.repository;

import com.gev.backend.io.entity.FormAccess;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FormAccessRepository extends JpaRepository<FormAccess, Integer> {
    
    Optional<FormAccess> findByFormAccessPublicId(String formAccessPublicId);
    
}
