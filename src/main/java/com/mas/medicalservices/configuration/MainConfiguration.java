package com.mas.medicalservices.configuration;

import com.mas.medicalservices.repository.DoctorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class MainConfiguration {


    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }


}
