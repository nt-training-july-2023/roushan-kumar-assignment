import React from 'react'
import { Outlet } from 'react-router-dom'
import Sidebar from '../../component/Sidebar'

function Member() {
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

export default Member