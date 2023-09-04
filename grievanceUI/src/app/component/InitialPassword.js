import React from 'react'
import '../../assets/css/initialpass.css'
function InitialPassword() {

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
                    <label>Password</label>
                    <input type="text" 
                           className='input' 
                           id="password" 
                           name="password" 
                           
                           placeholder='Password'
                           >
                           
                    </input>
                </div>
                <div className='input_field'>
                    <label>Confirm Password</label>
                    <input type="text" 
                           className='input' 
                           id="conPassword" 
                           name="conPassword" 
                           
                           placeholder='Confirm password'
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

export default InitialPassword