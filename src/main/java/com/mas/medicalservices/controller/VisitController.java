package com.mas.medicalservices.controller;


import com.mas.medicalservices.dto.VisitDto;
import com.mas.medicalservices.dto.VisitDto2;
import com.mas.medicalservices.dto.VisitDto3;
import com.mas.medicalservices.model.Visit;
import com.mas.medicalservices.services.DoctorService;
import com.mas.medicalservices.services.PatientService;
import com.mas.medicalservices.services.VisitService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
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

//    @PostMapping("/")
 //   @ResponseStatus(HttpStatus.CREATED)
    //@ResponseBody
/*    @RequestMapping(value = "", method = RequestMethod.POST,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public @ResponseBody VisitDto3 add( @RequestParam MultiValueMap<VisitDto3,String> paramMap) throws ParseException {
    System.out.println(paramMap.toString());
        Visit visit = convertToEntity3(null);

        visitService.saveVisit(visit);
        return null;
    }*/

 /*   @PostMapping(path = "", consumes = "application/x-www-form-urlencoded")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public VisitDto add(VisitDto3 visitDto) throws ParseException {

        System.out.println(visitDto);
     //   Visit visit = convertToEntity(visitDto);

     //   visitService.saveVisit(visit);
    //    return convertToDto(visit);
        return null ;
    }*/

    /*@GetMapping(path = "/{id_doctor}/{id_patient}/{duration}/{date}")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public VisitDto add(@PathVariable Integer id_doctor , @PathVariable  Integer id_patient ,  @PathVariable Integer duration, @PathVariable  Date date) throws ParseException {

        Visit visit = new Visit(doctorService.getDoctor(id_doctor),patientService.getPatient(id_patient),date,duration);
        visitService.saveVisit(visit);
        return convertToDto(visit);
    }*/

  @PostMapping("")
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

    private Visit convertToEntity3(VisitDto3 visitDto)  {
        System.out.println(visitDto.getId_doctor());
        Visit visit = new Visit(doctorService.getDoctor(visitDto.getId_doctor()),patientService.getPatient(visitDto.getId_patient()),visitDto.getBeginDate(),visitDto.getDuration());
        return visit;
    }

    @GetMapping("/getv2")
    public List<VisitDto2> listV2() {
        return visitService.listAllVisit2();
    }

}
