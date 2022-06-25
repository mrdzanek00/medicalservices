package com.mas.medicalservices.repository;

import com.mas.medicalservices.model.Patient;
import com.mas.medicalservices.dto.VisitDto2;
import com.mas.medicalservices.model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VisitRepository extends JpaRepository<Visit,Integer> {

   /* @Query("    select v.id_visit, v.id_patient, v.id_doctor, pp2.firstName as patientFirstName, pp2.lastName as patientLastName, pp.firstName as doctorFirstName, pp.lastName as doctorLastName, v.beginDate, v.duration from visit v, doctor d, Patient p, Person pp, Person pp2 where v.id_patient  = p.id_patient and v.id_doctor = d.id_doctor and d.id_doctor  = pp.id_person and p.id_patient  = pp2.id_person ")
    */
    /*List<VisitDto2> getVisit2();*/

}
