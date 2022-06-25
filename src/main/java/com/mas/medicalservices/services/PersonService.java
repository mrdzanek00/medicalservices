package com.mas.medicalservices.services;

import com.mas.medicalservices.model.Person;
import com.mas.medicalservices.model.Visit;
import com.mas.medicalservices.repository.PersonRepository;
import com.mas.medicalservices.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> listAllPerson() {
        System.out.println(personRepository.findAll());
        return personRepository.findAll();
    }

    public void savePerson(Person person) {
        personRepository.save(person);
    }

    public Person getPerson(Integer id) {
        return personRepository.findById(id).get();
    }

    public void deletePerson(Integer id) {
        personRepository.deleteById(id);
    }

}
