import React from 'react'
import '../../component/header/header.css'
import user from '../../assets/svg/person-circle.svg'
import logout from '../../assets/svg/box-arrow-in-right.svg'
import edit from '../../assets/svg/pencil-square.svg'
import person from '../../assets/svg/person.svg'
import navlogo1 from '../../assets/img/navlogo1.png'
import { useNavigate } from 'react-router-dom'
function Header(props) {
    const navigate = useNavigate();
    function toggleMenu(){
        
       let subMenu = document.getElementById("subMenu")
       subMenu.classList.toggle("open-menu")
   }

   const logOut = ()=> {
    sessionStorage.clear();
       
    navigate("/")
   }

  return (
    <>
        <div className="navbar">
        <nav>
        <img src = {navlogo1} className="logo"/>
        <h1>Grievance Management System</h1>
        <ul>
            {/* <li ><a href="#">Home</a></li>
            <li><a href="#">Home</a></li>
            <li><a href="#">Home</a></li>
            <li><a href="#">Home</a></li> */}
        </ul>
        <img id="user-pid-id" src = {user} className="user-pic" onClick={toggleMenu} />
        <div className="sub-menu-wrap" id ="subMenu" onMouseLeave={toggleMenu}>
            <div className="sub-menu">
                <div className="user-info">
                    <img src={user}/>
                    <h2>{sessionStorage.getItem("username")}</h2>
                    
                </div>
                <hr/>
               
                <a href="#" className="sub-menu-link">
                    <img src={edit}/>
                    <p>Change password</p>
                    <span>&gt;</span>
                </a>
                <a href="#" className="sub-menu-link" onClick={logOut}>
                    <img src={logout} />
                    <p>Log Out</p>
                    <span>&gt;</span>
                </a>
            </div>
        </div>
        </nav>
    </div>


    </>
  )
}

export default Header
