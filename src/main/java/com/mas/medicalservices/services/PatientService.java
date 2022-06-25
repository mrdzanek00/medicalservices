package com.mas.medicalservices.services;

import com.mas.medicalservices.model.Patient;
import com.mas.medicalservices.model.Visit;
import com.mas.medicalservices.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PatientService {

    @Autowired
    private PatientRepository patientR;

    //NOTE TRWALOSC
    public List<Patient> listAllPatient() {
        System.out.println(patientR.findAll());
        return patientR.findAll();
    }

    public void savePatient(Patient patient) {

        patientR.save(patient);
    }

    public Patient getPatient(Integer id) {
        return patientR.findById(id).get();
    }

    public void deletePatient(Integer id) {
        patientR.deleteById(id);
    }

    public Patient getPatientByName(String name, String lastname){
        return patientR.searchByNameAndLastName(name,lastname);
    }

}