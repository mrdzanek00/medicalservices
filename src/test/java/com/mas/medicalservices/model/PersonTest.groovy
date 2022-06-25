package com.mas.medicalservices.model

import spock.lang.Specification


class PersonTest extends Specification {


    def "nullable check"(){
        when:
        var person = new Receptionist("Mateusz","Rdzanek","złyEmail","1234",3000.00,new Date(2000,10,10))
        then:
        noExceptionThrown()
    }


}