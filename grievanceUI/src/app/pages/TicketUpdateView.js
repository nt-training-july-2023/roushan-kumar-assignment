import React, { useEffect, useState } from 'react'
import api from '../../assets/axios';
import '../../assets/css/ticketUpdateView.css';
function TicketUpdateView(props) {
    console.log(props.ticketData)
    const UID = sessionStorage.getItem("userId");
    

    const [deptData, setDeptData] = useState([]);
    const [ticketTypeData, setTicketTypeData] = useState([]);
    const [ticketStatus, setTicketStatus] = useState([]);

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
    const getAllTicketStatus = async () => {
        try {
            const res = await api.get('ticketStatus/all');
            if (res.data) {
                setTicketStatus(res.data);
            }
            console.log(res.data);
        } catch (error) {
            console.log(error.response.data);
        }
    }
    useEffect(() => {
        getAllTicketType();
        getAllDepartment();
        getAllTicketStatus();
    }, [])


    const inputHandler = (e) => {
      
    }




    const clearNewTicketForm = () => {
       
        const $selectDept = document.querySelector('#department');
        $selectDept.querySelectorAll('option')[0].selected = '--select Department--'

        const $selectTicketType = document.querySelector('#ticketType');
        $selectTicketType.querySelectorAll('option')[0].selected = '--select Ticket Type--'

    }

    const updateTicketHandler = async (e) => {
        e.preventDefault();
        // var val = NewTicketValid(ticket);
        // if(val)
        // {
        //     setNotificationMessage(val)
        //     setShow("show")
        //     return ;
        // }
        // console.log("result val"+val)
        // console.log("before hit api" + ticket);
        try {
            const result = await api.post();
            
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
            <div className='ticket-update-view'>

                <div className='wrapper-TUV'>
                    <div className='title'>
                        Ticket
                    </div>
                    <div className='form'>


                        <div className='input_field'>
                            <label>Ticket Type </label>

                            <div
                                className='custom_select'
                                id='ticketType'
                                name='ticketType'
                                
                            >
                                <select disabled={true}>
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
                            <label>Title </label>
                            <input
                                type="text"
                                className='input'
                                id='titleInput'
                                name='title'
                                
                                disabled={true}
                                placeholder='Title of ticket'></input>
                        </div>

                        <div className='input_field'>
                            <label>Description </label>
                            <textarea
                                type="text"
                                className='input'
                                id='description'
                                name='description'
                               
                                disabled={true}
                                placeholder='Description of ticket...'>

                            </textarea>
                        </div>

                        <div className='input_field'>
                            <label>Assign To </label>
                            <div
                                className='custom_select'
                                id='department'
                                name='department'
                                >
                                <select disabled={true}>
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
                            <label>Status <span className='error'>*</span></label>
                            <div className='custom_select' >
                                <select >
                                    <option value="0">--Select Ticket Status--</option>
                                    {
                                        ticketStatus.map((status) => (
                                            <option key={status.ticketStatusId}
                                                value={status.ticketStatusId}
                                            >{status.ticketStatusName}
                                            </option>
                                        ))
                                    }
                                </select>
                            </div>
                        </div>
                        <div className='input_field'>
                            <label>Comment  <span className='error'>*</span></label>
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
                            <input
                                type="submit"
                                value={"clear"}
                                className='btnNew' >

                            </input>
                            <input
                                type="submit"
                                value={"update"}
                                className='btnNew'
                            // onClick={newTicketHandler}
                            >

                            </input>
                            <input
                                type="submit"
                                value={"back"}
                                className='btnNew' 
                                onClick={props.onClick}
                                >

                            </input>
                        </div>

                    </div>
                </div>
                {/* comments div start */}
                <div className='wrapper-TUV'>
                    <div className='title'>
                        Comments
                    </div>
                    <div className='comment-container'>
                        <p>
                            I'm sorry, but I need more specific information about the grievance you'd like a comment on. Grievances can vary widely, from workplace issues to personal concerns or complaints about various matters. Please provide more details or context, and I'll be happy to help you craft a comment or response accordingly.
                            I'm sorry, but I need more specific information about the grievance you'd like a comment on. Grievances can vary widely, from workplace issues to personal concerns or complaints about various matters. Please provide more details or context, and I'll be happy to help you craft a comment or response accordingly.
                        </p>
                        <p>
                            I'm sorry.
                        </p>
                        <p>
                            I'm sorry, but I need more specific information about the grievance you'd like a comment on. Grievances can vary widely, from workplace issues to personal concerns or complaints about various matters. Please provide more details or context, and I'll be happy to help you craft a comment or response accordingly.
                        </p>
                        <p>
                            I'm sorry, but I need more specific information about the grievance you'd like a comment on. Grievances can vary widely, from workplace issues to personal concerns or complaints about various matters. Please provide more details or context, and I'll be happy to help you craft a comment or response accordingly.
                        </p>
                        <p>
                            I'm sorry, but I need more specific information about the grievance you'd like a comment on. Grievances can vary widely, from workplace issues to personal concerns or complaints about various matters. Please provide more details or context, and I'll be happy to help you craft a comment or response accordingly.
                        </p>
                        <p>
                            I'm sorry, but I need more specific information about the grievance you'd like a comment on. Grievances can vary widely, from workplace issues to personal concerns or complaints about various matters. Please provide more details or context, and I'll be happy to help you craft a comment or response accordingly.
                        </p>
                        <p>
                            I'm sorry, but I need more specific information about the grievance you'd like a comment on. Grievances can vary widely, from workplace issues to personal concerns or complaints about various matters. Please provide more details or context, and I'll be happy to help you craft a comment or response accordingly.
                        </p>
                        <p>
                            I'm sorry, but I need more specific information about the grievance you'd like a comment on. Grievances can vary widely, from workplace issues to personal concerns or complaints about various matters. Please provide more details or context, and I'll be happy to help you craft a comment or response accordingly.
                        </p>
                        <p>
                            I'm sorry, but I need more specific information about the grievance you'd like a comment on. Grievances can vary widely, from workplace issues to personal concerns or complaints about various matters. Please provide more details or context, and I'll be happy to help you craft a comment or response accordingly.
                        </p>
                        <p>
                            I'm sorry, but I need more specific information about the grievance you'd like a comment on. Grievances can vary widely, from workplace issues to personal concerns or complaints about various matters. Please provide more details or context, and I'll be happy to help you craft a comment or response accordingly.
                        </p>
                        <p>
                            I'm sorry, but I need more specific information about the grievance you'd like a comment on. Grievances can vary widely, from workplace issues to personal concerns or complaints about various matters. Please provide more details or context, and I'll be happy to help you craft a comment or response accordingly.
                        </p>
                        <p>
                            I'm sorry, but I need more specific information about the grievance you'd like a comment on. Grievances can vary widely, from workplace issues to personal concerns or complaints about various matters. Please provide more details or context, and I'll be happy to help you craft a comment or response accordingly.
                        </p>
                        <p>
                            I'm sorry, but I need more specific information about the grievance you'd like a comment on. Grievances can vary widely, from workplace issues to personal concerns or complaints about various matters. Please provide more details or context, and I'll be happy to help you craft a comment or response accordingly.
                        </p>
                        
                        
                    </div>
                </div>
                {/* comments div end */}
            </div>
        </>
    )
}

export default TicketUpdateView