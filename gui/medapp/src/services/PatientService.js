import axios from 'axios';

const PATIENT_BASE_URL = "http://localhost:8080/patients";

class PatientService {

    getPatients(){
        return axios.get(PATIENT_BASE_URL);
    }

    createPatient(patient){
        return axios.post(PATIENT_BASE_URL, patient);
    }

    getPatientById(patientId){
        return axios.get(PATIENT_BASE_URL + '/' + patientId);
    }

    updatePatient(patient, patientId){
        return axios.put(PATIENT_BASE_URL + '/' + patientId, patient);
    }

    deletePatient(patientId){
        return axios.delete(PATIENT_BASE_URL + '/' + patientId);
    }

    getPatientByName(firstName,lastName){
        return axios.get(PATIENT_BASE_URL + '/' + firstName + '/' + lastName);
    }
}

export default new PatientService()