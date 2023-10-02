import React from 'react'
import { useEffect } from 'react';
import { useState } from 'react';
import { allUsersService, deleteUser } from '../../service/userService';
import OkMessage from '../../component/OkMessage';
import ConfirmBox from '../../component/ConfirmBox';
import Table from '../../component/Table';

function Users() {

    const [allUsers, setAllUsers] = useState([])
    const [userId, setuserId] = useState(0)
    const [offSet, setOffSet] = useState(0)
    const [pageSize, setPageSize] = useState(10)

    const [confirmShow, setConfirmShow] = useState(false);
    const [okBox, setOkBox] = useState(false);
    const [sucessMessage, setSucessMessage] = useState({
        "message": "",
        "title": "",
    })

    const columns = [
        "S.No",
        "Username",
        "Full Name",
        "Email",
        "Role",
        "Department",
        "Action"
    ]

    const getAllUsers = async () => {
        try {
            const params = {
                params: {
                    offSet: offSet,
                    pageSize: pageSize
                }
            }
            const res = await allUsersService(params);
            if (res.data.content.length > 0) {
                setAllUsers(res.data.content);
            }
           
            
        } catch (error) {

        }
    }

    useEffect(() => {
        getAllUsers();
    }, [offSet])

    const setOffsetHadlerPrev = () => {

        if (offSet > 0) {
            setOffSet(offSet - 1)
        }
    }
    const setOffsetHadlerNext = async () => {
        const nPage = allUsers.length
        if (nPage === pageSize) {
            setOffSet(offSet + 1)
        }
    }

    const DeleteHandle = (userIdToDelete) => {

        setuserId(userIdToDelete);
        setConfirmShow(true);

    }

    const confirmCancel = () => {
        setConfirmShow(false);
    }

    const confirmDelete = async () => {
        setConfirmShow(false);

        try {
            if (allUsers.length == 1) {
                setOffsetHadlerPrev();
            }

            const res = await deleteUser(
                userId,
                sessionStorage.getItem("password"),
                sessionStorage.getItem("username"),
            );
            if (res.data.id) {
                setSucessMessage({
                    "message": "User deleted",
                    "title": "Deleted",
                })
                setOkBox(true);

                getAllUsers();

            }
        } catch (error) {
            alert(error.message)
        }

    }
    const closeOkBoxHandler = () => {
        setOkBox(false)
    }

    return (
        <>
            {okBox && <OkMessage
                message={sucessMessage}
                onClick={closeOkBoxHandler} />
            }
            {confirmShow && <ConfirmBox
                onClickCancel={confirmCancel}
                onClickDelete={confirmDelete}
                head={"Delete user"}
            />}
            <main className="table">
                <section className="table__header">
                    <h1>All Users</h1>

                </section>
                <section className="table__body">
                    
                    <Table columns={columns} data={
                        allUsers.map((user) => (
                            {
                                "S.No":user.serialNumber,
                                "Username":user.username,
                                "Full Name":user.fullName,
                                "Email":user.email,
                                "Role":user.role.name,
                                "Department":user.department.deptName,
                                "Action":
                                <div>
                                <button id="buttonEdit" className='btn button_edit' hidden={true}  ></button>
                                <button
                                    id="buttonDet"
                                    className='btn button_delete'
                                    hidden={user.username === sessionStorage.getItem("username")}
                                    onClick={() => { DeleteHandle(user.userId) }} ></button>
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

export default Users