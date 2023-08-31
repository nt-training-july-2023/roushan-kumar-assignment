import React from 'react'
import '../../../assets/css/forms.css'
import { Link } from 'react-router-dom';
function NewUser() {
    const newUserHandler = (e)=>{
        e.preventDefault();
        alert("true");
    }
  return (
    <>
        <div className='wrapper'>
        <Link to="/admin" value="back">back</Link>
            <div className='title'>
                Add New User
            </div>
            <form className='form' onSubmit={newUserHandler} >
                <div className='input_field'>
                    <label>Name</label>
                    <input type="text" className='input' required></input>
                </div>

                <div className='input_field'>
                    <label>User Name</label>
                    <input type="text" className='input' required></input>
                </div>

                <div className='input_field'>
                    <label>Email</label>
                    <input type="text" className='input' required></input>
                </div>

                <div className='input_field'>
                    <label>Initial Password</label>
                    <input type="text" className='input' required></input>
                </div>

                <div className='input_field'>
                    <label>User Type</label>
                    <div className='custom_select'>
                        <select>
                            <option value={"0"}>select</option>
                            <option value={"1"}>Admin</option>
                            <option value={"2"}>Member</option>
                        </select>
                    </div>
                </div>

                <div className='input_field'>
                    <label>Department</label>
                    <div className='custom_select'>
                        <select>
                            <option value={"0"}>select</option>
                            <option value={"1"}>Backend developer</option>
                            <option value={"2"}>Frontend developer</option>
                        </select>
                    </div>
                </div>

                <div className='input_field'>
                    {/* <input type="submit" value={"clear"} className='btnNew'></input> */}
                    <input type="submit" value={"save"} className='btnNew'></input>
                    {/* <input type="submit" value={"back"} className='btnNew'></input> */}
                </div>

            </form>
            
        </div>
        <br></br>

    </>
  )
}

export default NewUser