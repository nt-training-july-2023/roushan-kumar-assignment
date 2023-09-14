import React from 'react'
import ckeckCircle from '../../assets/svg/check-lg.svg'
import '../../assets/css/okmessage.css'
function OkMessage(props) {
  return (
    <div>
        <div className='ok-message'>
            <img src={ckeckCircle} />
            <h2>deleted</h2>
            <p>Department deleted succesfuly</p>
            <button type="button" onClick={props.onClick}>OK</button>
        </div>
    </div>
  )
}

export default OkMessage