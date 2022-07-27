import React, { useState, useEffect } from "react";
import "./Booking.css";
import {
  Paper,
  Typography,
  Button,
  Grid,
  Select,
  MenuItem,

} from "@material-ui/core";

import Modal from "react-modal";


Modal.setAppElement(document.getElementById("root"));


const Booking = ({ baseUrl, isLogin }) => {
  const [startingPoint, setStartingPoint] = useState("");
  const [destination, setDestination] = useState("");
  const [startingPointList, setStartingPointList] = useState([]);
  const [destinationList, setDestinationList] = useState([]);
  const [bus, setBus] = useState("");
  const [busList, setBusList] = useState([]);
  const [bookedSuccessfully, setBookedSuccessfully] = useState(false);
  const [load, setLoad] = useState(false);


  const accessToken = sessionStorage.getItem("accessToken");

  //fetching source location
  const getStartingPoint = async () => {
    const url = baseUrl + "bus/startingPoint";
    try {
      const rawResponse = await fetch(url, {
        headers: {
          Authorization: `Bearer ${accessToken}`,
        }
      });

      if (rawResponse.ok) {
        const response = await rawResponse.json();
        await setStartingPointList(response);
      } else {
        const error = new Error();
        error.message = "Some Error Occurred while fetching source";
        throw error;
      }
    } catch (e) {
      alert(e.message);
    }
  };

  //fetching destinations
  const getDestination = async () => {
    const url = baseUrl + "bus/destination";

    try {
      const rawResponse = await fetch(url, {
        headers: {
          Authorization: `Bearer ${accessToken}`,
        }
      });

      if (rawResponse.ok) {
        const response = await rawResponse.json();
        await setDestinationList(response);
      } else {
        const error = new Error();
        error.message = "Some Error Occurred while fetching destination";
        throw error;
      }
    } catch (e) {
      alert(e.message);
    }
  };

  //fetching buses based on route
  const getFilteredBuses = async (source, destination) => {
    const url = baseUrl + "bus?source=" + encodeURI(source) + "&destination=" + encodeURI(destination);

    try {
      const rawResponse = await fetch(url, {
        headers: {
          Authorization: `Bearer ${accessToken}`,
        }
      });

      if (rawResponse.ok) {
        const response = await rawResponse.json();
        setBusList(response);
      } else {
        const error = new Error();
        error.message = "Some Error Occurred";
        throw error;
      }
    } catch (e) {
      alert(e.message);
    }
  };

  const bookTicketHandler = async (e) => {
    if (e) e.preventDefault();


    const emailId = JSON.parse(sessionStorage.getItem("userId"));
    const userDetails = JSON.parse(sessionStorage.getItem("user-details"));
    const accessToken = sessionStorage.getItem("accessToken");
    let data = {
      busId: bus.id,
      busName: bus.busName,
      userId: emailId,
      userName: `${userDetails.firstName} ${userDetails.lastName}`,
    };

    const url = baseUrl + "booking/bookTicket";

    try {
      const rawResponse = await fetch(url, {
        method: "POST",
        headers: {
          Accept: "application/json",
          "Content-Type": "application/json;charset=UTF-8",
          Authorization: `Bearer ${accessToken}`,
        },
        body: JSON.stringify(data),
      });

      if (rawResponse.ok) {
        setBookedSuccessfully(true);
      }
      if (rawResponse.status === 400) {
        alert("Either the slot is already booked or not available");
      }
    } catch (e) {
      alert(e.message);
    }
  };



  const changeStartingPointHandler = (source) => {
    setStartingPoint(source.target.value);

  };

  const changeDestinationHandler = (destination) => {
    setDestination(destination.target.value);
  };


  useEffect(() => {
    if (isLogin === true) {
      getDestination();
      getStartingPoint();
    }
    if (load === true) {
      bookTicketHandler();
    }
  }, [isLogin, load]);

  return (
    <div>
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
          {startingPointList.map((item) => (
            <MenuItem key={"spec" + item} value={item}>
              {item}
            </MenuItem>
          ))}
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

          {destinationList.map((item) => (
            <MenuItem key={"spec" + item} value={item}>
              {item}
            </MenuItem>
          ))}

        </Select>

        <Button
          style={{ width: "40%", margin: "10px" }}
          variant="contained"
          color="primary"
          onClick={() => {
            getFilteredBuses(startingPoint, destination)
          }}
        >
          Check Available Buses
        </Button>


        {busList.map((bus) => {
          return (

            <Paper
              key={bus.id}
              variant="elevation"
              className="doctorListContainer"
              elevation={3}
            >
              <Typography variant="h6" component="h2" gutterBottom>
                Bus Name : {bus.busName}
              </Typography>
              <br />
              <Typography component="h4" variant="body1">
                Starting Point : {bus.source}
              </Typography>
              <Typography component="h4" variant="body1">
                Destination : {bus.destination}
              </Typography>
              <Button

                style={{ width: "40%", margin: "10px" }}
                variant="contained"
                color="primary"
                onClick={() => {
                  setBus(bus)
                  setLoad(true)

                }}
              >
                Book Ticket
              </Button>
              <br />
              {bookedSuccessfully === true && (

                alert("Ticket Booked Succefully")

              )}
              <br />

            </Paper>

          );
        })}
      </Grid>

    </div >
  );
};

export default Booking;
