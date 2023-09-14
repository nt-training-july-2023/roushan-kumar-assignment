import React, { useEffect, useState } from 'react'
import api from '../../assets/axios';
import TicketUpdateView from '../TicketUpdateView';

function Ticket() {

  const [allTickets,setAllTickets] = useState([]);
  const [ticket,setTicket] = useState([]);
  const [showTicketUpdate,SetShowTicketUpdate] = useState(false)

  const getAllTickets = async ()=>{
    try {
        const url = "/ticket/all/10?departId=0&createdByMe=false";
        const res = await api.get(url)
        setAllTickets(res.data)
    } catch (error) {
        console.log(error.response);
    }
  }

  useEffect(()=>{
    getAllTickets();
  },[])

  const viewUpdateTicketPage = (ticket)=>{
    setTicket(ticket);
    SetShowTicketUpdate(true)
  }
  const closeTicketUpdateView = () =>{
    SetShowTicketUpdate(false)
  }
  return (
    <>
        { showTicketUpdate &&  <TicketUpdateView onClick={closeTicketUpdateView} ticketData={ticket}/>}
        <main id="dep" className="table">
                <section className="table__header">
                    <h1>Tickets</h1>
                    <div className='head-ticket-search'>
                        <div >
                            <select className='custom_select_ticket'>
                                <option value={"0"}>select</option>
                                <option value={"1"}>HR</option>
                                <option value={"2"}>SALES</option>
                            </select>
                        </div>
                        <div >
                            <select className='custom_select_ticket' >
                                <option value={"0"}>select</option>
                                <option value={"1"}>open</option>
                                <option value={"2"}>in progress</option>
                                <option value={"3"}>complete</option>
                            </select>
                        </div>
                        <div>
                        <button className='my-button'> Find</button>
                        </div>
                    </div>
                    
                </section>
                <section className="table__body">
                    <table>
                        <thead>
                            <tr>
                                <th className="">S.No</th>
                                <th className="">Ticket title</th>
                                <th className="">Department</th>
                                <th className="">Status</th>
                                <th className="">Assign By</th>
                                <th className="">Last Updated Time</th>
                                <th className="">Action</th>

                            </tr>
                        </thead>
                        <tbody>

                            {
                                allTickets?.map((ticket,id) => {
                                    return <>
                                        <tr key={ticket.ticketId}>
                                            <td>{id+1}</td>
                                            <td>{ticket.title}</td>
                                            <td>{ticket.department.deptName}</td>
                                            <td>{ticket.ticketStatus.ticketStatusName}</td>
                                            <td>{ticket.fullName}</td>
                                            <td>{ticket.date +" "+ticket.time}</td>
                                            <td>
                                                <div>
                                                    <button id="buttonEdit" className='btn button_edit' onClick={()=>{viewUpdateTicketPage(ticket)}} ></button>
                                                    <button id="buttonDet" className='btn button_delete' ></button>
                                                </div>
                                            </td>
                                        </tr>
                                    </>
                                })
                            }

                        </tbody>
                    </table>
                </section>
            </main>
    </>
  )
}

export default Ticket