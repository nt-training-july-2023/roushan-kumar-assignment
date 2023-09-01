import React, { useState } from 'react'
import '../../../assets/css/forms.css'
import { Link } from 'react-router-dom';
import api from '../../../assets/axios';
import MessageSucess from '../../component/MessageSucess';
function NewUser() {
    
    const roleDataBack = [
        {
            "roleId":"1",
            "name":"Admin"
        },
        {
            "roleId":"2",
            "name":"Member"
        },
    ]
    
    const deptDataBack = [
        {
            "deptId":"1",
            "deptName":"HR"
        },
        {
            "deptId":"2",
            "deptName":"FN"
        },
    ]
    

    const roleData = {
        "name" : ""
    }
    const departmentData = {
        "deptName" : ""
    }
    const newUser = {
            "username":"",
            "fullName":"",
            "email":"",
            "password":"",
            "role" : roleData,
            "department" : departmentData
        }
    
    const [user,setUser] = useState(newUser);
    const {username,fullName,email,password,role,department} = user;
    const [show, setShow] = useState("");
    const [errorMessage,setErrorMessage] = useState("");
    const inputHandler = (e)=>{
        setUser({
            ...user,
            [e.target.name]:e.target.value
        })
    }

    const inputRoleHandler = (e)=>{
        console.log("role inputRoleHandler : ",role);
        setUser({
            ...user,
            role: {
                ...role,
                name: e.target.value,
            },
        });
    }

    const inputDeptHandler = (e)=>{
        console.log("department inputDeptHandler : ",department);
        setUser({
            ...user,
            department: {
                ...department,
                deptName: e.target.value,
            },
        });
    }

    const newUserHandler = async (e)=>{
        e.preventDefault();
        setErrorMessage("Testing new user form")
            setShow("show")
        try {
            console.log("role : ",role);
            const result =   await api.post('/api/user/save', user);
            console.log(result.data);
        } catch (error) {
            console.log(error.response.data)
        }
        
        //alert("true");
    }
    const handleClose = ()=>{
        setShow("");
    }
  return (
    <>
        <MessageSucess message={errorMessage} show={show} onClick={handleClose} />
        <div className='wrapper'>
        <Link to="/admin" value="back">back</Link>
            <div className='title'>
                Add New User
            </div>
            <form className='form' onSubmit={newUserHandler} >
                <div className='input_field'>
                    <label>Name</label>
                    <input type="text" 
                           className='input' 
                           id="fullname" 
                           name="fullName" 
                           value={fullName} 
                           onChange={inputHandler} 
                           placeholder='full name'
                           required>
                           
                    </input>
                </div>

                <div className='input_field'>
                    <label>User Name</label>
                    <input type="text" 
                    className='input' 
                    id="username" 
                    name="username" 
                    value={username} 
                    onChange={inputHandler} 
                    placeholder='username'
                    required>

                    </input>
                </div>

                <div className='input_field'>
                    <label>Email</label>
                    
                        <input type="text" 
                               className='input' 
                               id="email" 
                               name="email" 
                               value={email} 
                               onChange={inputHandler} 
                               placeholder='example@nucleusteq.com'
                               required
                        >
                        </input>
                    
                    
                </div>

                <div className='input_field'>
                    <label>Initial Password</label>
                    <input type="password" 
                           className='input'
                           id="password" 
                           name="password" 
                           value={password} 
                           onChange={inputHandler} 
                           placeholder='password'
                           required
                           >

                    </input>
                </div>

                <div className='input_field'>
                    <label>User Type</label>
                    <div  name="role" id="role" className='custom_select' onChange={inputRoleHandler}>
                        <select>
                                    <option value="0">--select user type--</option>
                                    {
                                    roleDataBack.map((role)=>(
                                        <option key={role.roleId} value={role.name} >{role.name}</option>
                                    ))
                                    }
                        </select>
                    </div>
                </div>

                <div className='input_field'>
                    <label>Department</label>
                    <div name="department" id="department" className='custom_select' onChange={inputDeptHandler}>
                        <select>
                        <option value="0">--select Department--</option>
                                    {
                                    deptDataBack.map((dept)=>(
                                        <option key={dept.deptId} value={dept.deptName} >{dept.deptName}</option>
                                    ))
                                    }
                        </select>
                    </div>
                </div>

                <div className='input_field'>
                    {/* <input type="submit" value={"clear"} className='btnNew'></input> */}
                    <input type="submit" value={"save"} className='btnNew'></input>
                    {/* <input type="submit" value={"back"} className='btnNew'></input> */}
                </div>

            </form>
            
        </div>
        <br></br>

    </>
  )
}

export default NewUser