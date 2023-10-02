import React from 'react'
import { Outlet } from 'react-router-dom'
import Sidebar from '../../component/Sidebar'
import Header from '../../component/Header'

function Admin() {

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