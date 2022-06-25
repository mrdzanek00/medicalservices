package com.mas.medicalservices.repository;

import com.mas.medicalservices.model.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecializationRepository extends JpaRepository<Specialization, String> {
}
