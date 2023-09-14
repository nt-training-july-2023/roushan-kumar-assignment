import React, { useEffect, useState } from 'react'
import { Outlet, useNavigate } from 'react-router-dom'
import Sidebar from '../../component/Sidebar'
import Home from '../Home'
import ChangePassword from '../../component/ChangePassword'
import Header from '../../component/Header'

function Admin() {
  const navigate = useNavigate();
  const [initalPass,setInitalPass] = useState(false)
  const initalPAsswordHandler =  (e)=>{
    setInitalPass(true)
  }

  return (
    <div>
      <div >
      {initalPass && <ChangePassword onclick = {initalPAsswordHandler}/>}
      
      <Header/>
      <Sidebar >
          <Outlet/>
       </Sidebar>
      
       </div>
    </div>
  )
}

export default Admin