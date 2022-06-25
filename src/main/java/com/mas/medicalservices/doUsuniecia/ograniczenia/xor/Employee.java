package com.mas.medicalservices.doUsuniecia.ograniczenia.xor;

import org.jetbrains.annotations.NotNull;

public class Employee  {

    private String name;

    private String lastName;


    private boolean isCivilContract = false;
    private boolean isEmploymentContract = false;
    private CivilContractData civilContractData;
    private EmploymentContractData employmentContractData;


    public boolean haveContract() {
        return !isCivilContract && !isEmploymentContract;
    }

    public void assignCivilContract(CivilContractData civilContractData) throws Exception {
        if(civilContractData==null){
            throw new Exception("Kontrakt nie istnieje!");
        }
        if(isCivilContract) {
            throw new Exception("Pracownik już posiada umowę zlecenie");
        }
        if(isEmploymentContract){
            throw new Exception("Pracownik już posiada umowę o pracę");
        }
        this.addCivilContractData(civilContractData);
        civilContractData.addEmployee(this);
    }

    public void addCivilContractData(CivilContractData civilContractData) {
        this.isCivilContract = true;
        this.civilContractData = civilContractData;
    }


    public void assignEmploymentContract(EmploymentContractData employmentContractData) throws Exception {
        if(civilContractData==null){
            throw new Exception("Kontrakt nie istnieje!");
        }
        if(isCivilContract) {
            throw new Exception("Pracownik już posiada umowę zlecenie");
        }
        if(isEmploymentContract){
            throw new Exception("Pracownik już posiada umowę o pracę");
        }
        this.addEmploymentContractData(employmentContractData);
        employmentContractData.addEmployee(this);
    }

    public void addEmploymentContractData(EmploymentContractData employmentContractData) {
        this.isEmploymentContract = true;
        this.employmentContractData = employmentContractData;
    }

}
