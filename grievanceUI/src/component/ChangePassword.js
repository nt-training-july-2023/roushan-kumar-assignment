import React, { useState } from 'react'
import '../assets/css/initialpass.css'
import api from '../service/axios';
import { useNavigate } from 'react-router-dom';
import ErrorMessage from './ErrorMessage';
import Input from './Input';
import { updatePassword } from '../service/userService';
function ChangePassword() {
  const navigate = useNavigate();
  
  const UID = sessionStorage.getItem("userId");
 
  const [show, setShow] = useState("");
  const [errorMessage, setErrorMessage] = useState("");
  const initialData = {
    "userId": UID,
    "oldPassword": "",
    "newPassword": "",
    "conPassword": ""
  }
  const [changePassword, setChangePassword] = useState(
    initialData
  );

  const inputHandler = (e) =>{
    setChangePassword({...changePassword,[e.target.name]:e.target.value})
  }
  function checKConfirmPassword ()
  {
    if(changePassword.conPassword === changePassword.newPassword)
    {
      return true;
    }
    
    return false;
  }
  function checkPasswordValid()
  {
    if (changePassword.conPassword.length<8 || changePassword.newPassword.length<8)
    {
      return false;
    }
    return true;
  }
  const submitHandler = async(e) => {
    e.preventDefault();
    
    if(!checKConfirmPassword())
    {
      setErrorMessage("Password not match.")
        setShow("show")
      return false;
    }

    if(!checkPasswordValid())
    {
      setErrorMessage("Password should be min 8 charactor")
      setShow("show")
    return false;
    }
    try {
      const res = await updatePassword(changePassword);
      if (res.data.id) {
        sessionStorage.setItem("password",btoa(changePassword.newPassword))
        navigate('/')
      }
      else{
        setErrorMessage(res.data.message)
        setShow("show")
      }
      
    } catch (error) {
      console.log(error.response.data);
    }
  }
  const clearHandler = (e) => {
    e.preventDefault();
    setChangePassword(initialData);

  }
  const handleClose = () => {
    setShow("");
}

if(UID === null || UID === "")
{ 
  window.location.href = "http://localhost:3000/";
}
  return (
    <div>
      <ErrorMessage message={errorMessage} show={show} onClick={handleClose} />
      <div className='initial_pass wrapper_pass'>
        <div className='title'>
          Change Password
        </div>
        <form className='form'  >
          <div className='input_field'>
            <label>Old Password</label>
            <Input type="password"
              className='input'
              id="oldPassword"
              name="oldPassword"
              value={changePassword.oldPassword}
              onChange={inputHandler}
              placeholder='Old Password'
            >

            </Input>
          </div>
          <div className='input_field'>
            <label>New Password</label>
            <Input type="password"
              className='input'
              id="newPassword"
              name="newPassword"
              value={changePassword.newPassword}
              onChange={inputHandler}
              placeholder='New Password'
            >

            </Input>
          </div>
          <div className='input_field'>
            <label>Confirm Password</label>
            <Input type="password"
              className='input'
              id="conPassword"
              name="conPassword"
              value={changePassword.conPassword}
              onChange={inputHandler}
              placeholder='Confirm Password'
            >

            </Input>
          </div>
          <div className='input_field'>
            <Input type="submit" value={"Clear"} className='btnNew btnClear' onClick={clearHandler}></Input>
            <Input type="submit" value={"Save"} className='btnNew  btnSave' onClick={submitHandler}></Input>

          </div>
        </form>
      </div>
    </div>
  )
}

export default ChangePassword