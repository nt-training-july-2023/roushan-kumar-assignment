import React, { useEffect, useState } from 'react'
import { Outlet, useNavigate } from 'react-router-dom'
import Sidebar from '../../component/sidebar/Sidebar'
import ChangePassword from '../../component/ChangePassword'
import Header from '../../component/header/Header'

function Admin() {
  const navigate = useNavigate();


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