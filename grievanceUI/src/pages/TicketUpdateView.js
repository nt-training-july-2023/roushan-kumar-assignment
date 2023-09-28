import React, { useEffect, useState } from 'react'
import api from '../service/axios';
import '../assets/css/ticketUpdateView.css';
import ErrorMessage from '../component/ErrorMessage';
import { allTicketStatus } from '../service/ticketStatusType';
import { useRef } from 'react';
import OkMessage from '../component/OkMessage';
function TicketUpdateView(props) {

    const initialVal = {
        "ticketId": 0,
        "title": "",
        "description": "",
        "department": {
            "deptId": 0,
            "deptName": ""
        },
        "ticketType": {
            "ticketTypeId": 0,
            "ticketName": ""
        },
        "ticketStatus": {
            "ticketStatusId": 0,
            "ticketStatusName": ""
        },
        "userId": 0,
        "fullName": "",
        "date": "",
        "time": "",
        "creationDate": "",
        "creationTime": "",
        "comments": []
    }

    const [ticketStatus, setTicketStatus] = useState([]);
    const [ticket, setTicket] = useState(initialVal);
    const [show, setShow] = useState("");
    const [notificationMessage, setNotificationMessage] = useState("");
    const elRef = useRef(null);
    const onlyValidUser = useRef(true);
    const [comment, setComment] = useState({
        "comments": "",
        "commentedBy": sessionStorage.getItem("username")
    });

    const [inableOnChange, setInableOnChange] = useState(false)

    const [okBox, setOkBox] = useState(false);
    const [sucessMessage, setSucessMessage] = useState({
        "message":"",
        "title":"",
    })

    const [statusId, setStatusId] = useState(props.ticketData.ticketStatus.ticketStatusId);
    const getTicket = async () => {
        try {
            const url = "ticket/" + props.ticketData.ticketId;
            const res = await api.get(url)
            console.log(res.data);
            if (res.data) {
                setTicket(res.data)
                console.log(res.data.department.deptId +" "+sessionStorage.getItem("departmentId"))
                
                if (res.data.userId == sessionStorage.getItem("userId")) {
                    onlyValidUser.current  = false
                   
                }
                else if (res.data.department.deptId == sessionStorage.getItem("departmentId")) {
                    onlyValidUser.current  = false
                   
                }
                else {
                    onlyValidUser.current  = true;
                }
            }
        } catch (error) {
            
        }


    }
    const executeScroll = () => elRef.current?.scrollIntoView({ behavior: 'smooth' });

    const getAllTicketStatus = async () => {
        try {
            const res = await allTicketStatus();

            if (res.data) {
                setTicketStatus(res.data);
            }
        } catch (error) {
            console.log(error.response.data);
        }
    }

    setTimeout(() => {
        executeScroll();
    }, 0);

    useEffect(() => {

        getTicket();
        getAllTicketStatus();


    }, [])

    const inputHandler = (e) => {
        setComment({ ...comment, comments: e.target.value })
    }

    const inputStatus = (e) => {
        setStatusId(e.target.value)
    }

    const clearNewTicketForm = () => {
        setComment({ ...comment, comments: "" })
    }

    const updateTicketHandler = async (e) => {
        e.preventDefault();

        if (comment.comments.trim() === "" && statusId == 3) {
            
            setNotificationMessage("Comment before update.")
            setShow("show")
            return;
        }
        try {
            const url = "ticket/updates/ticketcomments/" + ticket.ticketId + "?statusId=" + statusId;
            const result = await api.put(url, comment);
            if (result.data.id) {
                getTicket();
                clearNewTicketForm();
                if( (statusId == 1 || statusId == 2 ) && comment.comments === "")
                {
                    setSucessMessage({
                        "message":"Ticket status updated",
                        "title":"Updated",
                    })
                    setOkBox(true)
                } else {
                   executeScroll();
                }
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
            <div className='ticket-update-view'>

                <div className='wrapper-TUV'>

                    <div>
                        <div className='title'>
                            Ticket
                        </div>
                        <div className='label'><strong>Created Date :</strong> {ticket.creationDate}</div>
                        <div className='label'><strong>Created time :</strong> {ticket.creationTime}</div>
                        <div className='label'><strong>Assigned by  :</strong> {ticket.fullName}</div>
                        
                    </div>
                    <div className='form'>


                        <div className='input_field'>
                            <label>Ticket Type </label>

                            <input
                                type="text"
                                className='input'
                                id='ticketType'
                                name='ticketType'
                                value={ticket.ticketType.ticketName}
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
                                value={ticket.title}
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
                                value={ticket.description}
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
                                value={ticket.department.deptName}
                                disabled={true}
                            >
                            </input>
                        </div>

                        <div className='input_field'>
                            <label>Status <span className='error'>*</span></label>
                            <div className='custom_select' >
                                <select id='statusId' onChange={inputStatus} disabled = { onlyValidUser.current }>
                                   
                                    {
                                        ticketStatus.map((status) => (
                                            <option key={status.ticketStatusId}
                                                value={status.ticketStatusId}
                                                selected={status.ticketStatusId === statusId}
                                            >{status.ticketStatusName}
                                            </option>
                                        ))
                                    }
                                </select>
                            </div>
                        </div>
                        <div className='input_field'>
                            <label>Comment</label>
                            <textarea
                                type="text"
                                className='input'
                                id='comment'
                                name='comments'
                                value={comment.comments}
                                onChange={inputHandler}
                                disabled = { onlyValidUser.current }
                                placeholder='Comment of ticket...'>
                            </textarea>
                        </div>


                        <div className='input_field'>
                            <input
                                type="submit"
                                value={"Clear"}
                                className='btnNew btnClear' >

                            </input>
                            <input
                                type="submit"
                                value={"Update "}
                                className='btnNew btnSave'
                                disabled = {inableOnChange}
                                hidden={ onlyValidUser.current }
                                onClick={updateTicketHandler}
                            >

                            </input>
                            <input
                                type="submit"
                                value={"Back"}
                                className='btnNew btnBack'
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
                            ticket.comments?.map((comments, id) => {

                                return <>
                                    <div className="comments"><strong>{comments.commentedBy} </strong> 
                                       <br></br> 
                                       {comments.comments}
                                       <br>
                                       </br>
                                    <p className='timeAndDate'>  {comments.time}</p>
                                    </div>

                                </>
                            })

                        }
                        <div ref={elRef}></div>

                    </div>

                </div>
                {/* comments div end */}
            </div>
        </>
    )
}

export default TicketUpdateView