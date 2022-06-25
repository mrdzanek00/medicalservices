package com.mas.medicalservices.controller;

import com.mas.medicalservices.model.Patient;
import com.mas.medicalservices.model.Person;
import com.mas.medicalservices.services.PatientService;
import com.mas.medicalservices.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/patients")
@CrossOrigin("*")
public class PatientController {
    @Autowired
    PatientService patientService;

    @GetMapping("")
    public List<Patient> list() {
        return patientService.listAllPatient();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Patient> get(@PathVariable Integer id) {
        try {
            Patient patient = patientService.getPatient(id);
            return new ResponseEntity<Patient>(patient, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Patient>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/")
    public void add(@RequestBody Patient patient) {
        patientService.savePatient(patient);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Patient patient, @PathVariable Integer id) {
        try {
            Patient existPerson = patientService.getPatient(id);
            patient.setId_person(id);
            patientService.savePatient(patient);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

        patientService.deletePatient(id);
    }

    @GetMapping("/{name}/{lastname}")
    public ResponseEntity<Patient> get(@PathVariable String name, @PathVariable String lastname) {
        try {
            Patient patient = patientService.getPatientByName(name,lastname);
            return new ResponseEntity<Patient>(patient, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Patient>(HttpStatus.NOT_FOUND);
        }
    }

}
