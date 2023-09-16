import React from 'react'
import { useState } from 'react';
import api from '../assets/axios';
import { useEffect } from 'react';

function DepartmentDropdown(props) {

    const [deptData, setDeptData] = useState([]);
    const getAllDepartment = async () => {
        try {
            const url = '/department/all';
            const res = await api.get(url);
            if (res.data) {
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

    return (
        <>
            <div
                
                id='department'
                name='department'
                // onChange={inputDepartment}
                onChange={props.onChange}
                >
                <select className={props.className} >
                    <option value="0">All</option>
                    {
                        deptData.map((dept) => (
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