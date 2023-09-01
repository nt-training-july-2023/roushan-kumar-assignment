import React, { useState } from 'react'
import '../../../assets/css/forms.css'
function NewTicket() {
   
    

    return (
        <>
            <div className='wrapper'>
                <div className='title'>
                    Add New Ticket
                </div>
                <div className='form'>
                    

                    <div className='input_field'>
                        <label>Ticket Type</label>
                        <div className='custom_select'>
                            <select>
                                <option value={"0"}>select</option>
                                <option value={"1"}>Grievance</option>
                                <option value={"2"}>Feedback</option>
                            </select>
                        </div>
                    </div>

                    <div className='input_field'>
                        <label>Title</label>
                        <input type="text" className='input' required={true}></input>
                    </div>

                    <div className='input_field'>
                        <label>Description</label>
                        <textarea type="text" className='input'></textarea>
                    </div>

                    <div className='input_field'>
                        <label>Assign To</label>
                        <div className='custom_select'>
                            <select disabled="true">
                                <option value={"0"}>select</option>
                                <option value={"1"}>Backend developer</option>
                                <option value={"2"}>Frontend developer</option>
                            </select>
                        </div>
                    </div>

                    <div className='input_field'>
                        <label>Status</label>
                        <div className='custom_select'>
                            <select disabled="true">
                                <option value={"0"}>select</option>
                                <option value={"1"}>open</option>
                                <option value={"2"}>in progress</option>
                                <option value={"3"}>complete</option>
                            </select>
                        </div>
                    </div>

                    

                    <div className='input_field'>
                        <input type="submit" value={"clear"} className='btnNew'></input>
                        <input type="submit" value={"save"} className='btnNew' ></input>
                        <input type="submit" value={"back"} className='btnNew' ></input>
                    </div>

                </div>
            </div>
            <br></br>
        </>
    )
}

export default NewTicket