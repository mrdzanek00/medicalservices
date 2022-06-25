package com.mas.medicalservices.doUsuniecia.ograniczenia.xor;

import java.util.ArrayList;
import java.util.List;

public class CivilContractData {

    private List<Employee> employeeList = new ArrayList<>();

    private String contractId ;

    public CivilContractData(String contractId) {
        this.employeeList = new ArrayList<>();
        this.contractId = contractId;
    }

    public void hireEmployee(Employee employee) throws Exception {
        if(employee.haveContract()){
            this.addEmployee(employee);
            employee.addCivilContractData(this);
        }else{
            throw new Exception("Pracownik posiada już inna umowe");
        }
    }

    public void addEmployee(Employee employee) throws Exception {
        if(employee!=null){
            this.employeeList.add(employee);
        }else{
            throw new Exception("Pracownik nie istnieje!");
        }
    }


    public List<Employee> getEmployeeList() {
        return employeeList;
    }


}
