package com.mas.medicalservices.controller;

import com.mas.medicalservices.dto.DoctorDto;
import com.mas.medicalservices.dto.VisitDto;
import com.mas.medicalservices.model.Doctor;
import com.mas.medicalservices.model.Visit;
import com.mas.medicalservices.services.DoctorService;
import com.mas.medicalservices.services.InternshipService;
import com.mas.medicalservices.services.SpecializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/doctors")
@CrossOrigin("*")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private SpecializationService specializationService;

    @Autowired
    private InternshipService internshipService;

    @GetMapping("")
    public List<Doctor> list() {
        return doctorService.listAllDoctor();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Doctor> get(@PathVariable Integer id) {
        try {
            Doctor doctor = doctorService.getDoctor(id);
            return new ResponseEntity<Doctor>(doctor, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Doctor>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/nextVisit/{id}")
    public ResponseEntity<Visit> getNextVisit(@PathVariable Integer id) {
        try {
            Doctor doctor = doctorService.getDoctor(id);
            Visit visit = doctor.getNextVisit();
            return new ResponseEntity<Visit>(visit, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Visit>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<Visit>(HttpStatus.BAD_REQUEST);
        }
    }
/*    @PostMapping("/")
    public void add(@RequestBody Doctor doctor) {
        doctorService.saveDoctor(doctor);
    }*/

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public DoctorDto add(@RequestBody DoctorDto doctorDto) throws Exception {
        Doctor doctor = convertToEntity(doctorDto);

        doctorService.saveDoctor(doctor);
        return doctorDto;
    }



    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Doctor doctor, @PathVariable Integer id) {
        try {
            Doctor existDoctor = doctorService.getDoctor(id);
            doctor.setId_person(id);
            doctorService.saveDoctor(doctor);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

        doctorService.deleteDoctor(id);
    }


    //TODO XOR
    private Doctor convertToEntity(DoctorDto doctorDto) throws Exception {

        if(doctorDto.getSpecialization_name()!= null && doctorDto.getId_internship()!= null){
            throw new Exception("Cannot insert both internship and specialization");
                    }

        if(doctorDto.getSpecialization_name()!= null) {
            if(!checkIfSpecExisits(doctorDto.getSpecialization_name())){
                throw new Exception("Specialization doesn't exist");

            }
            Doctor doctor = new Doctor(doctorDto.getId_person(), doctorDto.getFirstName(), doctorDto.getLastName(), doctorDto.getEmail(), doctorDto.getPhoneNumber(), doctorDto.getSalary(), doctorDto.getEmploymentDate(), doctorDto.getLicenseNumber(),
                    doctorDto.getExperience(), doctorDto.getBirthDate(), specializationService.getSpecialization(doctorDto.getSpecialization_name()));
            return doctor;

        }

        if(doctorDto.getId_internship()!= null) {
            Doctor doctor = new Doctor(doctorDto.getId_person(), doctorDto.getFirstName(), doctorDto.getLastName(), doctorDto.getEmail(), doctorDto.getPhoneNumber(), doctorDto.getSalary(), doctorDto.getEmploymentDate(), doctorDto.getLicenseNumber(),
                    doctorDto.getExperience(), doctorDto.getBirthDate(), internshipService.getInternship(doctorDto.getId_internship()));
            return doctor;

        }


            Doctor doctor = new Doctor(doctorDto.getId_person(), doctorDto.getFirstName(), doctorDto.getLastName(), doctorDto.getEmail(), doctorDto.getPhoneNumber(), doctorDto.getSalary(), doctorDto.getEmploymentDate(), doctorDto.getLicenseNumber(),
                    doctorDto.getExperience(), doctorDto.getBirthDate());
            return doctor;

    }


    private boolean checkIfSpecExisits(String specName){
        return specializationService.getSpecialization(specName) != null;
    }

    @GetMapping("/spec/{spec_name}")
    public List<Doctor> listWithSpec(@PathVariable String spec_name) {
        return doctorService.listDoctorWithSpec(spec_name);
    }


}
