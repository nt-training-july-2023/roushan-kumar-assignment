import React, { useEffect, useState } from 'react'
import '../../assets/css/forms.css'
import ErrorMessage from '../../component/ErrorMessage';
import NewUserValid from '../../validations/NewUserValid';
import OkMessage from '../../component/OkMessage';
import { saveUser } from '../../service/userService';
import { allDepartment } from '../../service/departmentService';
import { allUsersType } from '../../service/userType';
import Input from '../../component/Input';
function NewUser() {

    const roleData = {
        "name": ""
    }
    const departmentData = {
        "deptName": ""
    }
    const newUser = {
        "username": "",
        "fullName": "",
        "email": "",
        "password": "",
        "role": roleData,
        "department": departmentData
    }

    const [user, setUser] = useState(newUser);
    const { username, fullName, email, password, role, department } = user;
    const [show, setShow] = useState("");
    const [errorMessage, setErrorMessage] = useState("");
    const [roleAllData, setRoleData] = useState([]);
    const [deptData, setDeptData] = useState([]);
    const [okBox, setOkBox] = useState(false);
    const [sucessMessage, setSucessMessage] = useState({
        "message":"",
        "title":"",
    })

    const getAllRole = async () => {
        try {
            const res = await allUsersType();
            if (res.data) {
                setRoleData(res.data);
            }
        } catch (error) {
            console.log(error.response.data);
        }
    }
    const getAllDepartment = async () => {
        try {
            const params = {
                params: {
                    offSet: 0,
                    pageSize: 0
                }
            }
            const res = await allDepartment(params);
            if (res.data) {
                setDeptData(res.data);
            }
        } catch (error) {
            console.log(error.response.data);
        }
    }
    useEffect(() => {
        getAllRole();
    }, [])
    useEffect(() => {
        getAllDepartment();
    }, [])

    const inputHandler = (e) => {
        setUser({
            ...user,
            [e.target.name]: e.target.value
        })

    }

    const inputRoleHandler = (e) => {
        setUser({
            ...user,
            role: {
                ...role,
                name: e.target.value,
            },
        });
    }

    const inputDeptHandler = (e) => {
        setUser({
            ...user,
            department: {
                ...department,
                deptName: e.target.value,
            },
        });
    }
   
    const resetForm = () => {
        setUser(newUser);
        document.getElementById("fullname").value = null;
        document.getElementById("username").value=null;
        document.getElementById("email").value=null;
        document.getElementById("password").value=null;

        const $selectDept = document.querySelector('#department');
        $selectDept.querySelectorAll('option')[0].selected = '--Select Department--'

        const $selectUserType = document.querySelector('#role');
        $selectUserType.querySelectorAll('option')[0].selected = '--Select User Type--'
    }

    const newUserHandler = async (e) => {
        e.preventDefault();
        var val = NewUserValid(user)
        if (val) {
            setErrorMessage(val)
            setShow("show")
            return;
        }
        try {
            const result = await saveUser(
                {
                    "username": user.username,
                    "fullName": user.fullName,
                    "email": user.email,
                    "password": btoa(user.password),
                    "role": user.role,
                    "department": user.department
                },
                sessionStorage.getItem("password"),
                sessionStorage.getItem("username"),

                );
            if(result.data){
            setSucessMessage({
                "message":"New User Added",
                "title":"Saved",
            })
            setShow("");
            setOkBox(true)
            resetForm();
          }
        } catch (error) {
            setErrorMessage(error.response.data)
            setShow("show")
        }

    }
    const handleClose = () => {
        setShow("");
    }

    const closeOkBoxHandler = () => {
        setOkBox(false)
    }


    return (
        <>
            <ErrorMessage message={errorMessage} show={show} onClick={handleClose} />
            {okBox && <OkMessage onClick={closeOkBoxHandler} message={sucessMessage} />}
            <div className='wrapper '>
                
                <div className='title'>
                    Add New User
                </div>
                <form className='form' onSubmit={newUserHandler} >
                    <div className='input_field'>
                        <label>Name  <span className='error'>*</span></label>
                        <Input type="text"
                            className='input'
                            id="fullname"
                            name="fullName"
                            value={fullName}
                            onChange={inputHandler}
                            placeholder='Full name'
                            required>

                        </Input>
                    </div>

                    <div className='input_field'>
                        <label>User Name  <span className='error'>*</span></label>
                        <Input type="text"
                            className='input'
                            id="username"
                            name="username"
                            value={username}
                            onChange={inputHandler}
                            placeholder='Username'
                            required>

                        </Input>
                    </div>

                    <div className='input_field  '>
                        <label>Email  <span className='error'>*</span></label>

                        <Input type="text"
                            className='input'
                            id="email"
                            name="email"
                            value={email}
                            onChange={inputHandler}
                            placeholder='firstname.lastname.@nucleusteq.com'
                            required
                        >
                        </Input>

                        


                    </div>

                    <div className='input_field'>
                        <label>Initial Password  <span className='error'>*</span></label>
                        <Input type="password"
                            className='input'
                            id="password"
                            name="password"
                            value={password}
                            onChange={inputHandler}
                            placeholder='Password'
                            required
                        >

                        </Input>
                    </div>

                    <div className='input_field'>
                        <label>User Type  <span className='error'>*</span></label>
                        <div name="role" id="role" className='custom_select' onChange={inputRoleHandler}>
                            <select>
                                <option value="0">--Select User Type--</option>
                                {
                                    roleAllData.map((role) => (
                                        <option key={role.roleId}
                                            value={role.name}
                                        >{role.name}
                                        </option>
                                    ))
                                }
                            </select>
                        </div>
                    </div>

                    <div className='input_field'>
                        <label>Department  <span className='error'>*</span></label>
                        <div name="department" id="department" className='custom_select' onChange={inputDeptHandler}>
                            <select>
                                <option value="0">--Select Department--</option>
                                {
                                    deptData.map((dept) => (
                                        <option key={dept.deptId}
                                            value={dept.deptName}
                                        >{dept.deptName}
                                        </option>
                                    ))
                                }
                            </select>
                        </div>
                    </div>

                    <div className='input_field'>
                        {/* <Input type="submit" value={"clear"} className='btnNew'></Input> */}
                        <Input type="submit" value={"Save"} className='btnNew btnSave'></Input>
                        {/* <Input type="submit" value={"back"} className='btnNew'></Input> */}
                    </div>

                </form>

            </div>
            <br></br>

        </>
    )
}

export default NewUser