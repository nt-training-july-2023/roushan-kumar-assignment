import React, { useState } from 'react'

import '../style.css'

function Registration() {

  const regData = {
    isSubmiting: false,
    fullname: "",
    username: "",
    email: "",
    phoneNumber: "",
    password: "",
    conPassword: "",
    gender: "",

  }

  const [empReg, setEmpReg] = useState(regData);
  const [formError, setFormError] = useState(null)
  const { isSubmiting, fullname, username, email, phoneNumber, password, gender, conPassword } = empReg

  function inputHandler(e) {
    //document.querySelector('input[name="Gender"][value="1"]').checked = true;


    if (e.target.name === 'phoneNumber') {
      let vPhone;

      // if(e.target.value.length>10)
      //   return false;

      if (e.target.value.length >= 1) {
        vPhone = validPhone(e.target.value)
        if (!vPhone) {
          return false
        }
      }

    }

    setEmpReg({
      ...empReg,
      [e.target.name]: e.target.value,
    });


  }

  function genderInputHandler() {
    let genderVal = document.querySelector('input[name=Gender]:checked').value;
    setEmpReg({ ...empReg, gender: genderVal })
  }

  const submit = (e) => {
    e.preventDefault();
    setFormError(null)
    setEmpReg({
      ...empReg,
      isSubmiting: true,
    })
    let error = validation();

    setTimeout(() => {
      if (error) {
        setFormError(error);
        setEmpReg({
          ...empReg,
          isSubmiting: false,
        });
        return;
      }
      else {
        setTimeout(() => {
          setEmpReg({
            ...empReg,
            isSubmiting: false,
          })
        }, 2000);
        console.log(gender + " " + fullname);
      }
    }, 1);


    

    //alert(document.querySelector('input[name=Gender]:checked').value);
    //alert(gender+" "+fullname);
  }

  function validPhone(value) {
    //console.log(e.target.value);
    const charCode = value
    const reg = new RegExp('^[0-9]{0,10}$');

    // console.log(reg.test(charCode));
    return reg.test(charCode);
  }

  function validation() {
    let error = false;
    if (fullname === "") {
      error = {
        fieldName: "fullname",
        message: "Full name is required."
      };
      return error;
    }
    if (email === "") {
      error = {
        fieldName: "email",
        message: "email is required."
      };
      return error;
    }

    if (password === "") {
      error = {
        fieldName: "password",
        message: "password is required."
      };
      return error;
    }
    if (username === "") {
      error = {
        fieldName: "username",
        message: "username is required."
      };
      return error;
    }

    if (phoneNumber === "") {
      error = {
        fieldName: "phoneNumber",
        message: "phone Number is required."
      };
      return error;
    }

    if (phoneNumber.length!==10) {
      error = {
        fieldName: "phoneNumber",
        message: "phone Number is not valid."
      };
      return error;
    }



    if (conPassword === "") {
      error = {
        fieldName: "conPassword",
        message: "Confirm Password is required."
      };
      return error;
    }

    if (conPassword !== password) {
      error = {
        fieldName: "conPassword",
        message: "Confirm Password did not match."
      };
      return error;
    }

    if (gender === "") {
      // alert("Gender is required.")
      error = {
        fieldName: "gender",
        message: "Gender is required."
      };
      return error;
    }




    return error
  }

  return (
    <div className="registration">
      <div className="containerReg ">
        <div> <label className="formName m-l">Registation</label> </div>

        <br />
        <div className="row col-12">
          <div className="col-6">
            <label htmlFor="" className="labelbox">Full Name</label>
            <input className="inputBox" type="text" placeholder="Enter you name" id='fullname' name='fullname' value={fullname} disabled={isSubmiting} onChange={inputHandler} />
            {formError && (formError.fieldName === "fullname") ? <p className='errorMessage'>{formError.message}</p> : null}

            <label htmlFor="" className="labelbox">Email </label>
            <input className="inputBox" type="text" placeholder="Enter you email" id='email' name='email' value={email} disabled={isSubmiting} onChange={inputHandler} />
            {formError && (formError.fieldName === "email") ? <p className='errorMessage'>{formError.message}</p> : null}

            <label htmlFor="" className="labelbox">Password </label>
            <input className="inputBox" type="password" placeholder="Enter you password" id='password' name='password' value={password} disabled={isSubmiting} onChange={inputHandler} />
            {formError && (formError.fieldName === "password") ? <p className='errorMessage'>{formError.message}</p> : null}

          </div>

          <div className="col-6">
            <label htmlFor="" className="labelbox"> Username</label>
            <input className="inputBox" type="text" placeholder="Enter you username" id='username' name='username' value={username} disabled={isSubmiting} onChange={inputHandler} />
            {formError && (formError.fieldName === "username") ? <p className='errorMessage'>{formError.message}</p> : null}

            <label htmlFor="" className="labelbox">Phone Number </label>
            <input className="inputBox" type="text" placeholder="Enter you  number" id='phoneNumber' name='phoneNumber' value={phoneNumber} disabled={isSubmiting} onChange={inputHandler} />
            {formError && (formError.fieldName === "phoneNumber") ? <p className='errorMessage'>{formError.message}</p> : null}

            <label htmlFor="" className="labelbox"> Confirm Password</label>
            <input className="inputBox" type="password" placeholder="confirm your password" id='conPassword' name='conPassword' value={conPassword} disabled={isSubmiting} onChange={inputHandler} />
            {formError && (formError.fieldName === "conPassword") ? <p className='errorMessage'>{formError.message}</p> : null}

          </div>

          <div className="col-12 m-l ">
            <label className="Gender">Gender</label>
            {formError && (formError.fieldName === "gender") ? <p className='errorMessage ' style={{ marginLeft: '10%', marginTop: '-17px' }}>{formError.message}</p> : null}
            <br>
            </br>
          </div>

          <div className="row col-12 m-l">
            <div className="col-3 ">



              <label className="col-3 cont">Male
                <input type="radio" name="Gender" value='1' disabled={isSubmiting} onChange={genderInputHandler} />
                <span className="checkmark"></span>
              </label>

            </div>
            <div className="col-3 " >


              <label className="col-3 cont" >Female
                <input type="radio" className="radioInput" name="Gender" value='2' disabled={isSubmiting} onChange={genderInputHandler} />
                <span className="checkmark"></span>
              </label>
            </div>
            <div className="col-3 ">

              <label className="col-3 cont">Prefer not to say
                <input type="radio" name="Gender" value='3' disabled={isSubmiting} onChange={genderInputHandler} />
                <span className="checkmark"></span>
              </label>

            </div>
          </div>

          <div className="col-12">
            <button className="myBtn col-12" id='submitBtn' disabled={isSubmiting} onClick={(e) => (submit(e))}>Register</button>
          </div>


        </div>
      </div>
    </div>
  )
}

export default Registration