import React from 'react'
import arrowIcon from '../assets/svg/caret-right-fill.svg'
import homeIcon from '../assets/svg/house-door-fill.svg'
import persionAdd from '../assets/svg/person-add.svg'
import peopleFill from '../assets/svg/people-fill.svg'
import departmentFill from '../assets/svg/department-3.svg'
import addTicket from '../assets/svg/ticket.svg'
import tickets from '../assets/svg/ticket-perforated-fill.svg'


export const SidebarData = [
 
  {
    title: "Add User",
    link: "/admin/newuser",
    icon:  <img src={persionAdd} ></img>
  },
  {
    title: "Users",
    link: "/admin/users",
    icon:  <img src={peopleFill} ></img>
  },
  {
    title: "Raise a Ticket",
    link: "/admin/newticket",
    icon: <img src={addTicket} ></img>
  },
  {
    title: "Tickets",
    link: "/admin/ticket",
    icon: <img src={tickets} ></img>
  },
  {
    title: "Departments",
    link: "/admin/department",
    icon: <img src={departmentFill} ></img>
  },


]
