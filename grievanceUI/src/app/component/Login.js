import React from 'react'
import { ToastContainer, toast } from 'react-toastify';
import api from '../../assets/axios.js';
function Login() {

    const checkAuthentication = async ()=>{
        const res =  await api.post('api/login/authorization',{"username":"roushan22","password":"1235"})
        console.log(res.data);
        if(res.data !== "Invalid credantial")
        {
            toast.success("success", {
                position: toast.POSITION.TOP_CENTER
            });
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
            <div className='container'>
                <div className='col-sm-12 col-md-6 col-xs-12' >
                <div className="mb-3">
                    <label htmlFor="username" className="form-label">Username</label>
                    <input type="text" className="form-control" id="username" aria-describedby="emailHelp" />
                    <div id="usernameHelp" className="form-text"></div>
                </div>
                <div className="mb-3">
                    <label htmlFor="password" className="form-label">Password</label>
                    <input type="password" className="form-control" id="password" />
                    <div id="passwordHelp" className="form-text"></div>
                </div>
                
                <button type="submit" className="btn btn-primary" onClick={checkAuthentication}>Submit</button>
                <ToastContainer />
                </div>
            </div>
        </>
    )
}

export default Login