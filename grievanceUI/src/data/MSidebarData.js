import React from 'react'
import addTicket from '../assets/svg/ticket.svg'
import tickets from '../assets/svg/ticket-perforated-fill.svg'
export const MSidebarData = [
  {
    title: "Raise a Ticket",
    link: "/member/riseticket",
    icon: <img src={addTicket}></img>
  },
  {
    title: "Tickets",
    link: "/member/ticket",
    icon: <img src={tickets}></img>
  },



]
