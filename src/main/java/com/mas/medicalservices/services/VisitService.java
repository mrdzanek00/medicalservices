package com.mas.medicalservices.services;


import com.mas.medicalservices.dto.VisitDto2;
import com.mas.medicalservices.model.Visit;
import com.mas.medicalservices.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class VisitService {

    @Autowired
    private VisitRepository visitRepository;

    //NOTE TRWALOSC
    public List<Visit> listAllVisit() {
        System.out.println(visitRepository.findAll() + "kOKL");
        return visitRepository.findAll();
    }

    public void saveVisit(Visit visit) {
        visitRepository.save(visit);
    }

    public Visit getVisit(Integer id) {
        return visitRepository.findById(id).get();
    }

    public void deleteVisit(Integer id) {
        visitRepository.deleteById(id);
    }

  /*  public List<VisitDto2> listAllVisit2() {
        return visitRepository.getVisit2();
    }
*/
}
