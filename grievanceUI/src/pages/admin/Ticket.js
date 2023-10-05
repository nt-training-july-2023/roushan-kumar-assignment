import React, { useCallback, useEffect, useState } from 'react'
import api from '../../service/axios';
import TicketUpdateView from '../TicketUpdateView';
import DepartmentDropdown from '../../component/DepartmentDropdown';
import { allTicketStatus } from '../../service/ticketStatusType';
import Button from '../../component/Button';
import Table from '../../component/Table';
import { tickets } from '../../service/ticketService';

function Ticket() {
    const UID = sessionStorage.getItem("userId");
    const [allTickets, setAllTickets] = useState([]);
    const [ticket, setTicket] = useState([]);
    const [showTicketUpdate, SetShowTicketUpdate] = useState(false)
    const [createdByMe, setCreatedByMe] = useState(false);
    const [departmentId, SetDepartmentId] = useState(0);
    const [statusName, setStatusName] = useState("0");
    const [offset, setOffset] = useState(0)
    const [pageNumber,setPageNumber] = useState(1);
    const pageSize = 10;
    const columns = [
        "S.No",
        "Ticket title",
        "Department",
        "Status",
        "Assigned by",
        "Last Updated Time",
        "Action",
    ]
    const getAllTickets = useCallback(async () => {
        try {
            const params = {
                params: {
                    departId: departmentId,
                    createdByMe: createdByMe,
                    offset:offset,
                    pageSize:10,
                    status:statusName
                }
            }
            const res = await tickets(params,UID)
            if (res.data) {
                setAllTickets(res.data)
            }
            else {
                console.log("No data found")
                setAllTickets([])
            }
        } catch (error) {
            console.log(error.response);
        }
    },[offset, departmentId, statusName, createdByMe,UID])

    const [ticketStatus, setTicketStatus] = useState([]);
    const getAllTicketStatus = useCallback(async () => {
        try {
            const res = await allTicketStatus();
            if (res.data) {
                setTicketStatus(res.data);
            }
        } catch (error) {
            console.log(error.response.data);
        }
    },[]);


    useEffect(() => {
        getAllTickets();
    }, [getAllTickets,showTicketUpdate]);

    useEffect(() => {
        getAllTicketStatus();
        getAllTickets();

    }, [getAllTickets,getAllTicketStatus])

    const viewUpdateTicketPage = (ticket) => {
        setTicket(ticket);
        SetShowTicketUpdate(true)
    }
    const closeTicketUpdateView = () => {
        SetShowTicketUpdate(false)

    }

    const filterByStatus = (e) => {
        setStatusName(e.target.value);
        setOffset(0);
    }

    const setOffsetHadlerPrev = () => {

        if (offset > 0) {
            setOffset(offset - 10)
            setPageNumber(pageNumber-1)
            
        }
    }
    const setOffsetHadlerNext = async () => {
        const nPage = allTickets.length
        if (nPage === pageSize) {
            setOffset(offset + 10)
            setPageNumber(pageNumber+1)
        }
    }

    const setDepartmentIdHandler = (e) => {
        SetDepartmentId(e.target.value)
        setOffset(0);

    }

    const ticketByUser = () => {
        setOffset(0);
        setCreatedByMe(!createdByMe);
        setPageNumber(1)
    }

    return (
        <>
            {showTicketUpdate && <TicketUpdateView onClick={closeTicketUpdateView} ticketData={ticket} />}
            <main id="dep" className="table">
                <section className="table__header">
                    <h1>Tickets</h1>
                    <div className='head-ticket-search'>
                        <input type="checkbox" value={false} name="me" onClick={ticketByUser}></input><label >My Tickets</label>
                        {sessionStorage.getItem("userType") === "Admin" &&
                            <DepartmentDropdown
                                className={'custom_select_ticket'}
                                onChange={setDepartmentIdHandler}
                                defaultName={"All Departments"}
                                hidden={createdByMe}
                                disabled={createdByMe}
                            />

                        }
                        <div className='custom_select_ticket' >
                            <select id='statusId' onChange={filterByStatus}>
                                <option key={0} value="0">All Status</option>
                                {
                                    ticketStatus.map((status) => (
                                        <option key={status.ticketStatusId}
                                            value={status.ticketStatusName}

                                        >{status.ticketStatusName}
                                        </option>
                                    ))
                                }
                            </select>
                        </div>

                    </div>

                </section>
                <section className="table__body">
                    <Table columns={columns} data={
                        allTickets.map((ticket) => (
                            {
                                "S.No": ticket.serialNumber,
                                "Ticket title": ticket.title,
                                "Department": ticket.department.deptName,
                                "Status": <span className={ticket.ticketStatus.ticketStatusName === "OPEN" ? 'open' :
                                         ticket.ticketStatus.ticketStatusName === "BEING ADDRESSED" ? 'inProgress' :
                                        'closeTicket'
                                        }>{ticket.ticketStatus.ticketStatusName} </span>,
                                "Assigned by": ticket.fullName,
                                "Last Updated Time": ticket.date + " " + ticket.time,
                                "Action":
                                    <div>

                                        <Button id="buttonEdit" className='btn button_edit' onClick={() => { viewUpdateTicketPage(ticket) }} ></Button>

                                    </div>,
                            }
                        ))
                    }
                    >
                    </Table>

                    <div className='tablefooter'>
                        <ul>
                            <li>
                                <Button className='prev' hidden = {offset === 0 } onClick={setOffsetHadlerPrev} name={'Prev'}></Button>
                            </li>
                            {pageNumber}
                            <li>
                                <Button className='next' hidden = {allTickets.length < 10 } onClick={setOffsetHadlerNext} name={'Next'}></Button>
                            </li>

                        </ul>

                    </div>
                </section>
            </main>
        </>
    )
}

export default Ticket