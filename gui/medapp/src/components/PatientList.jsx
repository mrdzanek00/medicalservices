import React from "react";
import { useEffect } from "react";
import { useState } from "react";
import PatientService from "../services/PatientService";
import Table from "@mui/material/Table";
import TableBody from "@mui/material/TableBody";
import TableCell from "@mui/material/TableCell";
import TableContainer from "@mui/material/TableContainer";
import TableHead from "@mui/material/TableHead";
import TableRow from "@mui/material/TableRow";
import moment from "moment";
import Paper from "@mui/material/Paper";
import data from "./patients.json";
const PatientList = () => {
  const [patients, setPatients] = useState([]);
  useEffect(() => {
    setPatients(data);
  }, []);
  return (
    <TableContainer component={Paper}>
      <Table sx={{ minWidth: 650 }} aria-label="simple table">
        <TableHead>
          <TableRow>
            <TableCell align="right">Doctor id</TableCell>
            <TableCell align="right">Patient id</TableCell>
            <TableCell align="right">Visit date</TableCell>
            <TableCell align="right">Visit hour</TableCell>
            <TableCell align="right">Visit duration</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {patients.map((row) => (
            <TableRow
              key={row.id_visit}
              sx={{ "&:last-child td, &:last-child th": { border: 0 } }}
            >
              <TableCell align="right">{row.id_doctor}</TableCell>
              <TableCell align="right">{row.id_patient}</TableCell>
              <TableCell align="right">
                {moment(row.beginDate).format("DD-MM-YYYY")}
              </TableCell>
              <TableCell align="right">
                {moment(row.beginDate).format("HH:mm")}
              </TableCell>
              <TableCell align="right">{row.duration} minut</TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
  );
};
export default PatientList;
