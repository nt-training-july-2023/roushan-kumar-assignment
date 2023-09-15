import React, { useEffect, useState } from 'react'
import api from '../assets/axios';
import '../assets/css/ticketUpdateView.css';
function TicketUpdateView(props) {
    console.log(props.ticketData)
    const UID = sessionStorage.getItem("userId");

    

    const [ticketStatus, setTicketStatus] = useState([]);
    const [show, setShow] = useState("");
    const [notificationMessage, setNotificationMessage] = useState("");

    const getAllTicketStatus = async () => {
        try {
            const res = await api.get('ticketStatus/all');
            if (res.data) {
                setTicketStatus(res.data);
            } 
        } catch (error) {
            console.log(error.response.data);
        }
    }

    const [filterChoice, setFilterChoice] = useState();
    setTimeout(() => {
        document.getElementById("statusId").value = props.ticketData.ticketStatus.ticketStatusId;
    }, 1);
    useEffect(() => {
        
        //document.getElementById("statusId").value = props.ticketData.ticketStatus.ticketStatusId;
        getAllTicketStatus();
        setFilterChoice(props.ticketData.ticketStatus.ticketStatusId)
       
    }, [])

    const inputHandler = (e) => {
       
    }

    const clearNewTicketForm = () => {

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
                
                    <div>
                        <div className='title'>
                            Ticket{props.ticketData.ticketStatus.ticketStatusId +"  "+ props.ticketData.ticketStatus.ticketStatusName }
                        </div>
                        <div className='label'><strong>Created Date :</strong> {props.ticketData.creationDate}</div>
                        <div className='label'><strong>Created time :</strong>{props.ticketData.creationTime}</div>
                        <div className='label'><strong>Assign By    :</strong> {props.ticketData.fullName}</div>
                        
                    </div>
                    <div className='form'>


                        <div className='input_field'>
                            <label>Ticket Type </label>

                            <input
                                type="text"
                                className='input'
                                id='ticketType'
                                name='ticketType'
                                value={props.ticketData.ticketType.ticketName}
                                disabled={true}
                            >
                            </input>

                        </div>

                        <div className='input_field'>
                            <label>Title </label>
                            <input
                                type="text"
                                className='input'
                                id='titleInput'
                                name='title'
                                value={props.ticketData.title}
                                disabled={true}
                            ></input>
                        </div>

                        <div className='input_field'>
                            <label>Description </label>
                            <textarea
                                type="text"
                                className='input'
                                id='description'
                                name='description'
                                value={props.ticketData.description}
                                disabled={true}
                            >

                            </textarea>
                        </div>

                        <div className='input_field'>
                            <label>Assign To </label>
                            <input
                                type="text"
                                className='input'
                                id='assignTo'
                                name='assignTo'
                                value={props.ticketData.department.deptName}
                                disabled={true}
                            >
                            </input>
                        </div>

                        <div className='input_field'>
                            <label>Status <span className='error'>*</span></label>
                            <div className='custom_select' >
                                <select id='statusId' defaultValue={filterChoice}>
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
                                id='comment'
                                name='comment'
                                
                                onChange={inputHandler}
                                placeholder='comment of ticket...'>
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
                       
                        {
                            props.ticketData.comments?.map((comments, id) => {

                                return <><p>{comments.comments}</p></>
                            })
                        }

                    </div>
                </div>
                {/* comments div end */}
            </div>
        </>
    )
}

export default TicketUpdateView