import axios from 'axios';

const Visit_BASE_URL = "http://localhost:8080/visits";

class VisitService {

    getVisits(){
        return axios.get(Visit_BASE_URL + '/');
    }

    createVisit(visit){
        return axios.post(Visit_BASE_URL   ,visit);
    }

    createVisitWithParams(id_doctor,id_patient,duration,date){
        return axios.get(Visit_BASE_URL, + '/'  + id_doctor + '/' + id_patient + '/' + duration + '/' + date);
    }


    getVisitById(visitId){
        return axios.get(Visit_BASE_URL + '/' + visitId);
    }

    updateVisit(visit, visitId){
        return axios.put(Visit_BASE_URL + '/' + visitId, visit);
    }

    deleteVisit(visitId){
        return axios.delete(Visit_BASE_URL + '/' + visitId);
    }


}

export default new VisitService()