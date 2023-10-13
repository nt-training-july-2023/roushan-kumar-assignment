import React from 'react'
import '../assets/css/notification.css';
function SuccessMessage(props) {
    return (
        <>
            <div id="sucessMsg" className={'sucessNotification '+props.show} style={{backgroundColor:'rgb(230 243 217)'}}>
                <p style={{color:"green"}}>
                {props.message}
                </p>
                <div className='close' onClick={props.onClick} style={{backgroundColor:'#4CAf50'}}>
                    
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" className="bi bi-x-lg" viewBox="0 0 16 16">
                        <path d="M2.146 2.854a.5.5 0 1 1 .708-.708L8 7.293l5.146-5.147a.5.5 0 0 1 .708.708L8.707 8l5.147 5.146a.5.5 0 0 1-.708.708L8 8.707l-5.146 5.147a.5.5 0 0 1-.708-.708L7.293 8 2.146 2.854Z" />
                    </svg>
                   
                </div>
            </div>

        </>
    )
}

export default SuccessMessage