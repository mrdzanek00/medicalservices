import { useState } from "react";
import Typography from "@mui/material/Typography";
import { Button, TextField, Alert } from "@mui/material";
import { useNavigate } from "react-router-dom";
const PatientSearch = ({ setId }) => {
  const [name, setName] = useState("");
  const [surname, setSurname] = useState("");
  const [alertVisible, setAlertVisible] = useState(false);
  const navigate = useNavigate();
  const searchPatient = () => {
    setId(3); //DO ZMIANY
    if (true) navigate(`/chooseSpec`);
    //patient not found
    else setAlertVisible(true);
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
