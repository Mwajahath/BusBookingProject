import React, { useState, useEffect } from "react";
import "./Booking.css";
import {
  Typography,
  Button,
  Grid,
  Select,
  MenuItem,
} from "@material-ui/core";

import Modal from "react-modal";


Modal.setAppElement(document.getElementById("root"));


const DoctorList = ({ baseUrl, getUserAppointments, userAppointments }) => {
  const [startingPoint, setStartingPoint] = useState("");
  const [destination, setDestination] = useState("");
  const [startingPointList, setStartingPointList] = useState([]);
  const [destinationList, setDestinationList] = useState([]);
  const [booking, setBooking] = useState("");


  const getStartingPoint = async () => {
    const url = baseUrl + "bus/startingPoint";

    try {
      const rawResponse = await fetch(url);

      if (rawResponse.ok) {
        const response = await rawResponse.json();
        await setStartingPointList(response);
      } else {
        const error = new Error();
        error.message = "Some Error Occurred";
        throw error;
      }
    } catch (e) {
      alert(e.message);
    }
  };

  const getDestination = async () => {
    const url = baseUrl + "bus/destination";

    try {
      const rawResponse = await fetch(url);

      if (rawResponse.ok) {
        const response = await rawResponse.json();
        await setDestinationList(response);
      } else {
        const error = new Error();
        error.message = "Some Error Occurred";
        throw error;
      }
    } catch (e) {
      alert(e.message);
    }
  };



  const changeStartingPointHandler = (event) => {
    setStartingPoint(event.target.value);

  };

  const changeDestinationHandler = (event) => {
    setDestination(event.target.value);
  };

  // const closeModalHandler = () => {
  //   setIsModalOpen(false);
  // };

  return (
    <div>
      <form>
        <Grid item xs={12} sm container alignItems="center" direction="column">
          <Typography component="div" id="selectHeading">
            Select Starting Point:
          </Typography>
          <Select
            variant="filled"
            labelId="speciality"
            id="speciality"
            value={startingPoint}
            style={{ minWidth: "200px" }}
            onChange={changeStartingPointHandler}
          >
            <MenuItem key={"spec none"} value={""}>
              NONE
            </MenuItem>
            <MenuItem >
              Hyderabad
            </MenuItem><MenuItem >
              Banglore
            </MenuItem><MenuItem >
              Channai
            </MenuItem>
          </Select>

          <Typography component="div" id="selectHeading">
            Select Destination:
          </Typography>
          <Select
            variant="filled"
            labelId="speciality"
            id="speciality"
            value={destination}
            style={{ minWidth: "200px" }}
            onChange={changeDestinationHandler}
          >
            <MenuItem key={"spec none"} value={""}>
              NONE
            </MenuItem>

            <MenuItem >
              Hyderabad
            </MenuItem><MenuItem >
              Banglore
            </MenuItem><MenuItem >
              Channai
            </MenuItem>

          </Select>


          <Button
            style={{ width: "40%", margin: "10px" }}
            variant="contained"
            color="primary"
            onClick={() => {
              setBooking(booking);

            }}
            type="submit"
          >

            Book Ticket
          </Button>



        </Grid>
      </form>
    </div >
  );
};

export default DoctorList;
