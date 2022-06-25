package com.mas.medicalservices.services;

import com.mas.medicalservices.model.Specialization;
import com.mas.medicalservices.repository.SpecializationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SpecializationService {

    @Autowired
    private SpecializationRepository specializationRepository;


    public List<Specialization> listAllSpecialization() {
        return specializationRepository.findAll();
    }

    public void saveSpecialization(Specialization specialization) {
        specializationRepository.save(specialization);
    }

    public Specialization getSpecialization(String id) {
        return specializationRepository.findById(id).get();
    }

    public void deleteSpecialization(String id) {
        specializationRepository.deleteById(id);
    }

}
