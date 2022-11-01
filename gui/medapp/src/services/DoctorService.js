import axios from 'axios';

const Doctor_BASE_URL = "http://localhost:8080/doctors";

class DoctorService {

    getDoctors(){
        return axios.get(Doctor_BASE_URL);
    }

    createDoctor(Doctor){
        return axios.post(Doctor_BASE_URL, + '/'  + Doctor);
    }

    getDoctorById(DoctorId){
        return axios.get(Doctor_BASE_URL + '/' + DoctorId);
    }

    updateDoctor(Doctor, DoctorId){
        return axios.put(Doctor_BASE_URL + '/' + DoctorId, Doctor);
    }

    deleteDoctor(DoctorId){
        return axios.delete(Doctor_BASE_URL + '/' + DoctorId);
    }

    getDoctorsBySpec(SpecName){
        return axios.get(Doctor_BASE_URL + '/spec/' + SpecName );
    }

}

export default new DoctorService()