import axios from 'axios';

const Specialization_BASE_URL = "http://localhost:8080/specializations";

class SpecializationService {

    getSpecializations(){
        return axios.get(Specialization_BASE_URL + '/');
    }



}

export default new SpecializationService()