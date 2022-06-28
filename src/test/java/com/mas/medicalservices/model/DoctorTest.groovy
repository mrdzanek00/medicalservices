package com.mas.medicalservices.model

import spock.lang.Specification

import java.text.SimpleDateFormat
import java.util.concurrent.TimeUnit


class DoctorTest extends Specification {

    class A{
        String get(){
            return "A";
        }
    }
    class B extends A{
        String get(){
            return "B"
        }
    }

    def "should return exp"(){

        when:
        var  sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
        var employmentDate = sdf.parse("06/24/2017");
        var doctor = new Doctor("Mateusz","Rdzanek","mr123@gmail.com","48666662137",6000.00,sdf.parse("06/24/2017"),"2134dssd",2.5)
        A a1 = new B();
        println (a1.get())
        then:
        double days = TimeUnit.DAYS.convert(Math.abs(employmentDate.getTime() - new Date().getTime()),TimeUnit.MILLISECONDS)
        days/365 + doctor.getExpYears() == doctor.showExperience()


    }

}