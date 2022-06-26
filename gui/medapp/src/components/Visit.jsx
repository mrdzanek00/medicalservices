import { useState } from "react";
import Typography from "@mui/material/Typography";
import moment from "moment";
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
const PatientSearch = ({ patientId, spec }) => {
  const [availableDoctors, setAvailableDoctors] = useState([
    "Jan Kowalski",
    "Adam Nowak",
  ]);
  const [visitLengths, setVisitLengths] = useState([
    "30 minut",
    "60 minut",
    "90 minut",
  ]);
  const [doctor, setDoctor] = useState("Jan Kowalski");
  const [visitLength, setVisitLength] = useState("30 minut");
  const [visitDate, setVisitDate] = useState(new Date());
  const navigate = useNavigate();
  const addVisit = () => {
    //strzal doAPI
    navigate("/");
  };
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
          value={doctor}
          label="Lekarz"
          onChange={(e) => setDoctor(e.target.value)}
        >
          {availableDoctors.map((currDoctor, idx) => (
            <MenuItem key={`${currDoctor}_${idx}`} value={currDoctor}>
              {currDoctor}
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
