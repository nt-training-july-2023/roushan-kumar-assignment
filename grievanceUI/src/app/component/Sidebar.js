import React from 'react'
import '../../assets/css/sidebar.css'
import { SidebarData } from '../data/SidebarData'
import { NavLink } from 'react-router-dom'

function Sidebar({ children }) {
    return (
        <>
            <div className='container_sidebar'>


                <div className='sidebar'>
                    <ul className='sidebarList'>
                        {
                            SidebarData.map((val, key) => {
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
                </div>
                <main className='main_container'>{children}</main>
            </div>
        </>
    )
}

export default Sidebar