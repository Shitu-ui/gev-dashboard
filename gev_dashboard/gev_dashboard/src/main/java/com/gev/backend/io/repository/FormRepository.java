package com.gev.backend.io.repository;

import com.gev.backend.io.entity.Form;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FormRepository extends JpaRepository<Form, Integer> {
    
    Optional<Form> findByFormPublicId(String formPublicId);
}
