import React, { useState, useEffect } from "react";
import Header from "../../common/header/Header";
import { Tab, Tabs } from "@material-ui/core";
import Booking from "../booking/Booking";


const Home = ({ baseUrl }) => {
  const emailId = JSON.parse(sessionStorage.getItem("userId"));
  const [value, setValue] = useState(0);
  const [isLogin, setIsLogin] = useState(false);
  const tabSwitchHandler = (event, value) => {
    setValue(value);
  };


  useEffect(() => {

    // eslint-disable-next-line
  }, [isLogin]);

  return (
    <div>
      <Header baseUrl={baseUrl} isLogin={isLogin} setIsLogin={setIsLogin} />
      <Tabs
        variant="fullWidth"
        indicatorColor="primary"
        value={value}
        onChange={tabSwitchHandler}
      >
        <Tab label="Book Ticket"></Tab>
      </Tabs>
      {value === 0 && (
        <Booking

          baseUrl={baseUrl}
        />
      )}
    </div>
  );
};

export default Home;
