import React, { useState, useEffect } from 'react';
import '../../assets/css/forms.css';
import ErrorMessage from '../../component/ErrorMessage';
import NewTicketValid from '../../validations/NewTicketValid';
import { allTicketType } from '../../service/ticketType';
import OkMessage from '../../component/OkMessage';
import { allDepartment } from '../../service/departmentService';
import DepartmentDropdown from '../../component/DepartmentDropdown';
import { saveTicket } from '../../service/ticketService';
function NewTicket() {
    const UID = sessionStorage.getItem("userId");
    const initialVal = {

        "title": "",
        "description": "",
        "department": {
            "deptId": ""
        },
        "ticketType": {
            "ticketName": ""
        },
        "userId": UID
    }

    const [ticket, setTicket] = useState(initialVal);
    const { title, description, department, ticketType, userId } = ticket;

    const [deptData, setDeptData] = useState([]);
    const [ticketTypeData, setTicketTypeData] = useState([]);

    const [show, setShow] = useState("");
    const [notificationMessage, setNotificationMessage] = useState("");

    const [okBox, setOkBox] = useState(false);
    const [sucessMessage, setSucessMessage] = useState({
        "message":"",
        "title":"",
    })

    const getAllDepartment = async () => {
        try {
           
            const params = {
                params: {
                    offSet: 0,
                    pageSize: 0
                }
            }
            const res = await allDepartment(params)
            if (res.data) {
                setDeptData(res.data);
            }
            
        } catch (error) {
            console.log(error.response.data);
        }


    }
    useEffect(() => {
        getAllDepartment();
    }, [])

    const getAllTicketType = async () => {
        try {
            const res = await allTicketType()
            if (res.data) {
                setTicketTypeData(res.data);
            }
           
        } catch (error) {
            console.log(error.response.data);
        }
    }
    useEffect(() => {
        getAllTicketType();
    }, [])



    const inputHandler = (e) => {
        setTicket({
            ...ticket,
            [e.target.name]: e.target.value,
        })
    }

    const inputDepartment = (e) => {
        setTicket(
            {
                ...ticket,
                department: {
                    ...department, deptId: e.target.value
                }
            }
        )
    }

    const inputTicketType = (e) => {
        setTicket(
            {
                ...ticket,
                ticketType: {
                    ...ticketType, ticketName: e.target.value
                }
            }
        )
    }

    const clearNewTicketForm = () => {
        setTicket(initialVal);
        document.getElementById("description").value = null;
        document.getElementById("titleInput").value=null;

        const $selectDept = document.querySelector('#department');
        $selectDept.querySelectorAll('option')[0].selected = '--Select Department--'

        const $selectTicketType = document.querySelector('#ticketType');
        $selectTicketType.querySelectorAll('option')[0].selected = '--Select Ticket Type--'

    }

    const newTicketHandler = async (e) => {
        e.preventDefault();
        var val = NewTicketValid(ticket);
        if(val)
        {
            setNotificationMessage(val)
            setShow("show")
            return ;
        }
        console.log("result val"+val)
        console.log("before hit api" + ticket);
        try {
            
            const result = await saveTicket(ticket);
            if (result.data.id != null) {
                setSucessMessage({
                    "message":"New Ticket Created",
                    "title":"Created",
                })
                setOkBox(true)
                clearNewTicketForm();
               
            }
        }
        catch (error) {
            console.log(error.response.data)
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
            <ErrorMessage message={notificationMessage} show={show} onClick={handleClose} />
            {okBox && <OkMessage onClick={closeOkBoxHandler} message={sucessMessage} />}
            <div className='wrapper'>
                <div className='title'>
                    Add New Ticket
                </div>
                <div className='form'>


                    <div className='input_field'>
                        <label>Ticket Type <span className='error'>*</span></label>

                        <div
                            className='custom_select'
                            id='ticketType'
                            name='ticketType'
                            onChange={inputTicketType}
                             >
                            <select>
                                <option value="0">--Select Ticket Type--</option>
                                {
                                    ticketTypeData.map((tickType) => (
                                        <option key={tickType.ticketTypeId}
                                            value={tickType.ticketName}
                                        >{tickType.ticketName}
                                        </option>
                                    ))
                                }
                            </select>
                        </div>
                    </div>

                    <div className='input_field'>
                        <label>Title  <span className='error'>*</span></label>
                        <input
                            type="text"
                            className='input'
                            id='titleInput'
                            name='title'
                            onChange={inputHandler}
                            placeholder='Title of ticket'></input>
                    </div>

                    <div className='input_field'>
                        <label>Description  <span className='error'>*</span></label>
                        <textarea
                            type="text"
                            className='input'
                            id='description'
                            name='description'
                            onChange={inputHandler}
                            placeholder='Description of ticket...'>

                        </textarea>
                    </div>

                    <div className='input_field'>
                        <label>Assign To  <span className='error'>*</span></label>
                        
                        <DepartmentDropdown
                         id='department'
                         name='department'
                         className='custom_select'
                         onChange={inputDepartment}
                         defaultName={"--Select Department--"}/>
                        
                    </div>

                    <div className='input_field'>
                        <label>Status</label>
                        <div className='custom_select' >
                            <select disabled="true">
                            
                                <option value={"1"}>OPEN</option>
                            </select>
                        </div>
                    </div>



                    <div className='input_field'>
                        <input
                            type="submit"
                            value={"Clear"}
                            className='btnNew btnClear'
                            onClick={clearNewTicketForm} >

                        </input>
                        <input
                            type="submit"
                            value={"Save"}
                            className='btnNew btnSave'
                            onClick={newTicketHandler}>

                        </input>
                        {/* <input
                            type="submit"
                            value={"back"}
                            className='btnNew btnBack' >

                        </input> */}
                    </div>

                </div>
            </div>
            <br></br>
        </>
    )
}

export default NewTicket