import React, { useEffect, useState } from 'react'
import api from '../../assets/axios';
import TicketUpdateView from '../TicketUpdateView';
import DepartmentDropdown from '../../component/DepartmentDropdown';

function Ticket() {
  const UID = sessionStorage.getItem("userId");
  const [allTickets,setAllTickets] = useState([]);
  const [ticket,setTicket] = useState([]);
  const [showTicketUpdate,SetShowTicketUpdate] = useState(false)
  const [createdByMe,setCreatedByMe] = useState(false);
  const [departmentId,SetDepartmentId] = useState(0);
  const [statusName,setStatusName] = useState("");

  let record;
  let allRecord = allTickets;
  const [alltic,setAlltic] = useState([]);

  const getAllTickets = async ()=>{
    try {
        const url = "/ticket/all/"+UID+"?departId="+departmentId+"&createdByMe="+createdByMe;
        const res = await api.get(url)
        if(res.data){
        setAllTickets(res.data)
        setAlltic(res.data);
        }
        else {
            console.log("No data found")
            setAllTickets([])
            setAlltic([]);
        }
    } catch (error) {
        console.log(error.response);
    }
  }

  const [ticketStatus, setTicketStatus] = useState([]);
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

 
  useEffect(()=>{
    getAllTicketStatus();
    getAllTickets();
    
  },[departmentId])

  const viewUpdateTicketPage = (ticket)=>{
    setTicket(ticket);
    SetShowTicketUpdate(true)
  }
  const closeTicketUpdateView = () =>{
    SetShowTicketUpdate(false)
  }


  //pagination
  const [currentPage,setCurrentPage] = useState(1);
  const recordPerPage = 5;
  const lastIndex = currentPage * recordPerPage;
  const firstIndex = lastIndex - recordPerPage;
  const recordOfTicket = alltic.slice(firstIndex,lastIndex);
  
  const nPage = Math.ceil(alltic.length / recordPerPage)
  const numbers = [...Array(nPage+1).keys()].slice(1);
  //end

  //filter on status
  
 
  const filterByStatus = (e) =>{

      if(e.target.value === "0")
      {
        setAlltic(allTickets)
        return;
      }
      setCurrentPage(1);
        e.preventDefault();
        // console.log(allRecord)
        // setStatusName(e.target.value)
        //getAllTickets();
        
        record = allRecord.filter(checkStatus);
        console.log(record);
        
        function checkStatus(allRecord)
        {
            return allRecord.ticketStatus.ticketStatusName == e.target.value
        }
        setAlltic(record)
        //setAllTickets(record);
  }


  const setDepartmentIdHandler = (e)=>{
    console.log(e.target.value);
    SetDepartmentId(e.target.value)
  }
  

  return (
    <>
        { showTicketUpdate &&  <TicketUpdateView onClick={closeTicketUpdateView} ticketData={ticket}/>}
        <main id="dep" className="table">
                <section className="table__header">
                    <h1>Tickets</h1>
                    <div className='head-ticket-search'>
                        { sessionStorage.getItem("userType") === "Admin" &&
                        <DepartmentDropdown className={'custom_select_ticket'} onChange={setDepartmentIdHandler}/>
                        }
                        <div >
                            <select id='statusId' className='custom_select_ticket' onChange={filterByStatus}>
                                    <option value="0">All</option>
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
                                recordOfTicket?.map((ticket,id) => {
                                    return <>
                                        <tr key={ticket.ticketId}>
                                            <td>{id+1+firstIndex}</td>
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
                    <nav>
                        <ul>
                            <li>
                                <a href='#' onClick={prevPage}>Prev</a>
                            </li>
                            {
                                numbers.map((n,i)=>(
                                    <li key={i}>
                                          <a href='#' onClick={()=>{changeCurrentPage(n)}}>{n}</a>  
                                    </li>
                                ))
                            }
                            <li>
                                <a href='#' onClick={nextPage}>Next</a>
                            </li>

                        </ul>

                    </nav>
                </section>
            </main>
    </>
  )

  function prevPage(){
    if(currentPage !== 1 )
     setCurrentPage(currentPage-1);
}

function changeCurrentPage(n){
    setCurrentPage(n)
}

function nextPage(){
    if(currentPage !== nPage)
     setCurrentPage(currentPage+1)
}
}

export default Ticket