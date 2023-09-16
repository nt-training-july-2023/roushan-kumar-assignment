import React from 'react'
import arrowIcon from '../assets/svg/caret-right-fill.svg'
import homeIcon from '../assets/svg/house-door-fill.svg'
export const SidebarData = [
  {
    title: "Home",
    link: "/home",
    icon: <img src={homeIcon}></img>
  },
  {
    title: "New User",
    link: "/admin/newuser",
    icon:  <img src={arrowIcon} ></img>
  },
  {
    title: "New Ticket",
    link: "/admin/newticket",
    icon: <img src={arrowIcon} ></img>
  },
  {
    title: "Ticket",
    link: "/admin/ticket",
    icon: <img src={arrowIcon} ></img>
  },
  {
    title: "Department",
    link: "/admin/department",
    icon: <img src={arrowIcon} ></img>
  },


]
