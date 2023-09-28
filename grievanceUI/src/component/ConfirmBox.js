import React from 'react'
import '../assets/css/confirmBox.css'
import Button from './Button'


function ConfirmBox(props) {
  return (
    <>
        <div className='coverBackPopUp'></div>
        <div className="popup-box">
        <i>
          <svg xmlns="http://www.w3.org/2000/svg" width="50" height="50" fill="currentColor" className="bi bi-exclamation" viewBox="0 0 16 16">
            <path d="M7.002 11a1 1 0 1 1 2 0 1 1 0 0 1-2 0zM7.1 4.995a.905.905 0 1 1 1.8 0l-.35 3.507a.553.553 0 0 1-1.1 0L7.1 4.995z"/>
          </svg>
        </i>
        <h1>
          {props.head}
        </h1>
        <label>
            Are you sure to proceed?
        </label>
        <div className="btns">
            <Button className="btn1" onClick={props.onClickCancel} value={'Cancel'} name={'Cancel'}></Button>
            <Button className="btn2" onClick={props.onClickDelete} value={'Delete'} name={'Delete'}></Button>
        </div>
        </div>
    </>
  )
}

export default ConfirmBox