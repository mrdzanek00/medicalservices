package com.mas.medicalservices.controller;


import com.mas.medicalservices.dto.VisitDto;
import com.mas.medicalservices.dto.VisitDto2;
import com.mas.medicalservices.model.Visit;
import com.mas.medicalservices.services.DoctorService;
import com.mas.medicalservices.services.PatientService;
import com.mas.medicalservices.services.VisitService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/visits")
@CrossOrigin("*")
public class VisitController {

    @Autowired
    private VisitService visitService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PatientService patientService;

    @Autowired
    private DoctorService doctorService;

    @GetMapping("")
    public List<VisitDto> list() {
               List<Visit> list = visitService.listAllVisit();
               return list.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VisitDto> get(@PathVariable Integer id) {
        try {
            VisitDto visit = convertToDto(visitService.getVisit(id));
            return new ResponseEntity<VisitDto>(visit, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<VisitDto>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public VisitDto add(@RequestBody VisitDto visitDto) throws ParseException {

        Visit visit = convertToEntity(visitDto);

        visitService.saveVisit(visit);
        return convertToDto(visit);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody VisitDto visitDto, @PathVariable Integer id) {

            if(!Objects.equals(id, visitDto.getId_visit())){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        Visit visit = convertToEntity(visitDto);
        visitService.saveVisit(visit);

        return new ResponseEntity<>(HttpStatus.OK);

        }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

        visitService.deleteVisit(id);
    }


    private VisitDto convertToDto(Visit visit) {
        VisitDto visitDto = modelMapper.map(visit, VisitDto.class);
            visitDto.setId_doctor(visit.getDoctor().getId_person());
            visitDto.setId_patient(visit.getPatient().getId_person());
            visitDto.setId_visit(visit.getIdVisit());
        return visitDto;
    }

    private Visit convertToEntity(VisitDto visitDto)  {
        Visit visit = new Visit(visitDto.getId_visit(),doctorService.getDoctor(visitDto.getId_doctor()),patientService.getPatient(visitDto.getId_patient()),visitDto.getBeginDate(),visitDto.getDuration());
        return visit;
    }

 /*   @GetMapping("/getv2")
    public List<VisitDto2> listV2() {
        return visitService.listAllVisit2();
    }*/

}
