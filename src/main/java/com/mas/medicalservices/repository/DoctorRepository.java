package com.mas.medicalservices.repository;

import com.mas.medicalservices.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {

/*

    @Query("update Doctor d set d.specialization = :spec_name")
    void addSpecialization(@Param("specialization")Specialization spec_name);
*/

    @Query("SELECT d from Doctor d WHERE d.specialization.specName = :specialization")
    List<Doctor> findDoctorsWithSpec(@Param("specialization")String spec_name);
}
