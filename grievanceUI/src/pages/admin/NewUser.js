import React, { useEffect, useState } from 'react'
import '../../assets/css/forms.css'
import { Link } from 'react-router-dom';
import api from '../../assets/axios';
import ErrorMessage from '../../component/ErrorMessage';
import NewUserValid from '../validations/NewUserValid';
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

    const getAllRole = async () => {
        try {
            const url = '/role/all';
            const res = await api.get(url);
            if (res.data) {
                setRoleData(res.data);
            }
        } catch (error) {
            console.log(error.response.data);
        }


    }
    const getAllDepartment = async () => {
        try {
            const url = '/department/all';
            const res = await api.get(url);
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
        $selectDept.querySelectorAll('option')[0].selected = '--select Department--'

        const $selectUserType = document.querySelector('#role');
        $selectUserType.querySelectorAll('option')[0].selected = '--select user type--'
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
            const url = '/user/save';
            const result = await api.post(url, user);
            setErrorMessage("New User Added")
            setShow("show")
            resetForm();
        } catch (error) {
            setErrorMessage(error.response.data)
            setShow("show")
        }

    }
    const handleClose = () => {
        setShow("");
    }
    return (
        <>
            <ErrorMessage message={errorMessage} show={show} onClick={handleClose} />
            <div className='wrapper '>
                <Link to="/admin" value="back">back</Link>
                <div className='title'>
                    Add New User
                </div>
                <form className='form' onSubmit={newUserHandler} >
                    <div className='input_field'>
                        <label>Name  <span className='error'>*</span></label>
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
                        <label>User Name  <span className='error'>*</span></label>
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

                    <div className='input_field  '>
                        <label>Email  <span className='error'>*</span></label>

                        <input type="text"
                            className='input'
                            id="email"
                            name="email"
                            value={email}
                            onChange={inputHandler}
                            placeholder='firstname.lastname.@nucleusteq.com'
                            required
                        >
                        </input>

                        {/* <span className='defaut_domain'>@nucleusteq.com</span> */}


                    </div>

                    <div className='input_field'>
                        <label>Initial Password  <span className='error'>*</span></label>
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
                        <label>User Type  <span className='error'>*</span></label>
                        <div name="role" id="role" className='custom_select' onChange={inputRoleHandler}>
                            <select>
                                <option value="0">--select user type--</option>
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
                                <option value="0">--select Department--</option>
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
                        {/* <input type="submit" value={"clear"} className='btnNew'></input> */}
                        <input type="submit" value={"save"} className='btnNew btnSave'></input>
                        {/* <input type="submit" value={"back"} className='btnNew'></input> */}
                    </div>

                </form>

            </div>
            <br></br>

        </>
    )
}

export default NewUser