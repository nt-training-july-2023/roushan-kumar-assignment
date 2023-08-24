import React, { useState } from 'react'
import { ToastContainer, toast } from 'react-toastify';
import api from '../../assets/axios.js';
import { useNavigate } from 'react-router-dom';
function Login() {
    const initailLogin = {
        isSubmiting:false,
        username:"",
        password:"",
    }

    const navigate = useNavigate();

    const [userLogin, setUserLogin] = useState(initailLogin);
    const [formError, setFormError] = useState(null);

    const { isSubmiting, username,password } = userLogin;

    function inputHandler(e){
        setUserLogin({...userLogin,[e.target.name]:e.target.value})
    }


    const checkAuthentication = async ()=>{
        const res =  await api.post('api/login/authorization',userLogin)
        console.log(res.data);
        if(res.data !== "Invalid credantial")
        {
            toast.success("success", {
                position: toast.POSITION.TOP_CENTER
            });
            navigate("/admin")

        }
        else
         {
            toast.error("invalid", {
                position: toast.POSITION.TOP_CENTER
            });
         }
    }
    return (
        <>
            <div className='container form-box'>
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
                        <input type="text" className="inputBox" id="username" name="username" value={username} disabled={isSubmiting} onChange={(e)=>{inputHandler(e)}}/>
                        <div id="usernameHelp" className=""></div>
                    </div>
                    <div className="form-group">
                        <label htmlFor="password" className="labelbox" >Password</label>
                        <input type="password" className="inputBox" id="password" name="password" value={password} disabled={isSubmiting} onChange={(e)=>{inputHandler(e)}} />
                        <div id="passwordHelp" className=""></div>
                    </div>
                    <div className='form-group'>
                    <button type="submit" className="myBtn" onClick={checkAuthentication}>Submit</button>
                    </div>
                    
                    
                    <ToastContainer />
                </div>
            </div>
        </>
    )
}

export default Login