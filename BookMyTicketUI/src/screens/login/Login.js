import { FormControl, Input, InputLabel, FormHelperText } from "@mui/material";
import Button from "@mui/material/Button";
import { useState } from "react";
import ErrorPopover from "../../common/ErrorPopover";

const Login = ({ loginUser, isLogin }) => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [invalidEmail, setInvalidEmail] = useState("none");

  const emailChangeHandler = (e) => {
    setEmail(e.target.value);
    setInvalidEmail("none");
  };

  const passwordChangeHandler = (e) => {
    setPassword(e.target.value);
  };

  //error popup state
  const [anchorEl, setAnchorEl] = useState(null);
  const setParentAnchorElNull = () => {
    setAnchorEl(null);
  };

  const loginHandler = async (e) => {
    if (e) e.preventDefault();

    //validating
    if (email === "") {
      setAnchorEl(e.currentTarget.children[0]);
      return;
    }
    if (password === "") {
      setAnchorEl(e.currentTarget.children[2]);
      return;
    }

    const emailPattern =
      /^(([^<>()[\].,;:\s@"]+(\.[^<>()[\].,;:\s@"]+)*)|(".+"))@(([^<>()[\].,;:\s@"]+\.)+[^<>()[\\.,;:\s@"]{2,})$/i;

    if (!email.match(emailPattern)) {
      setInvalidEmail("block");
      return;
    } else {
      setInvalidEmail("none");
    }
    loginUser(email, password);
  };
  return (
    <div>
      <form onSubmit={loginHandler}>
        <FormControl required margin="dense">
          <InputLabel htmlFor="email">Email address</InputLabel>
          <Input
            id="email"
            type="email"
            value={email}
            aria-describedby="my-helper-text"
            onChange={emailChangeHandler}
          />
          {email.length >= 1 && invalidEmail === "block" && (
            <FormHelperText className={invalidEmail}>
              <span className="red" style={{ color: "red" }}>
                Enter valid Email
              </span>
            </FormHelperText>
          )}
          <ErrorPopover
            anchor={anchorEl}
            setParentAnchorElNull={setParentAnchorElNull}
          />
        </FormControl>
        <br />
        <FormControl>
          <InputLabel htmlFor="password">Password</InputLabel>
          <Input
            id="password"
            type="password"
            value={password}
            aria-describedby="my-helper-text"
            onChange={passwordChangeHandler}
          />
          <ErrorPopover
            anchor={anchorEl}
            setParentAnchorElNull={setParentAnchorElNull}
          />
        </FormControl>
        <br />
        <br />
        {isLogin === true && (
          <FormControl>
            <span>Login Successful.</span>
          </FormControl>
        )}
        <br />
        <Button variant="contained" className="login-bt" type="submit">
          Login
        </Button>
      </form>
    </div>
  );
};

export default Login;
