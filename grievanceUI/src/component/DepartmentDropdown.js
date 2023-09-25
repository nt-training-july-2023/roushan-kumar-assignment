import React from 'react'
import { useState } from 'react';
import { useEffect } from 'react';
import { allDepartment } from '../service/departmentService';

function DepartmentDropdown(props) {

    const [deptData, setDeptData] = useState([]);
    const getAllDepartment = async () => {
        try {
            const params = {
                params: {
                    offSet: 0,
                    pageSize: 0
                }
            }
            
            const res = await allDepartment(params);
            if (res.data) {
                setDeptData(res.data);
            }
            
        } catch (error) {
            console.log(error.response.data);
        }

    }

    useEffect(() => {
        getAllDepartment();
    }, [])

    return (
        <>
            <div
                
                id='department'
                name='department'
                // onChange={inputDepartment}
                onChange={props.onChange}
                >
                <select className={props.className} >
                    <option key={0} value="0">All Departments</option>
                    {
                        deptData.map((dept,id) => (
                            <option key={dept.deptId}
                                value={dept.deptId}
                            >{dept.deptName}
                            </option>
                        ))
                    }
                </select>
            </div>
        </>
    )
}

export default DepartmentDropdown