import { useState } from "react";
import Typography from "@mui/material/Typography";
import moment from "moment";
import DoctorService from "../services/DoctorService"
import VisitService from "../services/VisitService";
import {
  Button,
  Select,
  MenuItem,
  InputLabel,
  FormControl,
  TextField,
} from "@mui/material";
import { useNavigate } from "react-router-dom";
import { AdapterDateFns } from "@mui/x-date-pickers/AdapterDateFns";
import { LocalizationProvider } from "@mui/x-date-pickers/LocalizationProvider";
import { DateTimePicker } from "@mui/x-date-pickers/DateTimePicker";
import { useEffect } from "react";
const PatientSearch = ({ patientId, spec }) => {
  const [availableDoctors, setAvailableDoctors] = useState([]);
  const [visitLengths, setVisitLengths] = useState([
    30,
    60,
    90,
  ]);
  const [doctor, setDoctor] = useState("Jan Kowalski");
  const [doctorId, setDoctorId] = useState(0);
  const [visitLength, setVisitLength] = useState("30 minut");
  const [visitDate, setVisitDate] = useState(new Date());
  const navigate = useNavigate();
  const addVisit = () => {
    console.log(doctorId, patientId, moment(visitDate).format("YYYY-MM-DDTHH:mm"), visitLength)
    const visitDto = {"id_doctor": doctorId,
    "id_patient": patientId,
    "beginDate": moment(visitDate).format("YYYY-MM-DDTHH:mm"),
    "duration": visitLength}

   // VisitService.createVisitWithParams(doctorId,patientId,visitLength,moment(visitDate).format("YYYY-MM-DDTHH:mm")).then(res =>{
   //   console.log(res.data)
   //   navigate("/");
   // })

    VisitService.createVisit(visitDto).then(res =>{
     console.log(res.data)
     navigate("/");
   })

    //navigate("/");
  };
  useEffect(() => {
    DoctorService.getDoctorsBySpec(spec).then(res =>{
      const doctorList = [];
      for (const doctorTmp in res.data)
     // console.log(res.data[doctorTmp].firstName.trim() , res.data[doctorTmp].lastName.trim() , res.data[doctorTmp].id_person)
          doctorList.push({doctorName:`${res.data[doctorTmp].firstName.trim()} ${res.data[doctorTmp].lastName.trim()}`,doctorId:res.data[doctorTmp].id_person})
     setAvailableDoctors(doctorList); 

    })
  }, []);
  return (
    <div
      style={{
        display: "flex",
        flexDirection: "column",
        width: "500px",
        justifyContent: "center",
        alignItems: "center",
        marginLeft: "50px",
        marginTop: "50px",
      }}
    >
      <Typography variant="h3">Szczegóły wizyty</Typography>
      <FormControl fullWidth style={{ marginTop: "30px" }}>
        <InputLabel id="demo-simple-select-label">Lekarz</InputLabel>
        <Select
          labelId="demo-simple-select-label"
          id="demo-simple-select"
          value={doctorId}
          label="Lekarz"
          onChange={(e) => setDoctorId(e.target.value)}
        >
          {availableDoctors.map((currDoctor) => (
            <MenuItem value={currDoctor.doctorId} key={currDoctor.doctorId}>
              {currDoctor.doctorName}
            </MenuItem>
          ))}
        </Select>
      </FormControl>
      <FormControl
        fullWidth
        style={{ marginTop: "30px", marginBottom: "30px" }}
      >
        <InputLabel id="demo-simple-select-label">Czas trwania</InputLabel>
        <Select
          labelId="demo-simple-select-label"
          id="demo-simple-select"
          value={visitLength}
          label="Czas trwania"
          onChange={(e) => setVisitLength(e.target.value)}
        >
          {visitLengths.map((val, idx) => (
            <MenuItem key={`${val}_${idx}`} value={val}>
              {val}
            </MenuItem>
          ))}
        </Select>
      </FormControl>
      <LocalizationProvider dateAdapter={AdapterDateFns}>
        <DateTimePicker
          label="Data wizyty"
          value={visitDate}
          onChange={(value) => setVisitDate(value)}
          renderInput={(params) => <TextField {...params} />}
        />
      </LocalizationProvider>
      <Button
        variant="contained"
        style={{ marginTop: "30px" }}
        onClick={() => addVisit()}
      >
        DODAJ WIZYTE
      </Button>
    </div>
  );
};
export default PatientSearch;
