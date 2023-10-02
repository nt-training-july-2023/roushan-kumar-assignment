import React, { useEffect, useState } from 'react'
import '../../assets/css/table.css'
import AddDepartment from '../../component/AddDepartment';
import ConfirmBox from '../../component/ConfirmBox';
import OkMessage from '../../component/OkMessage';
import { allDepartment, deleteDepartment } from '../../service/departmentService';
import ErrorMessage from '../../component/ErrorMessage';
import Table from '../../component/Table';
function Department() {

    const [deptData, setDeptData] = useState([]);
    const [departmentId, setDepartmentId] = useState();
    const [showDept, setShowDept] = useState(false);
    const [confirmShow, setConfirmShow] = useState(false);
    const [errorMessage, setErrorMessage] = useState("");
    const [show, setShow] = useState("");
    const [okBox, setOkBox] = useState(false);
    const [offset, setOffset] = useState(0)
    const pageSize = 10;
    const [sucessMessage, setSucessMessage] = useState({
        "message": "",
        "title": "",
    })

    const columns = [
        "S.No",
        "Depatment Name",
        "Action"
    ]

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
        freeDeparment();
    }

    const openDeptHandler = () => {
        setShowDept(true);
        document.getElementById('dep').style.cursor = 'no-drop';
        let buttons = document.getElementsByClassName('btn')
        for (var i = 0, len = buttons.length; i < len; i++) {
            buttons[i].style["pointer-events"] = 'none';
        }
    }

    const deptDeleteHandle = (departmentId) => {
        setDepartmentId(departmentId);
        setConfirmShow(true);

    }

    const confirmCancel = () => {
        setConfirmShow(false);
    }

    const confirmDelete = async () => {
        setConfirmShow(false);


        try {



            const res = await deleteDepartment(
                departmentId,
                sessionStorage.getItem("password"),
                sessionStorage.getItem("username"),
            );
            if (res.data === "Department deleted successfully.") {
                setSucessMessage({
                    "message": "Department deleted",
                    "title": "Deleted",
                })
                setOkBox(true)
                if (deptData.length == 1) {
                    setOffsetHadlerPrev();
                }
                getAllDepartment();

            }
        } catch (error) {
            alert(error.message)
        }





    }
    const closeOkBoxHandler = () => {
        setOkBox(false)
    }

    const handleClose = () => {
        setShow("");
    }


    const setOffsetHadlerPrev = () => {

        if (offset > 0) {
            setOffset(offset - 10)
        }
    }
    const setOffsetHadlerNext = async () => {
        const nPage = deptData.length
        if (nPage === pageSize) {
            
            setOffset(offset + 10)

        }

    }

    const freeDeparment = () => {
        document.getElementById('dep').style.cursor = 'default';
        let buttons = document.getElementsByClassName('btn')

        for (var i = 0, len = buttons.length; i < len; i++) {
            buttons[i].style["pointer-events"] = 'auto';
        }
    }

    const closeDepartment = (sucessMessage) => {
        setSucessMessage(sucessMessage)
        setOkBox(true)
        setShowDept(false);
        freeDeparment();
    }

    return (
        <>
            {showDept && <AddDepartment onClick={closeDeptHandler} closeDepartment={closeDepartment} />}
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

                    <Table columns={columns} data={
                        deptData.map((department) => (
                            {
                                "S.No": department.serialNumber,
                                "Depatment Name": department.deptName,
                                "Action": <div>
                                    {
                                    /* <button id="buttonEdit" className='btn button_edit' ></button> */}
                                    <button
                                        id="buttonDet"
                                        className='btn button_delete'
                                        hidden={department.deptId == sessionStorage.getItem("departmentId")}
                                        onClick={() => { deptDeleteHandle(department.deptId) }}
                                    >
                                    </button>
                                </div>,
                            }
                        ))
                    }></Table>
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