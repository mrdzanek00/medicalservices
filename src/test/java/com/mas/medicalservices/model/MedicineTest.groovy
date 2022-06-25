package com.mas.medicalservices.model

import spock.lang.Specification

class MedicineTest extends Specification {

    private med01
    private med02
    private med03

    def setup(){
         med01 = new Medicine2();
         med02 = new Medicine2(1,"LekTest1","OpisTest",new HealMethod())
         med03 = new Medicine2(2,"LekTest2","OpisTest",new HealMethod())
    }


    def "extent showcase"(){
        when:
        Medicine2.showExtent()
        then:
        noExceptionThrown()
    }

    def "should findMedicine"(){
        when:
        var med =  Medicine2.findMedicineByName("LekTest1")
        then:
        med == med02

    }
}