import React from 'react'
import { useNavigate } from 'react-router-dom';

function SessionExpire() {

    const navigate = useNavigate();
    const handleButtonClick = ()=>{
        navigate("/")
    }
  return (
    <div>
        <div className='parant_div'>
            <div className='error_page'>
            </div>
            <div className='error_box'>
                <div className='error_no'>
                    <label>401</label>
                </div>
                <div className='error_head'>
                    <label >Error, Session Expired</label>
                </div>
                <div className='error_paragragh'>
                    <label >opps! Please log in again to resume your journey.</label>
                </div>
                <div className='button_area'>
                    <button className='back_button' onClick={handleButtonClick} >GO TO LOGIN</button>
                </div>
            </div>
        </div>
    </div>
  )
}

export default SessionExpire