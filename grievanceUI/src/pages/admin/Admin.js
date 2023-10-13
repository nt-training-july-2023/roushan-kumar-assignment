import React from 'react'
import { Outlet } from 'react-router-dom'
import Sidebar from '../../component/Sidebar'
import Header from '../../component/Header'

function Admin() {
  if(sessionStorage.getItem('userType') !== 'Admin' )
  {
       window.location.href = "http://localhost:3000/page-not-found";
  }
  return (
    <div>
    
      <Header/>
      <Sidebar >
          <Outlet/>
       </Sidebar>
      

    </div>
  )
}

export default Admin