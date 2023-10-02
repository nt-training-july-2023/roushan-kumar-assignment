import React from 'react'
import { Outlet } from 'react-router-dom'
import Sidebar from '../../component/Sidebar'
import Header from '../../component/Header'

function Member() {
  if(sessionStorage.getItem('userType') !== 'Member' )
  {
       window.location.href = "http://localhost:3000/page-not-found";
  }
  return (
    <div>
        <div >
            <Header/>
            <Sidebar >
                <Outlet>
                    
                </Outlet>
            </Sidebar>
      
       </div>
    </div>
  )
}

export default Member