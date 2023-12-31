import React, { useEffect, useState } from 'react'
import api from '../../service/axios';
import TicketUpdateView from '../TicketUpdateView';
import DepartmentDropdown from '../../component/DepartmentDropdown';
import { allTicketStatus } from '../../service/ticketStatusType';
import Button from '../../component/Button';

function Ticket() {
  const UID = sessionStorage.getItem("userId");
  const [allTickets,setAllTickets] = useState([]);
  const [ticket,setTicket] = useState([]);
  const [showTicketUpdate,SetShowTicketUpdate] = useState(false)
  const [createdByMe,setCreatedByMe] = useState(false);
  const [departmentId,SetDepartmentId] = useState(0);
  const [statusName,setStatusName] = useState("0");
  const [offset, setOffset] = useState(0)
  const pageSize = 10;
  const getAllTickets = async ()=>{
    try {

        const url = "/ticket/all/new/"+UID+"?departId="+departmentId+"&createdByMe="+createdByMe+"&offset="+offset+"&pageSize=10&status="+statusName;

        const res = await api.get(url)
        if(res.data){
        setAllTickets(res.data)
        }
        else {
            console.log("No data found")
            setAllTickets([])
        }
    } catch (error) {
        console.log(error.response);
    }
  }

  const [ticketStatus, setTicketStatus] = useState([]);
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

  useEffect(() => {
    getAllTickets();
  }, [offset,departmentId,statusName,createdByMe,showTicketUpdate]);
 
  useEffect(()=>{
    getAllTicketStatus();
    getAllTickets();
    
  },[])

  const viewUpdateTicketPage = (ticket)=>{
    setTicket(ticket);
    SetShowTicketUpdate(true)
  }
  const closeTicketUpdateView = () =>{
    SetShowTicketUpdate(false)

  }

  const filterByStatus = (e) =>{
    setStatusName(e.target.value);
    setOffset(0);
  }
  
  const setOffsetHadlerPrev = ()=>{
   
    if(offset>0){
    setOffset(offset-10)
    console.log("prev offset " +offset);
    }
  }
  const setOffsetHadlerNext = async ()=>{
    const nPage = allTickets.length
    if(nPage === pageSize){
     setOffset(offset+10)
    console.log("next offset "+offset);
    }
  }

  const setDepartmentIdHandler = (e)=>{
    SetDepartmentId(e.target.value)
    setOffset(0);
    
  }
  
  const ticketByUser = () =>{
    setOffset(0);
    setCreatedByMe(!createdByMe);
  }

  return (
    <>
        { showTicketUpdate &&  <TicketUpdateView onClick={closeTicketUpdateView} ticketData={ticket}/>}
        <main id="dep" className="table">
                <section className="table__header">
                    <h1>Tickets</h1>
                    <div className='head-ticket-search'>
                    <input type="checkbox" value={false} name="me" onClick={ticketByUser}></input><label >My Tickets</label>
                        { sessionStorage.getItem("userType") === "Admin" &&
                        <DepartmentDropdown
                         className={'custom_select_ticket'}
                         onChange={setDepartmentIdHandler}
                         defaultName={"All Departments"}
                         hidden= {createdByMe}
                         disabled = {createdByMe}
                         />
                        
                        }
                        <div className='custom_select_ticket' >
                            <select id='statusId'  onChange={filterByStatus}>
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
                    <table>
                        <thead>
                            <tr>
                                <th className="">S.No</th>
                                <th className="">Ticket title</th>
                                <th className="">Department</th>
                                <th className="">Status</th>
                                <th className="">Assigned by</th>
                                <th className="">Last Updated Time</th>
                                <th className="">Action</th>

                            </tr>
                        </thead>
                        <tbody>

                            { allTickets && allTickets.length > 0 ? (
                                allTickets?.map((ticket,id) => {
                                    return <>
                                        <tr key={ticket.ticketId} style={{height:"20px"}}>
                                            <td>{ticket.serialNumber}</td>
                                            <td>{ticket.title}</td>
                                            <td>{ticket.department.deptName}</td>
                                            <td 
                                            
                                                className={ ticket.ticketStatus.ticketStatusName === "OPEN" ? 'open' : 
                                                ticket.ticketStatus.ticketStatusName === "BEING ADDRESSED" ? 'inProgress' :
                                                'closeTicket'
                                            }

                                            >{ticket.ticketStatus.ticketStatusName}</td>
                                            <td>{ticket.fullName}</td>
                                            <td>{ticket.date +" "+ticket.time}</td>
                                            <td>
                                                <div>
                                                    {/* icon button */}
                                                    <Button id="buttonEdit" className='btn button_edit' onClick={()=>{viewUpdateTicketPage(ticket)}} ></Button>
                                                    {/* <button id="buttonDet" className='btn button_delete' ></button> */}
                                                </div>
                                            </td>
                                        </tr>
                                    </>
                                })
                             ):
                             <tr>
                                <td colSpan="7">No data found...  </td>
                             </tr>
                            }

                        </tbody>
                    </table>
                    <div className='tablefooter'>
                        <ul>
                            <li>
                                <button className='prev' onClick={setOffsetHadlerPrev}>Prev</button>
                            </li>
                
                            <li>
                                <button className='next' onClick={setOffsetHadlerNext}>Next</button>
                            </li>

                        </ul>

                    </div>
                </section>
            </main>
    </>
  )
}

export default Ticket