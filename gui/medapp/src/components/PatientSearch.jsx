import { useState } from "react";
import Typography from "@mui/material/Typography";
import { Button, TextField, Alert } from "@mui/material";
import { useNavigate } from "react-router-dom";
import PatientService from "../services/PatientService"
const PatientSearch = ({ setId }) => {
  const [idPatient, setIdPatient] = useState("");
  const [name, setName] = useState("");
  const [surname, setSurname] = useState("");
  const [alertVisible, setAlertVisible] = useState(false);
  const navigate = useNavigate();
  const searchPatient = () => {
  PatientService.getPatientByName(name,surname).then((res) => {
      console.log(name,surname)
      setId(res.data.id_person)
      if (res.data.id_person)
     navigate(`/chooseSpec`);
    //patient not found
    else setAlertVisible(true);

  });


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
      <Typography variant="h3">Wyszukiwanie pacjenta</Typography>
      <TextField
        variant="standard"
        label="Imie"
        value={name}
        onChange={(e) => setName(e.target.value)}
      />
      <TextField
        variant="standard"
        label="Nazwisko"
        value={surname}
        onChange={(e) => setSurname(e.target.value)}
      />
      <Button
        disabled={name.length === 0 || surname === 0 ? true : false }
        variant="contained"
        style={{ marginTop: "30px" }}
        onClick={() => searchPatient()}
      >
        WYSZUKAJ
      </Button>
      <Alert
        variant="filled"
        severity="error"
        style={{ marginTop: "20px", display: alertVisible ? "block" : "none" }}
      >
        Nie znaleziono pacjenta!
      </Alert>
    </div>
  );
};
export default PatientSearch;
