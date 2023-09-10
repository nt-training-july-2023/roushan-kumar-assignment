import React, { useEffect, useState } from 'react'
import { Outlet, useNavigate } from 'react-router-dom'
import Sidebar from '../../component/Sidebar'
import Home from '../Home'
import InitialPassword from '../../component/InitialPassword'
import Header from '../../component/Header'

function Admin() {
  const navigate = useNavigate();

  // if(sessionStorage.getItem("userId")===null || sessionStorage.getItem("userId")==="")
  // {
  //   console.log("admin");
  //   navigate("/");
  // }

 

  const [initalPass,setInitalPass] = useState(false)

  const initalPAsswordHandler =  (e)=>{
    setInitalPass(true)
  }

  return (
    <div>
      <div >
      {initalPass && <InitialPassword onclick = {initalPAsswordHandler}/>}
      
      <Header/>
      <Sidebar >
          <Outlet>
            
          </Outlet>
       </Sidebar>
      
       </div>
    </div>
  )
}

export default Admin