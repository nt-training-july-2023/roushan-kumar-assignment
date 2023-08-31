import React from 'react'
import { Outlet } from 'react-router-dom'
import Sidebar from '../../component/Sidebar'
import Home from '../Home'

function Admin() {
  return (
    <div>
      <div >
      <Sidebar >
          <Outlet>
            
          </Outlet>
       </Sidebar>
      
       </div>
    </div>
  )
}

export default Admin