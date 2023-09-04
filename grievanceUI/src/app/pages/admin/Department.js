import React, { useEffect, useState } from 'react'
import '../../../assets/css/table.css'
import api from '../../../assets/axios';
function Department() {

    const [deptData, setDeptData] = useState([]);
    const getAllDepartment = async () => {
        try {
            const res = await api.get('api/department/all');
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
            <main className="table">
                <section className="table__header">
                    <h1>Departments</h1>
                    <button className='add_department'></button>
                </section>
                <section className="table__body">
                    <table>
                        <thead>
                            <tr>
                                <th className="">id</th>
                                <th className="">Depatment Name</th>
                                <th className="">Action</th>

                            </tr>
                        </thead>
                        <tbody>
                            
                            {
                                deptData.map((dept) => {
                                    return <>
                                        <tr key={dept.deptId}>
                                            <td>{dept.deptId}</td>
                                            <td>{dept.deptName}</td>
                                            <td>
                                                <div>
                                                    <button  className='button_edit'></button>
                                                    <button  className='button_delete'></button>
                                                </div>
                                            </td>
                                        </tr>
                                    </>
                                })
                            }

                        </tbody>
                    </table>
                </section>
            </main>
        </>
    )
}

export default Department