import React from 'react'
import '../assets/css/sidebar.css'
import { SidebarData as adminSidebar } from '../data/SidebarData'
import { MSidebarData as  memberSidebar} from '../data/MSidebarData'
import { NavLink } from 'react-router-dom'

function Sidebar({ children }) {

    let SidebarData;
    if(sessionStorage.getItem('userType') === 'Admin' && sessionStorage.getItem("isFisrt") == 0)
    {
        SidebarData = adminSidebar;
       
    }
    else if(sessionStorage.getItem('userType') === 'Member' && sessionStorage.getItem("isFisrt") == 0)
    {
        SidebarData = memberSidebar;
    }
    else{
       window.location.href = "http://localhost:3000/session-expired";
    }

    return (
        <>
            <div className='container_sidebar'>


                <div className='sidebar'>
                    <ul className='sidebarList'>
                        {
                            SidebarData?.map((val, key) => {
                                return (
                                    <li key={key} >

                                    
                                    <NavLink  to={val.link}
                                        className='rows_links'
                                        >
                                         <div id="icon">{val.icon}</div>
                                         <div id="title">{val.title}</div>
                                    </NavLink>
                                    </li>
                                )
                            })
                        }
                       
                    </ul>
                    <ul>
                       
                    </ul>
                </div>
                <main className='main_container '>{children}</main>
            </div>
        </>
    )
}

export default Sidebar