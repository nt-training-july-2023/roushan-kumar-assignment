import React, { useEffect, useState } from 'react'
import '../../assets/css/table.css'
import AddDepartment from '../../component/AddDepartment';
import ConfirmBox from '../../component/ConfirmBox';
import OkMessage from '../../component/OkMessage';
import { allDepartment } from '../../service/departmentService';
import ErrorMessage from '../../component/ErrorMessage';
function Department() {

    const [deptData, setDeptData] = useState([]);
    const [showDept, setShowDept] = useState(false);
    const [confirmShow, setConfirmShow] = useState(false);
    const [errorMessage, setErrorMessage] = useState("");
    const [show, setShow] = useState("");
    const [okBox, setOkBox] = useState(false);
    const [offset, setOffset] = useState(0)
    const pageSize = 10;
    const [sucessMessage, setSucessMessage] = useState({
        "message":"",
        "title":"",
    })

   
    const getAllDepartment = async () => {
        try {
            const params = {
                params: {
                    offSet: offset,
                    pageSize: pageSize
                }
            }
            const res = await allDepartment(params);
            if (res.data) {
                setDeptData(res.data);
            }
            
        } catch (error) {
            setErrorMessage(error.response.data)
            setShow("show")
        }
    }
    useEffect(() => {
        getAllDepartment();
    }, [showDept, offset])

    const closeDeptHandler = () => {
        setShowDept(false);
        document.getElementById('dep').style.cursor = 'default';
        let buttons = document.getElementsByClassName('btn')

        for (var i = 0, len = buttons.length; i < len; i++) {
            buttons[i].style["pointer-events"] = 'auto';
        }
    }

    const openDeptHandler = () => {
        setShowDept(true);
        document.getElementById('dep').style.cursor = 'no-drop';
        let buttons = document.getElementsByClassName('btn')
        for (var i = 0, len = buttons.length; i < len; i++) {
            buttons[i].style["pointer-events"] = 'none';
        }
    }

    const deptDeleteHandle = () => {
        console.log("clicked");
        setConfirmShow(true);

    }

    const confirmCancel = () => {
        setConfirmShow(false);
    }

    const confirmDelete = () => {
        setConfirmShow(false);
        setSucessMessage({
            "message":"Department deleted",
            "title":"Deleted",
        })
        setOkBox(true)
    }
    const closeOkBoxHandler = () => {
        setOkBox(false)
    }

    const handleClose = () => {
        setShow("");
    }


    const setOffsetHadlerPrev = ()=>{
   
        if(offset>0){
        setOffset(offset-10)
        }
      }
      const setOffsetHadlerNext = async ()=>{
        const nPage = deptData.length
        if(nPage === pageSize){
         setOffset(offset+10)
       
        }
      }

      const closeDepartment = (sucessMessage)=>{
        setSucessMessage(sucessMessage)
        setOkBox(true)
        setShowDept(false);
      }

    return (
        <>
            {showDept && <AddDepartment onClick={closeDeptHandler} closeDepartment={closeDepartment}/>}
            {okBox && <OkMessage message={sucessMessage} onClick={closeOkBoxHandler} />}
            {confirmShow && <ConfirmBox
                onClickCancel={confirmCancel}
                onClickDelete={confirmDelete}
                head={"Delete department"}
            />}
            <ErrorMessage message={errorMessage} show={show} onClick={handleClose} />
            <main id="dep" className="table">
                <section className="table__header">
                    <h1>Departments</h1>
                    <button className='add_department' onClick={openDeptHandler}>
                        <span className="tooltiptext">click here to add department</span>
                    </button>

                </section>
                <section className="table__body">
                    <table>
                        <thead>
                            <tr>
                                <th className="">S.No</th>
                                <th className="">Depatment Name</th>
                                <th className="">Action</th>

                            </tr>
                        </thead>
                        <tbody>

                            {
                                deptData.map((dept, id) => {
                                    return <>
                                        <tr key={id}>
                                            <td>{dept.serialNumber}</td>
                                            <td>{dept.deptName}</td>
                                            <td>
                                                <div>
                                                    {/* <button id="buttonEdit" className='btn button_edit' ></button> */}
                                                    <button 
                                                    id="buttonDet" 
                                                    className='btn button_delete' 
                                                    hidden = {dept.deptId == sessionStorage.getItem("departmentId")}
                                                    onClick={deptDeleteHandle}
                                                    >
           
                                                    </button>
                                                </div>
                                            </td>
                                        </tr>
                                    </>
                                })
                            }

                        </tbody>
                    </table>
                    <div className='tablefooter'>
                        <ul>
                            <li>
                                <button className='prev' onClick={setOffsetHadlerPrev}>Prev</button>
                            </li>
                
                            <li>
                                <button className='next' onClick={setOffsetHadlerNext}>Next</button>
                            </li>

                        </ul>

                    </div>
                </section>
            </main>
        </>
    )
}

export default Department