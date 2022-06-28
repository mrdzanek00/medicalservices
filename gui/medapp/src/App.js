import "./App.css";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
//import PatientList from './components/PatientList.js';
import HeaderComponent from "./components/HeaderComponent";
import FooterComponent from "./components/FooterComponent";
import VisitList from "./components/VisitList";
import PatientSearch from "./components/PatientSearch";
import Specialization from "./components/Specialization";
import Visit from "./components/Visit";
import { useState } from "react";
function App() {
  const [selectedPatientId, setSelectedPatientId] = useState("");
  const [selectedSpec, setSelectedSpec] = useState("");
  return (
    <div>
      <Router>
        <HeaderComponent />
        <div>
          <Routes>
            <Route path="/" exact element={<VisitList />} />
            <Route
              path="/patientSearch"
              exact
              element={<PatientSearch setId={setSelectedPatientId} />}
            />
            <Route
              path="/chooseSpec"
              exact
              element={
                <Specialization
                  patientId={selectedPatientId}
                  setSpec={setSelectedSpec}
                  spec={selectedSpec}
                />
              }
            />
            <Route
              path="/visitInfo"
              exact
              element={
                <Visit patientId={selectedPatientId} spec={selectedSpec} />
              }
            />
            {/* <Route path = "/update-employee/:id" component = {UpdateEmployeeComponent}></Route> */}
          </Routes>
        </div>
        <FooterComponent />
      </Router>
    </div>
  );
}

export default App;
