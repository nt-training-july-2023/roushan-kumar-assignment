import React from 'react'
import '../assets/css/initialpass.css'
function ChangePassword() {

  const submitHandler = (e)=>{
    e.preventDefault();
  }
  const clearHandler = (e)=>{
    e.preventDefault();
  }    
  
  return (
    <div>
        <div className='initial_pass wrapper_pass'>
        <div className='title'>
                    Change Password
        </div>
        <form className='form'  >
        <div className='input_field'>
                    <label>Old Password</label>
                    <input type="password" 
                           className='input' 
                           id="oldPassword" 
                           name="oldPassword" 
                           
                           placeholder='New Password'
                           >
                           
                    </input>
                </div>
                <div className='input_field'>
                    <label>New Password</label>
                    <input type="password" 
                           className='input' 
                           id="newPassword" 
                           name="newPassword" 
                           
                           placeholder='Old Password'
                           >
                           
                    </input>
                </div>
                <div className='input_field'>
                    <label>Confirm Password</label>
                    <input type="password" 
                           className='input' 
                           id="conPassword" 
                           name="conPassword"   
                           placeholder='Confirm Password'
                           >
                           
                    </input>
                </div>
                <div className='input_field'>
                        <input type="submit" value={"clear"} className='btnNew' onClick={clearHandler}></input>
                        <input type="submit" value={"save"} className='btnNew'  onClick={submitHandler}></input>
                        
                </div>
        </form>
        </div>
    </div>
  )
}

export default ChangePassword