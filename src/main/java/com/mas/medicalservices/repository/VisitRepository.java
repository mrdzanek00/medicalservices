package com.mas.medicalservices.repository;

import com.mas.medicalservices.model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitRepository extends JpaRepository<Visit,Integer> {
}
