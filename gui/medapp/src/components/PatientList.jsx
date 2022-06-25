import React from 'react';
import PatientService from '../services/PatientService';

export default class PatientList extends React.Component {
  constructor(props) {
    super(props)

    this.state = {
            patients: []
    }
    this.addPatient = this.addPatient.bind(this);
    this.editPatient = this.editPatient.bind(this);
    this.deletePatient = this.deletePatient.bind(this);
}

deletePatient(id){
    PatientService.deletePatient(id).then( res => {
        this.setState({Patients: this.state.patients.filter(Patient => Patient.id !== id)});
    });
}
viewPatient(id){
    this.props.history.push(`/view-Patient/${id}`);
}
editPatient(id){
    this.props.history.push(`/add-Patient/${id}`);
}

componentDidMount(){
    PatientService.getPatients().then((res) => {
        this.setState({ patients: res.data});
    });
}

addPatient(){
    this.props.history.push('/add-Patient/_add');
}

render() {
    return (
        <div>
             <h2 className="text-center">Patients List</h2>
             <div className = "row">
                <button className="btn btn-primary" onClick={this.addPatient}> Add Patient</button>
             </div>
             <br></br>
             <div className = "row">
                    <table className = "table table-striped table-bordered">

                        <thead>
                            <tr>
                                <th> First Name</th>
                                <th> Last Name</th>
                                <th> Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.patients.map(
                                    Patient => 
                                    <tr key = {Patient.id}>
                                         <td> { Patient.firstName} </td>   
                                         <td> {Patient.lastName}</td>
                                         <td>
                                             <button onClick={ () => this.editPatient(Patient.id)} className="btn btn-info">Update </button>
                                             <button style={{marginLeft: "10px"}} onClick={ () => this.deletePatient(Patient.id)} className="btn btn-danger">Delete </button>
                                             <button style={{marginLeft: "10px"}} onClick={ () => this.viewPatient(Patient.id)} className="btn btn-info">View </button>
                                         </td>
                                    </tr>
                                )
                            }
                        </tbody>
                    </table>

             </div>

        </div>
    )
}
}

