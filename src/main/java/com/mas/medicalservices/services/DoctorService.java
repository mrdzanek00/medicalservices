package com.mas.medicalservices.services;

import com.mas.medicalservices.model.Doctor;
import com.mas.medicalservices.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    //NOTE TRWALOSC
    public List<Doctor> listAllDoctor() {
        System.out.println(doctorRepository.findAll());
        return doctorRepository.findAll();
    }

    public void saveDoctor(Doctor doctor) {

        doctorRepository.save(doctor);
    }

    public Doctor getDoctor(Integer id) {
        return doctorRepository.findById(id).get();
    }

    public void deleteDoctor(Integer id) {
        doctorRepository.deleteById(id);
    }

}
