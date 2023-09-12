import React, { useEffect, useState } from 'react'
import api from '../../../assets/axios';

function Ticket() {

  const [allTickets,setAllTickets] = useState([]);

  const getAllTickets = async ()=>{
    try {
        const res = await api.get("/api/ticket/all")
      //  console.log("tickets "+res);
        setAllTickets(res.data)
    } catch (error) {
        console.log(error.response);
    }
  }

  useEffect(()=>{
    getAllTickets();
  },[])

  return (
    <div>
        <main id="dep" className="table">
                <section className="table__header">
                    <h1>Tickets</h1>
                    
                    
                </section>
                <section className="table__body">
                    <table>
                        <thead>
                            <tr>
                                <th className="">S.No</th>
                                <th className="">Ticket title</th>
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
                                            <td>
                                                <div>
                                                    <button id="buttonEdit" className='btn button_edit' ></button>
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
    </div>
  )
}

export default Ticket