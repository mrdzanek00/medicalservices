package com.mas.medicalservices.controller;

import com.mas.medicalservices.model.Internship;
import com.mas.medicalservices.model.Patient;
import com.mas.medicalservices.services.InternshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/internships")
@CrossOrigin("*")
public class InternshipController {
    @Autowired
    InternshipService internshipService;

    @GetMapping("")
    public List<Internship> list() {
        return internshipService.listAllInternship();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Internship> get(@PathVariable Integer id) {
        try {
            Internship patient = internshipService.getInternship(id);
            return new ResponseEntity<Internship>(patient, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Internship>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/")
    public void add(@RequestBody Internship internship) {
        internshipService.saveInternship(internship);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Internship internship, @PathVariable Integer id) {
        try {
            Internship existPerson = internshipService.getInternship(id);
            internship.setIdIntership(id);
            internshipService.saveInternship(internship);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

        internshipService.deleteInternship(id);
    }

}
