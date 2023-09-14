import React from 'react'

function NewUserValid(user) {
 console.log("validation on user "+user.email);
 const userEmail = user.email.trim();
 const reg = new RegExp("^[a-zA-Z0-9]+\\.[a-zA-Z0-9]+@nucleusteq\\.com$");
 console.log(reg.test(userEmail));

  if (user.username.trim() === "") {
    return "username is required";
  }

  if (user.fullName.trim() === "") {
    return "fullName is required";
  }

  if(user.password.trim() === "")
    return "Password is required."

  if(user.email.trim() === "")
    return "email is required.";
  else if(!reg.test(userEmail)) 
  {
    return "Invalid Email Id."
  }

 if (user.role.name === "0" || user.role.name === "" )
    return "Select user type.";

  if (user.department.deptName === "0" || user.department.deptName === "" )
    return "Select department.";

  return false;
}

export default NewUserValid