function NewUserValid(user) {
 console.log("validation on user "+user.email);
 const userEmail = user.email.trim();
 const reg = new RegExp("^[a-zA-Z0-9]+\\.[a-zA-Z0-9]+@nucleusteq\\.com$");
 console.log(reg.test(userEmail));

  if (user.username.trim() === "") {
    return "Username is required";
  }

  if (user.fullName.trim() === "") {
    return "FullName is required";
  } 

  if(user.password.trim() === "") {
    return "Password is required."

  } else if (user.password.length < 8) {
    return "The password should be a minimum of 8 characters.";
  } 

  if(user.email.trim() === "")
    return "Email is required.";
  else if(!reg.test(userEmail)) 
  {
    return "Invalid Email Id."
  }

 if (user.role.name === "0" || user.role.name === "" )
    return "Select User Type.";

  if (user.department.deptName === "0" || user.department.deptName === "" )
    return "Select Department.";

  return false;
}

export default NewUserValid