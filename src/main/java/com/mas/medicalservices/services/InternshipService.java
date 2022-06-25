package com.mas.medicalservices.services;

import com.mas.medicalservices.model.Doctor;
import com.mas.medicalservices.model.Internship;
import com.mas.medicalservices.repository.InternshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class InternshipService {


    @Autowired
    private InternshipRepository internshipRepository;

    public List<Internship> listAllInternship() {
        System.out.println(internshipRepository.findAll());
        return internshipRepository.findAll();
    }

    public void saveInternship(Internship internship) {

        internshipRepository.save(internship);
    }

    public Internship getInternship(Integer id) {
        return internshipRepository.findById(id).get();
    }

    public void deleteInternship(Integer id) {
        internshipRepository.deleteById(id);
    }

}
