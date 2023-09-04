import React, { useState } from 'react'
import { Outlet } from 'react-router-dom'
import Sidebar from '../../component/Sidebar'
import Home from '../Home'
import InitialPassword from '../../component/InitialPassword'

function Admin() {

  const [initalPass,setInitalPass] = useState(false)

  const initalPAsswordHandler =  (e)=>{
    setInitalPass(true)
  }

  return (
    <div>
      <div >
      {initalPass && <InitialPassword onclick = {initalPAsswordHandler}/>}
      
        
      <Sidebar >
          <Outlet>
            
          </Outlet>
       </Sidebar>
      
       </div>
    </div>
  )
}

export default Admin