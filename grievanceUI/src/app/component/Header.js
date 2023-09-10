import React from 'react'
import '../../assets/css/header.css'
import user from '../../assets/svg/person-circle.svg'
import logout from '../../assets/svg/box-arrow-in-right.svg'
import edit from '../../assets/svg/pencil-square.svg'
import person from '../../assets/svg/person.svg'
import logo from '../../assets/svg/last-1.svg'
function Header(props) {
    function toggleMenu(){
        console.log("clicked user");
       let subMenu = document.getElementById("subMenu")
       subMenu.classList.toggle("open-menu")
   }
  return (
    <>
        <div className="navbar">
        <nav>
        <img src = {logo} className="logo"/>
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
                    <h2>Roushan Kumar</h2>

                </div>
                <hr/>
                <a href="#" className="sub-menu-link">
                    <img src={person}/>
                    <p>View profile</p>
                    <span>&gt;</span>
                </a>
                <a href="#" className="sub-menu-link">
                    <img src={edit}/>
                    <p>Edit Profile</p>
                    <span>&gt;</span>
                </a>
                <a href="#" className="sub-menu-link">
                    <img src={logout} />
                    <p>Log Out</p>
                    <span>&gt;</span>
                </a>
            </div>
        </div>
        </nav>
    </div>

    {/* <script>
        
        function toggleMenu(){
             subMenu = document.getElementById("subMenu")
            subMenu.classList.toggle("open-menu")
        }
    </script> */}
    </>
  )
}

export default Header
