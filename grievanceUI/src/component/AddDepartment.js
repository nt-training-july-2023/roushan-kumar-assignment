import React, { useState } from 'react'
import { saveDepartment } from '../service/departmentService.js';
import ErrorMessage from './ErrorMessage.js';
function AddDepartment({ onClick }) {

  const [department, setDepartment] = useState("");
  const [errorMessage, setErrorMessage] = useState("");
  const [show, setShow] = useState("");
  const inputHandler = (e) => {
    setDepartment(e.target.value);
  }
  const submitHandler = async (e) => {
    e.preventDefault();
    try {
      const requestBody = {
        "deptName": department,
      };
      const res = await saveDepartment(
        requestBody,
        sessionStorage.getItem("userId"),
        sessionStorage.getItem("password"),
        sessionStorage.getItem("username"),
        );
        if(res.data.deptName)
        setErrorMessage("New Departmetn Added.")
        setShow("show")
    } catch (error) {
      setErrorMessage(error.response.data)
      setShow("show")
    }

  }
  const clearHandler = (e) => {
    e.preventDefault();
  }
  const handleClose = () => {
    setShow("");
 }
  return (
    <>
      <ErrorMessage message={errorMessage} show={show} onClick={handleClose} />
      <div id="add_Department_Div" className='initial_pass wrapper_pass'>
        <div className='title'>
          Add Department
        </div>
        <form className='form'  >
          <div className='input_field'>
            <label>Department Name</label>
            <input type="text"
              className='input'
              id="deptName"
              name="deptName"
              value={department}
              onChange={inputHandler}
              placeholder='Department Name'
            >

            </input>
          </div>

          <div className='input_field'>
            <input type="submit" value={"close"} className='btnNew btnNewCancle ' onClick={onClick}></input>
            <input type="submit" value={"save"} className='btnNew btnNewOk' onClick={submitHandler}></input>

          </div>
        </form>
      </div>
      
    </>
  )
}

export default AddDepartment