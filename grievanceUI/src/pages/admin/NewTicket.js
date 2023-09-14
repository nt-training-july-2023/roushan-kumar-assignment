import React, { useState, useEffect } from 'react';
import '../../assets/css/forms.css';
import api from '../../assets/axios';
import ErrorMessage from '../../component/ErrorMessage';
import NewTicketValid from '../validations/NewTicketValid';
function NewTicket() {
    const UID = sessionStorage.getItem("userId");
    const initialVal = {

        "title": "",
        "description": "",
        "department": {
            "deptName": ""
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
        getAllDepartment();
    }, [])

    const getAllTicketType = async () => {
        try {
            const res = await api.get('api/ticketType/all');
            if (res.data) {
                setTicketTypeData(res.data);
            }
            console.log(res.data);
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
                    ...department, deptName: e.target.value
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
        $selectDept.querySelectorAll('option')[0].selected = '--select Department--'

        const $selectTicketType = document.querySelector('#ticketType');
        $selectTicketType.querySelectorAll('option')[0].selected = '--select Ticket Type--'

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
            const result = await api.post("/api/ticket/save", ticket);
            if (result.data.id != null) {
                setNotificationMessage("New Ticket created.")
                setShow("show")
                clearNewTicketForm();
                console.log("New Ticket created.")
            }
        }
        catch (error) {
            console.log(error.response.data)
        }

    }

    const handleClose = () => {
        setShow("");
    }

    return (
        <>
            <ErrorMessage message={notificationMessage} show={show} onClick={handleClose} />
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
                                <option value="0">--select Ticket Type--</option>
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
                        <div
                            className='custom_select'
                            id='department'
                            name='department'
                            onChange={inputDepartment}>
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
                        <label>Status</label>
                        <div className='custom_select' >
                            <select disabled="true">
                                <option value={"0"}>select</option>
                                <option value={"1"}>open</option>
                                <option value={"2"}>in progress</option>
                                <option value={"3"}>complete</option>
                            </select>
                        </div>
                    </div>



                    <div className='input_field'>
                        <input
                            type="submit"
                            value={"clear"}
                            className='btnNew' >

                        </input>
                        <input
                            type="submit"
                            value={"save"}
                            className='btnNew'
                            onClick={newTicketHandler}>

                        </input>
                        <input
                            type="submit"
                            value={"back"}
                            className='btnNew' >

                        </input>
                    </div>

                </div>
            </div>
            <br></br>
        </>
    )
}

export default NewTicket