package com.mas.medicalservices.repository;

import com.mas.medicalservices.model.Doctor;
import com.mas.medicalservices.model.Internship;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InternshipRepository extends JpaRepository<Internship,Integer> {
}
