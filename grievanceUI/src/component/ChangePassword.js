import React, { useState } from 'react'
import '../assets/css/initialpass.css'
import api from '../service/axios';
import { useNavigate } from 'react-router-dom';
import ErrorMessage from './ErrorMessage';
function ChangePassword() {
  const navigate = useNavigate();
  const UID = sessionStorage.getItem("userId");
  const [show, setShow] = useState("");
  const [errorMessage, setErrorMessage] = useState("");
  const [changePassword, setChangePassword] = useState(
    {
      "userId": UID,
      "oldPassword": "",
      "newPassword": "",
      "conPassword": ""
    }
  );

  const [request, setRequest] = useState(
    {
      "userId": "",
      "oldPassword": "",
      "newPassword": ""
      
    }
  );
  
  const inputHandler = (e) =>{
    setChangePassword({...changePassword,[e.target.name]:e.target.value})
  }
  function checKConfirmPassword ()
  {
    if(changePassword.conPassword === changePassword.newPassword)
    {
      // setRequest({
      //   userId:UID,
      //   newPassword:changePassword.newPassword,
      //   oldPassword:changePassword.oldPassword
      // })
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
      console.log(changePassword);
      const url = '/user/changepassword';
      const res = await api.put(url,changePassword);
      console.log(res.data);
      if (res.data.id) {
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
  }
  const handleClose = () => {
    setShow("");
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
            <input type="password"
              className='input'
              id="oldPassword"
              name="oldPassword"
              value={changePassword.oldPassword}
              onChange={inputHandler}
              placeholder='Old Password'
            >

            </input>
          </div>
          <div className='input_field'>
            <label>New Password</label>
            <input type="password"
              className='input'
              id="newPassword"
              name="newPassword"
              value={changePassword.newPassword}
              onChange={inputHandler}
              placeholder='New Password'
            >

            </input>
          </div>
          <div className='input_field'>
            <label>Confirm Password</label>
            <input type="password"
              className='input'
              id="conPassword"
              name="conPassword"
              value={changePassword.conPassword}
              onChange={inputHandler}
              placeholder='Confirm Password'
            >

            </input>
          </div>
          <div className='input_field'>
            <input type="submit" value={"clear"} className='btnNew btnNewCancle' onClick={clearHandler}></input>
            <input type="submit" value={"save"} className='btnNew btnNewOk' onClick={submitHandler}></input>

          </div>
        </form>
      </div>
    </div>
  )
}

export default ChangePassword