import { useState } from "react";
import Typography from "@mui/material/Typography";
import { useNavigate } from "react-router-dom";
import {
  Button,
  Select,
  MenuItem,
  InputLabel,
  FormControl,
} from "@mui/material";
import { useEffect } from "react";
import SpecializationService from "../services/SpecializationService"
const PatientSearch = ({ patientId, spec, setSpec }) => {
  const navigate = useNavigate();
  const [availableSpec, setAvailableSpec] = useState([]);
  const chooseSpec = () => {
    navigate("/visitInfo");
  };

  useEffect(() => {
    SpecializationService.getSpecializations().then((res) => {
      console.log(res.data)
      const specs = [];
      for (const spec in res.data)
        specs.push(res.data[spec].specName);

      setAvailableSpec(specs); 

  });

  },[])

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
      <Typography variant="h3">Wybór specjalisty</Typography>
      <Typography variant="h6">Specjalista:</Typography>
      <FormControl fullWidth>
        <InputLabel id="demo-simple-select-label">Specjalizacja</InputLabel>
        <Select
          labelId="demo-simple-select-label"
          id="demo-simple-select"
          value={spec}
          label="Specializacja"
          onChange={(e) => setSpec(e.target.value)}
        >
          {availableSpec.map((currSpec, idx) => (
            <MenuItem key={`${currSpec}_${idx}`} value={currSpec}>
              {currSpec}
            </MenuItem>
          ))}
        </Select>
      </FormControl>
      <Button
        variant="contained"
        style={{ marginTop: "30px" }}
        onClick={() => chooseSpec()}
      >
        WYBIERZ
      </Button>
    </div>
  );
};
export default PatientSearch;
