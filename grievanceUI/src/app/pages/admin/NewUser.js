import React, { useEffect, useState } from 'react'
import '../../../assets/css/forms.css'
import { Link } from 'react-router-dom';
import api from '../../../assets/axios';
import MessageSucess from '../../component/MessageSucess';
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
            const res = await api.get('api/role/all');
            if (res.data) {
                setRoleData(res.data);
            }
            console.log(res.data);
        } catch (error) {
            console.log(error.response.data);
        }


    }
    const getAllDepartment = async () => {
        try {
            const res = await api.get('api/department/all');
            if (res.data) {
                setDeptData(res.data);
            }
            console.log(res.data);
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
        console.log("role inputRoleHandler : ", role);
        setUser({
            ...user,
            role: {
                ...role,
                name: e.target.value,
            },
        });
    }

    const inputDeptHandler = (e) => {
        console.log("department inputDeptHandler : ", department);
        setUser({
            ...user,
            department: {
                ...department,
                deptName: e.target.value,
            },
        });
    }
   
    

    const newUserHandler = async (e) => {
        e.preventDefault();

        var val = NewUserValid(user)

        if (val) {
            console.log("val " + val)
            setErrorMessage(val)
            setShow("show")
            return;
        }

        try {
            console.log("role : ", role);
            const result = await api.post('/api/user/save', user);
            setErrorMessage("New User Added")
            setShow("show")
            console.log(result.data);
        } catch (error) {
            console.log(error.response.data)
            setErrorMessage(error.response.data)
            setShow("show")
        }

        //alert("true");
    }
    const handleClose = () => {
        setShow("");
    }
    return (
        <>
            <MessageSucess message={errorMessage} show={show} onClick={handleClose} />
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
                            // style={{ paddingRight: "8rem", width: "94%" }}
                            id="email"
                            name="email"
                            value={email}
                            onChange={inputHandler}
                            placeholder='example'
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