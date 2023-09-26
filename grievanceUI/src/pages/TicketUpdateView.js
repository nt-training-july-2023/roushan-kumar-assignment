import React, { useEffect, useState } from 'react'
import api from '../service/axios';
import '../assets/css/ticketUpdateView.css';
import ErrorMessage from '../component/ErrorMessage';
import { allTicketStatus } from '../service/ticketStatusType';
import { useRef } from 'react';
function TicketUpdateView(props) {
    // console.log(props.ticketData)
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

    // const UID = sessionStorage.getItem("userId");
    const [ticketStatus, setTicketStatus] = useState([]);
    const [ticket, setTicket] = useState(initialVal);
    const [show, setShow] = useState("");
    const [notificationMessage, setNotificationMessage] = useState("");
    // const [onlyValidUser, setOnlyValidUser] = useState(true)
    const elRef = useRef(null);
    const onlyValidUser = useRef(true);
    const [comment, setComment] = useState({
        "comments": "",
        "commentedBy": sessionStorage.getItem("username")
    });
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
    const executeScroll = () => elRef.current?.scrollIntoView({ behavior: 'smooth' });//{ behavior: 'smooth' }

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

        if (comment.comments.trim() === "") {
            console.log()
            setNotificationMessage("Add comment before update.")
            setShow("show")
            return;
        }
        try {
            const url = "ticket/updates/ticketcomments/" + ticket.ticketId + "?statusId=" + statusId;
            const result = await api.put(url, comment);
            if (result.data.id) {
                getTicket();
                clearNewTicketForm();
                executeScroll();
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
                            <label>Comment  <span className='error'>*</span></label>
                            <textarea
                                type="text"
                                className='input'
                                id='comment'
                                name='comments'
                                value={comment.comments}
                                onChange={inputHandler}
                                disabled = { onlyValidUser.current }
                                placeholder='comment of ticket...'>
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
                                    <p><strong>{comments.commentedBy} </strong> : {comments.comments}</p>

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