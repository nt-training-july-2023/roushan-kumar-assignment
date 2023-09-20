import React from 'react'
import { Outlet } from 'react-router-dom'
import Sidebar from '../../component/sidebar/Sidebar'
import Header from '../../component/header/Header'

function Member() {
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