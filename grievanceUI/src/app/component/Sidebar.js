import React from 'react'
import '../../assets/css/sidebar.css'
import { SidebarData as adminSidebar } from '../data/SidebarData'
import { MSidebarData as  memberSidebar} from '../data/MSidebarData'
import { NavLink, useNavigate } from 'react-router-dom'

function Sidebar({ children }) {

  const navigate = useNavigate();
//   const history = ();

//   if(sessionStorage.getItem("userId") === null || sessionStorage.getItem("userId") === "")
//   {
//     console.log("sidebar");
//     navigate("/");
//   }

    let SidebarData;
    if(sessionStorage.getItem('userType') === 'Admin')
    {
        SidebarData = adminSidebar;
    }
    else if(sessionStorage.getItem('userType') === 'Member')
    {
        SidebarData = memberSidebar;
    }
    else{
       // navigate("/");
       window.location.href = "http://localhost:3000/";
    }

    const logout = ()=>{
        sessionStorage.clear();
        navigate("/")
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
                        <li>
                        <button className='logout-button' onClick={logout}>Log out</button>
                        </li>
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