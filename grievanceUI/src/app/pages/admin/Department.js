import React, { useEffect, useState } from 'react'
import '../../../assets/css/table.css'
import api from '../../../assets/axios';
import AddDepartment from '../../component/AddDepartment';
import ConfirmBox from '../../component/ConfirmBox';
function Department() {

    const [deptData, setDeptData] = useState([]);
    const [showDept, setShowDept] = useState(false);
    const [confirmShow,setConfirmShow] = useState(false);
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

    const closeDeptHandler = () => {
        setShowDept(false);
        document.getElementById('dep').style.cursor = 'default';
        let buttons = document.getElementsByClassName('btn')

        for(var i=0, len=buttons.length; i<len; i++)
        {
            buttons[i].style["pointer-events"] = 'auto';
        }
    }

    const openDeptHandler = () => {
        setShowDept(true);
        document.getElementById('dep').style.cursor = 'no-drop';
        let buttons = document.getElementsByClassName('btn')
        for(var i=0, len=buttons.length; i<len; i++)
        {
            buttons[i].style["pointer-events"] = 'none';
        }
    }

    const deptDeleteHandle = ()=>{
        console.log("clicked");
        setConfirmShow(true);

    }

    const confirmCancel = ()=>{
        setConfirmShow(false);
    }

    const confirmDelete = ()=>{
        setConfirmShow(false);
    }



    return (
        <>
            {showDept && <AddDepartment onClick={closeDeptHandler} />}
            {confirmShow && <ConfirmBox onClickCancel={confirmCancel} onClickDelete = {confirmDelete}  />}
            <main id="dep" className="table">
                <section className="table__header">
                    <h1>Departments</h1>
                    <button className='add_department' onClick={openDeptHandler}>
                     <span class="tooltiptext">click here to add department</span>
                    </button>
                    
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
                                                    <button id="buttonEdit" className='btn button_edit' ></button>
                                                    <button id="buttonDet" className='btn button_delete' onClick={deptDeleteHandle}></button>
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