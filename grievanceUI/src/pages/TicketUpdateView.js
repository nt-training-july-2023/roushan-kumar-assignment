import React, { useEffect, useState } from 'react'
import api from '../assets/axios';
import '../assets/css/ticketUpdateView.css';
function TicketUpdateView(props) {
    console.log(props.ticketData)
    const UID = sessionStorage.getItem("userId");
    const [deptData, setDeptData] = useState([]);
    const [ticketTypeData, setTicketTypeData] = useState([]);
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


    useEffect(() => {
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
                    <div>
                        <div className='title'>
                            Ticket

                        </div>

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
                                value={props.ticketData.fullName}
                                disabled={true}
                            >
                            </input>
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