package com.gev.backend.io.repository;

import com.gev.backend.io.entity.Frequency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FrequencyRepository extends JpaRepository<Frequency, Integer> {
    
    boolean existsByFrequencyPublicId(Integer frequencyPublicId);
    
    Optional<Frequency> findByFrequencyPublicId(String frequencyPublicId);
}
