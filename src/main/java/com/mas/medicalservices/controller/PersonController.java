package com.mas.medicalservices.controller;

import com.mas.medicalservices.model.Person;
import com.mas.medicalservices.model.Visit;
import com.mas.medicalservices.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/persons")
public class PersonController {

   /* @Autowired
    PersonService personService;

    @GetMapping("")
    public List<Person> list() {
        return personService.listAllPerson();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> get(@PathVariable Integer id) {
        try {
            Person person = personService.getPerson(id);
            return new ResponseEntity<Person>(person, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/")
    public void add(@RequestBody Person person) {
        personService.savePerson(person);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Person person, @PathVariable Integer id) {
        try {
            Person existPerson = personService.getPerson(id);
            person.setIdPerson(id);
            personService.savePerson(person);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

        personService.deletePerson(id);
    }
*/

}
