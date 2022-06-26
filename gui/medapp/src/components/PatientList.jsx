import React from "react";
import { useEffect } from "react";
import { useState } from "react";
import PatientService from "../services/PatientService";
import data from "./__mocks__/patients.json";
import Table from "@mui/material/Table";
import TableBody from "@mui/material/TableBody";
import TableCell from "@mui/material/TableCell";
import TableContainer from "@mui/material/TableContainer";
import TableHead from "@mui/material/TableHead";
import TableRow from "@mui/material/TableRow";
import Paper from "@mui/material/Paper";
const PatientList = () => {
  const [patients, setPatients] = useState([]);
  useEffect(() => setPatients(data), []);
  return (
    <TableContainer component={Paper}>
      <Table sx={{ minWidth: 650 }} aria-label="simple table">
        <TableHead>
          <TableRow>
            <TableCell align="right">Doctor name</TableCell>
            <TableCell align="right">Doctor surname</TableCell>
            <TableCell align="right">Patient name</TableCell>
            <TableCell align="right">Patient surname</TableCell>
            <TableCell align="right">Visit date</TableCell>
            <TableCell align="right">Visit duration</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {patients.map((row) => (
            <TableRow
              key={row.id_person}
              sx={{ "&:last-child td, &:last-child th": { border: 0 } }}
            >
              <TableCell align="right">Jan</TableCell>
              <TableCell align="right">Kowalski</TableCell>
              <TableCell align="right">Mateusz</TableCell>
              <TableCell align="right">Rdzanek</TableCell>
              <TableCell align="right">10-06-2000</TableCell>
              <TableCell align="right">30 minut</TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
  );
};
export default PatientList;
