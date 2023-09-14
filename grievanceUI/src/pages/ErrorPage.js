import React from 'react'
import '../assets/css/error.css'
import { useNavigate } from 'react-router-dom';
function ErrorPage() {

    const navigate = useNavigate();
    const handleButtonClick = () => {
        // Use history.push to redirect to a specific route
        navigate(-1); // Replace '/destination' with your desired route or URL
    };
  return (
    <>
        <div className='parant_div'>
            <div className='error_page'>
            </div>
            <div className='error_box'>
                <div className='error_no'>
                    <label>404</label>
                </div>
                <div className='error_head'>
                    <label >Error, Page Not Found</label>
                </div>
                <div className='error_paragragh'>
                    <label >opps! the page you are looking for might have been removed or its temporarily unavailable.</label>
                </div>
                <div className='button_area'>
                    <button className='back_button' onClick={handleButtonClick} >GO TO BACK</button>
                </div>
            </div>
        </div>
        
    </>
  )
}

export default ErrorPage