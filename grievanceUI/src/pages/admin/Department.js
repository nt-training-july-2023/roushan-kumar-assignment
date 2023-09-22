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
    const [sucessMessage, setSucessMessage] = useState({
        "message":"",
        "title":"",
    })

    const [okBox, setOkBox] = useState(false);
    const getAllDepartment = async () => {
        try {
            const res = await allDepartment();
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
    }, [showDept])

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

    
    //pagination
    const [currentPage,setCurrentPage] = useState(1);
    const recordPerPage = 10;
    const lastIndex = currentPage * recordPerPage;
    const firstIndex = lastIndex - recordPerPage;
    const record = deptData.slice(firstIndex,lastIndex);
    const nPage = Math.ceil(deptData.length / recordPerPage)
    const numbers = [...Array(nPage+1).keys()].slice(1);
    //end
    const handleClose = () => {
        setShow("");
    }
    return (
        <>
            {showDept && <AddDepartment onClick={closeDeptHandler} />}
            {okBox && <OkMessage message={sucessMessage} onClick={closeOkBoxHandler} />}
            {confirmShow && <ConfirmBox
                onClickCancel={confirmCancel}
                onClickDelete={confirmDelete}
                head={"delete department"}
            />}
            <ErrorMessage message={errorMessage} show={show} onClick={handleClose} />
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
                                <th className="">S.No</th>
                                <th className="">Depatment Name</th>
                                <th className="">Action</th>

                            </tr>
                        </thead>
                        <tbody>

                            {
                                record.map((dept, id) => {
                                    return <>
                                        <tr key={dept.deptId}>
                                            <td>{id+firstIndex+1}</td>
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
                    <tablefooter>
                        <ul>
                            <li>
                                <a href='#' onClick={prevPage}>Prev</a>
                            </li>
                            {
                                numbers.map((n,i)=>(
                                    <li key={i}>
                                          <a href='#' onClick={()=>{changeCurrentPage(n)}}>{n}</a>  
                                    </li>
                                ))
                            }
                            <li>
                                <a href='#' onClick={nextPage}>Next</a>
                            </li>

                        </ul>

                    </tablefooter>
                </section>
            </main>
        </>
    )
    function prevPage(){
        if(currentPage !== 1 )
         setCurrentPage(currentPage-1);
    }

    function changeCurrentPage(n){
        setCurrentPage(n)
    }

    function nextPage(){
        if(currentPage !== nPage)
         setCurrentPage(currentPage+1)
    }
}

export default Department