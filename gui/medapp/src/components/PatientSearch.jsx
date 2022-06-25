import React from 'react';
import axios from 'axios';
import PatientService from '../services/PatientService';

export default class PatientList extends React.Component {
    constructor(props) {
        super(props)

        this.state = {
            patient : null ,
            firstName: '',
            lastName: '',
            isFound: false

        }
        this.changeFirstNameHandler = this.changeFirstNameHandler.bind(this);
        this.changeLastNameHandler = this.changeLastNameHandler.bind(this);
    }



  changeFirstNameHandler= (event) => {
    this.setState({firstName: event.target.value});
}

changeLastNameHandler= (event) => {
    this.setState({lastName: event.target.value});
}

  componentDidMount() {
    axios.get(`http://localhost:8080/patients/`)
      .then(res => {
        const patients = res.data;
        this.setState({ patients });
      })
  }


  searchPatient = (e) => {
    e.preventDefault();
    
    PatientService.getPatientByName(this.state.firstName,this.state.lastName).then( (res) =>{
        let patient = res.data;
        this.state.patient = patient;
        this.isFound = true;
        console.log(patient)
        
    });

}

  render() {
    return (
        <><h2 className='h2class'> Wyszukaj pacjenta</h2><div className="App"></div><div>
            <br></br>
            <div className="container">
                <div className="row">
                    <div className="card col-md-6 offset-md-3 offset-md-3">
                        <div className="card-body">
                            <form>
                                <div className="form-group">
                                    <label> First Name: </label>
                                    <input placeholder="First Name" name="firstName" className="form-control"
                                        value={this.state.firstName} onChange={this.changeFirstNameHandler} />
                                </div>
                                <div className="form-group">
                                    <label> Last Name: </label>
                                    <input placeholder="Last Name" name="lastName" className="form-control"
                                        value={this.state.lastName} onChange={this.changeLastNameHandler} />
                                </div>
                                <button className="btn btn-success" onClick={this.searchPatient}>Search</button>
                            </form>
                            {this.isFound && (
        <div>
          <h2>Some content here</h2>
        </div>
      )}
                        </div>
                    </div>
                </div>

            </div>
        </div></>


    )
  }
  
}


