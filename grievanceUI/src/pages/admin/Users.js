import React from 'react'
import { useEffect } from 'react';
import { useState } from 'react';
import { allUsersService } from '../../service/userService';

function Users() {

  const [allUsers, setAllUsers] = useState([])
  const [offSet, setOffSet] = useState(0)
  const [pageSize, setPageSize] = useState(10)

  const getAllUsers = async () => {
    try {
        const params = {
            params: {
               offSet:offSet,
               pageSize:pageSize
              }
        }
        const res = await allUsersService(params);
        if(res.data.content.length>0)
        {
            setAllUsers(res.data.content);
        }
    } catch (error) {
        
    }
  }

  useEffect(() => {
    getAllUsers();
  }, [offSet])
  
  const setOffsetHadlerPrev = ()=>{
   
    if(offSet>0){
    setOffSet(offSet-1)
    }
  }
  const setOffsetHadlerNext = async ()=>{
    const nPage = allUsers.length
    if(nPage === pageSize){
     setOffSet(offSet+1)
    }
  }

  return (
    <>
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
                                
                                
                                <th className="">Action</th>

                            </tr>
                        </thead>
                        <tbody>

                            { allUsers && allUsers.length > 0 ? (
                                allUsers?.map((user,id) => {
                                    return <>
                                        <tr key={user.userId}>
                                            <td>{id+1}</td>
                                            <td>{user.username}</td>
                                            <td>{user.fullName}</td>
                                            <td>{user.email}</td>
                                            <td>{user.role.name}</td>
                                            <td>
                                                <div>
                                                    <button id="buttonEdit" className='btn button_edit'  ></button>
                                                    <button id="buttonDet" className='btn button_delete' ></button>
                                                </div>
                                            </td>
                                        </tr>
                                    </>
                                })
                             ):
                             <tr>
                                <td colSpan="5">No data found...  </td>
                             </tr>
                            }

                        </tbody>
                    </table>
                    <tablefooter>
                        <ul>
                            <li>
                                <button className='prev' onClick={setOffsetHadlerPrev}>Prev</button>
                            </li>
                
                            <li>
                                <button className='next' onClick={setOffsetHadlerNext}>Next</button>
                            </li>

                        </ul>

                    </tablefooter>
                </section>
            </main>
    </>
  )
}

export default Users