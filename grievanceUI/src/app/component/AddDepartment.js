import React from 'react'
import '../../assets/addDepartmen.js'
import api from '../../assets/axios.js';
 function AddDepartment({onClick}) {
    const submitHandler = async (e)=>{
        e.preventDefault();

        try {
          const res = await api.post("/api/department/save/1",{
            "deptName": "SDE 2",
            "password": "passfdadf"
         },
         {
          headers: {password:"auth"},
         }
         )

        } catch (error) {
          console.log(error.response)
        }

      }
      const clearHandler = (e)=>{
        e.preventDefault();
      }   
  return (
    <div>
        
        <div id = "add_Department_Div" className='initial_pass wrapper_pass'>
        <div className='title'>
                    Add Department
        </div>
        <form className='form'  >
                <div className='input_field'>
                    <label>Department Name</label>
                    <input type="text" 
                           className='input' 
                           id="deptName" 
                           name="deptName" 
                           
                           placeholder='Department Name'
                           >
                           
                    </input>
                </div>
                
                <div className='input_field'>
                        <input type="submit" value={"close"} className='btnNew' onClick={onClick}></input>
                        <input type="submit" value={"save"} className='btnNew'  onClick={submitHandler}></input>
                        
                </div>
        </form>
        </div>
        <script src="../../assets/addDepartmen.js"></script>
    </div>
  )
}

export default AddDepartment