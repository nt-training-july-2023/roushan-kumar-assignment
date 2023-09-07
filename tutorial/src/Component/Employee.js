import React, { useEffect, useState } from 'react'
import axios  from '../Axios';
export default function Employee() {


    const [employeeData,setEmployeeData] = useState([]);

    const getEmployee= async ()=>
    {
        console.log("getting Employee data");
        const res = await axios.get('/api/employee/getAll')
        console.log(res.data);
        setEmployeeData(res.data);
    }

    useEffect(()=>{
        getEmployee();
    },[])

  return (
    <div>
        {
            Array.isArray(employeeData)
            ? employeeData.map((emp,key)=>{
                
                return (
                    <>
                        <ul key={key} >
                            <li key={emp.id}>

                                {emp.name}
                            </li>
                        </ul>
                        
                    </>
                )
            }):null
        }
    </div>
  )
}
