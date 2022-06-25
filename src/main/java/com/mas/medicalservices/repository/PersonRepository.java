package com.mas.medicalservices.repository;

import com.mas.medicalservices.model.Patient;
import com.mas.medicalservices.model.Person;
import com.mas.medicalservices.model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Integer> {
}
