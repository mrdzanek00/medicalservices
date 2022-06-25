import './App.css';
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom'
//import PatientList from './components/PatientList.js';
import HeaderComponent from './components/HeaderComponent';
import FooterComponent from './components/FooterComponent';
import PatientList from './components/PatientList';
import PatientSearch from './components/PatientSearch';

function App() {
  return (
    <div>
    <Router>
          <HeaderComponent />
          <div >
                    <Routes > 
                          <Route path = "/"  exact element = {<PatientList/>}></Route>
                          <Route path = "/patientSearch" exact element = {<PatientSearch/>}></Route>
                          {/* <Route path = "/update-employee/:id" component = {UpdateEmployeeComponent}></Route> */}
                    </Routes>
                </div>
          <FooterComponent />
    </Router>
</div>

  );
}

export default App;
