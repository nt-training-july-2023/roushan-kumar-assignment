import React, { Children } from 'react'
import '../sidebar.css'
import { SidebarData } from './SidebarData'
import Home from '../page/Home'
import { NavLink } from 'react-router-dom'

function Sidebar({ children }) {
    return (
        <>
            <div className='container'>


                <div className='sidebar'>
                    <ul className='sidebarList'>
                        {
                            SidebarData.map((val, key) => {
                                return (
                                    // <li key={key}
                                    //     id={window.location.pathname == val.link ? "active" : ""}
                                    //     onClick={() => { window.location.pathname = val.link }}
                                    //     className='rows'
                                    // >

                                    //     <div id="icon">{val.icon}</div>
                                    //     <div id="title">{val.title}</div>
                                    // </li>
                                    <li key={key} >

                                    
                                    <NavLink  to={val.link}
                                        
                                        className='rows'
                                        
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
                <main>{children}</main>
            </div>
        </>
    )
}

export default Sidebar