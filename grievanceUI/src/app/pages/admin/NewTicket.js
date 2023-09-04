import React, { useState , useEffect } from 'react';
import '../../../assets/css/forms.css';
import api from '../../../assets/axios';
function NewTicket() {
   
    const initialVal = {
        
        "title":"",
        "description":"",
        "department":{
            "deptName":""
            },
        "ticketType":{
            "ticketName":""
        },
        "userId":""
    }

    const [ticket , setTicket] = useState(initialVal);
    const {title,description,department,ticketType,userId} = ticket;

    const [deptData,setDeptData] = useState([]);
    const [ticketTypeData,setTicketTypeData] = useState([]);

    const getAllDepartment = async ()=>{
        try {
            const res = await api.get('api/department/all');
            if(res.data)
            {
                setDeptData(res.data);
            }
           console.log(res.data);
        } catch (error) {
            console.log(error.response.data);
        }
        
       
    }
    useEffect(() => {
        getAllDepartment();
    }, [])

    const getAllTicketType = async ()=>{
        try {
            const res = await api.get('api/ticketType/all');
            if(res.data)
            {
                setTicketTypeData(res.data);
            }
           console.log(res.data);
        } catch (error) {
            console.log(error.response.data);
        }
    }
    useEffect(() => {
        getAllTicketType();
    }, [])
    
    const inputHandler = (e)=>{
        setTicket({
                   ...ticket,
                   [e.target.name]:e.target.value,
                })
    }

    const inputDepartment = (e)=>{
        setTicket(
            {
                ...ticket,
                department:{
                    ...department,deptName:e.target.value
                }
            }
        )
    }

    const inputTicketType = (e)=>{
        setTicket(
            {
                ...ticket,
                ticketType:{
                    ...ticketType,ticketName:e.target.value
                }
            }
        )
    }

    const newTicketHandler = (e)=>{
        e.preventDefault();
        console.log(ticket);
    }

    return (
        <>
            <div className='wrapper'>
                <div className='title'>
                    Add New Ticket
                </div>
                <div className='form'>
                    

                    <div className='input_field'>
                        <label>Ticket Type <span className='error'>*</span></label>
                        
                        <div className='custom_select' id='ticketType' name='ticketType' onChange={inputTicketType} >
                        <select>
                        <option value="0">--select Ticket Type--</option>
                        {
                        ticketTypeData.map((tickType)=>(
                            <option key={tickType.ticketTypeId} 
                                    value={tickType.ticketName} 
                                    >{tickType.ticketName}
                            </option>
                        ))
                        }
                        </select>
                        </div>
                    </div>

                    <div className='input_field'>
                        <label>Title  <span className='error'>*</span></label>
                        <input type="text" className='input' id='title' name='title' onChange={inputHandler} required={true}></input>
                    </div>

                    <div className='input_field'>
                        <label>Description  <span className='error'>*</span></label>
                        <textarea type="text"  className='input' id='description' name='description' onChange={inputHandler}></textarea>
                    </div>

                    <div className='input_field'>
                        <label>Assign To  <span className='error'>*</span></label>
                        <div className='custom_select' id='department' name='department' onChange={inputDepartment}>
                        <select>
                        <option value="0">--select Department--</option>
                        {
                        deptData.map((dept)=>(
                            <option key={dept.deptId} 
                                    value={dept.deptName} 
                                    >{dept.deptName}
                            </option>
                        ))
                        }
                        </select>
                        </div>
                    </div>

                    <div className='input_field'>
                        <label>Status</label>
                        <div className='custom_select' >
                            <select disabled="true">
                                <option value={"0"}>select</option>
                                <option value={"1"}>open</option>
                                <option value={"2"}>in progress</option>
                                <option value={"3"}>complete</option>
                            </select>
                        </div>
                    </div>

                    

                    <div className='input_field'>
                        <input type="submit" value={"clear"} className='btnNew' ></input>
                        <input type="submit" value={"save"} className='btnNew' onClick={newTicketHandler}></input>
                        <input type="submit" value={"back"} className='btnNew' ></input>
                    </div>

                </div>
            </div>
            <br></br>
        </>
    )
}

export default NewTicket