package com.mas.medicalservices.controller;

import com.mas.medicalservices.model.Specialization;
import com.mas.medicalservices.services.SpecializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/specializations")
@CrossOrigin("*")
public class SpecializationController {

    @Autowired
    SpecializationService specializationService;

    @GetMapping("")
    public List<Specialization> list() {
        return specializationService.listAllSpecialization();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Specialization> get(@PathVariable String id) {
        try {
            Specialization spec = specializationService.getSpecialization(id);
            return new ResponseEntity<Specialization>(spec, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Specialization>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/")
    public void add(@RequestBody Specialization specialization) {
        specializationService.saveSpecialization(specialization);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Specialization specialization, @PathVariable String id) {
        try {
            Specialization existPerson = specializationService.getSpecialization(id);
            specialization.setSpecName(id);
            specializationService.saveSpecialization(specialization);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {

        specializationService.deleteSpecialization(id);
    }

}
