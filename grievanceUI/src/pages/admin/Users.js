import React from 'react'
import { useEffect } from 'react';
import { useState } from 'react';
import { allUsersService, deleteUser } from '../../service/userService';
import OkMessage from '../../component/OkMessage';
import ConfirmBox from '../../component/ConfirmBox';

function Users() {

    const [allUsers, setAllUsers] = useState([])
    const [userId, setuserId] = useState(0)
    const [offSet, setOffSet] = useState(0)
    const [pageSize, setPageSize] = useState(10)

    const [confirmShow, setConfirmShow] = useState(false);
    const [okBox, setOkBox] = useState(false);
    const [sucessMessage, setSucessMessage] = useState({
        "message":"",
        "title":"",
    })

    const [userLogedIn, setUserLogedIn] = useState(false)

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
            const res = await deleteUser(
                userId,
                sessionStorage.getItem("password"),
                sessionStorage.getItem("username"),
                );
            if(res.data.id)
            {
                setSucessMessage({
                    "message":"User deleted",
                    "title":"Deleted",
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
                    <table>
                        <thead>
                            <tr>
                                <th className="">S.No</th>
                                <th className="">Username</th>
                                <th className="">Full Name</th>
                                <th className="">Email</th>
                                <th className="">Role</th>
                                <th className="">Department</th>


                                <th className="">Action</th>

                            </tr>
                        </thead>
                        <tbody>

                            {allUsers && allUsers.length > 0 ? (
                                allUsers?.map((user, id) => {
                                    return <>
                                        <tr key={id}>
                                            <td>{user.serialNumber}</td>
                                            <td>{user.username}</td>
                                            <td>{user.fullName}</td>
                                            <td>{user.email}</td>
                                            <td>{user.role.name}</td>
                                            <td>{user.department.deptName}</td>
                                            <td>
                                                <div>
                                                    <button id="buttonEdit" className='btn button_edit' hidden={true}  ></button>
                                                    <button 
                                                    id="buttonDet"
                                                    className='btn button_delete' 
                                                    hidden = {user.username === sessionStorage.getItem("username")}
                                                    onClick={()=>{DeleteHandle(user.userId)}} ></button>
                                                </div>
                                            </td>
                                        </tr>
                                    </>
                                })
                            ) :
                                <tr >
                                    <td colSpan="5">No data found...  </td>
                                </tr>
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

export default Users