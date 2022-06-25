package com.mas.medicalservices.repository;

import com.mas.medicalservices.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PatientRepository extends JpaRepository<Patient,Integer> {

    @Query("SELECT p FROM Patient p WHERE p.firstName = :name AND p.lastName = :lastName")
    Patient searchByNameAndLastName(@Param("name") String name,@Param("lastName") String lastName );

/*    @Query("SELECT p FROM Patient p WHERE p.firstName = :name AND p.lastName = :lastName")
    Patient searchByNameAndLastName(@Param("name") String name,@Param("lastName") String lastName );*/
}
