package com.mas.medicalservices.repository;

import com.mas.medicalservices.model.Doctor;
import com.mas.medicalservices.model.Patient;
import com.mas.medicalservices.model.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {

/*

    @Query("update Doctor d set d.specialization = :spec_name")
    void addSpecialization(@Param("specialization")Specialization spec_name);
*/

}
