package com.mas.medicalservices.repository;

import com.mas.medicalservices.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepository extends JpaRepository<Medicine,Integer> {
}
