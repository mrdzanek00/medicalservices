package com.mas.medicalservices.configuration;

import com.mas.medicalservices.model.Doctor;
import com.mas.medicalservices.repository.DoctorRepository;
import com.mas.medicalservices.services.DoctorService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class MyInitializingBean implements InitializingBean {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private DoctorService doctorService;

    @PostConstruct
    public List<Doctor> list() {
        return doctorService.listAllDoctor();
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        doctorRepository.findAll();

    }

    @PostConstruct
    public void init() throws InterruptedException {

    }
}
