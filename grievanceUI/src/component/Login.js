import React, { useEffect, useState } from 'react'
import api from '../assets/axios.js';
import { useNavigate } from 'react-router-dom';
import MessageSucess from './ErrorMessage.js';
function Login() {
    const initailLogin = {
        isSubmiting: false,
        username: "",
        password: "",
    }

    const navigate = useNavigate();
    const [userLogin, setUserLogin] = useState(initailLogin);
    const [formError, setFormError] = useState(null);
    const [show, setShow] = useState("");
    const [errorMessage, setErrorMessage] = useState("");
    const { isSubmiting, username, password } = userLogin;

    function inputHandler(e) {

        setUserLogin({ ...userLogin, [e.target.name]: e.target.value })
    }

    const checkAuthentication = async (e) => {
        e.preventDefault();
        if (userLogin.username === '') {

            setErrorMessage("username is requied")
            setShow("show")
            return
        }
        if (password === '') {
            setErrorMessage("password is requied")
            setShow("show")
            return
        }
        const url = '/login/authorization';
        const res = await api.post(url,{username:userLogin.username,password:btoa(userLogin.password)})
        if (res.data !== "Invalid credential") {
            const urlVal = '/user/byUsername/' + username;
            const userData = await api.get(urlVal)
            console.log(userData.data);
            sessionStorage.setItem("userId", userData.data.userId);
            sessionStorage.setItem("username", userData.data.username);
            sessionStorage.setItem("userType", userData.data.role.name);
            sessionStorage.setItem("password", userData.data.password);
            sessionStorage.setItem("departmentId", userData.data.department.deptId);
            if(userData.data.initialPassword === 1){
                navigate("/user/changepassword")
            }
            else if (userData.data.role.name === "Admin") {
                navigate("/admin")
            }
            else if (userData.data.role.name === "Member") {
                navigate("/member")
            }
        }
        else {
            console.log(res.data);
            setErrorMessage("Invalid credential")
            setShow("show")
        }
    }
    const handleClose = () => {
        setShow("");
    }
    return (
        <>
            <MessageSucess message={errorMessage} show={show} onClick={handleClose} />
            <div className='Login-body'>
                <div className='container-left'>

                </div>
                <div className='container form-box' >

                    <div className='' >
                        <div className='headline'>
                            <p className="form-group ">Welcome to</p>
                            <p className="form-group ">Grievance/Feedback</p>
                            <p className="form-group ">Management System</p>

                        </div>
                        <div>
                            <label className="form-group formName">Sign in</label>

                        </div>
                        <div className="form-group">
                            <label htmlFor="username" className="labelbox">Username</label>
                            <input type="text" className="inputBox" id="username" name="username" value={username} disabled={isSubmiting} onChange={(e) => { inputHandler(e) }} />
                            <div id="usernameHelp" className=""></div>
                        </div>
                        <div className="form-group">
                            <label htmlFor="password" className="labelbox" >Password</label>
                            <input type="password" className="inputBox" id="password" name="password" value={password} disabled={isSubmiting} onChange={(e) => { inputHandler(e) }} />
                            <div id="passwordHelp" className=""></div>
                        </div>
                        <div className='form-group'>
                            <button type="submit" className="myBtn" onClick={checkAuthentication}>Submit</button>
                        </div>



                    </div>
                </div>
            </div>
        </>
    )
}

export default Login