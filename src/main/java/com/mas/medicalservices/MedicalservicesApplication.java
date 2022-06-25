package com.mas.medicalservices;

import com.mas.medicalservices.repository.DoctorRepository;
import com.mas.medicalservices.services.DoctorService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//https://users.pja.edu.pl/~mtrzaska/Files/MAS/MAS-05.pdf

@SpringBootApplication
public class MedicalservicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(MedicalservicesApplication.class, args);
    }

}
