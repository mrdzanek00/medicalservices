package com.mas.medicalservices.repository;

import com.mas.medicalservices.dto.VisitDto2;
import com.mas.medicalservices.model.Doctor;
import com.mas.medicalservices.model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VisitRepository extends JpaRepository<Visit,Integer> {

    @Query("SELECT d.firstName as dname , d.lastName as dlast ,  p.firstName as pname , p.lastName as plast, v.beginDate, v.duration FROM Visit v JOIN v.doctor d JOIN v.patient p ")
    List<VisitDto2> getVisit2();

}
