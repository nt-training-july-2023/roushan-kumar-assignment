package nucleusteq.com.grievance.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import nucleusteq.com.grievance.entity.Department;
import nucleusteq.com.grievance.entity.Role;

/**
 * userDto class.
 *
 * @author roushan Kumar
 *
 */

public class UserDto {
  /**
   *class variable.
   */
  private Integer userId;

  /**
   * username.
   */
  @NotEmpty(message = "username is required size > 2")
  @Size(min = 2)
  private String username;

  /**
   * full name.
   */
  @NotEmpty(message = "full name is required")
  private String fullName;

  /**
   * email in string.
   */
  @Email(regexp = "^[a-zA-Z0-9]+\\.[a-zA-Z0-9]+@nucleusteq\\.com$",
      message = "Email address invalid")
  @NotNull(message = "email is required")
  private String email;

  /**
   * Password in string.
   */
  @NotNull(message = "Password is required")
  private String password;

  /**
  * initialPassword is integer.
  */
  private Integer initialPassword;

  /**
   * Role is Class.
   */
  private Role role;

  /**
   * Department is Class.
   */
  private Department department;

  /**
   * no argument constructor.
   * Users data transfer object
   */
  public UserDto() {

  }

  /**
   * get user id.
   *
   * @return the userId
   */
  public Integer getUserId() {
    return userId;
  }

  /**
   * set user id.
   *
   * @param userIdParam the userId to set
   */
  public void setUserId(final Integer userIdParam) {
    this.userId = userIdParam;
  }

  /**
   * get username.
   *
   * @return the username
   */
  public String getUsername() {
    return username;
  }

  /**
   * set username.
   *
   * @param usernameParam the username to set
   */
  public void setUsername(final String usernameParam) {
    this.username = usernameParam;
  }

  /**
   * get first name.
   *
   * @return the firstName
   */
  public String getFullName() {
    return fullName;
  }

  /**
   * set first name.
   *
   * @param firstNameParam the firstName to set
   */
  public void setFullName(final String firstNameParam) {
    this.fullName = firstNameParam;
  }

  /**
   * getEmail.
   *
   * @return the email
   */
  public String getEmail() {
    return email;
  }

  /**
   * setEmail.
   *
   * @param emailParam the email to set
   */
  public void setEmail(final String emailParam) {
    this.email = emailParam;
  }

  /**
   * getPassword.
   *
   * @return the password
   */
  public String getPassword() {
    return password;
  }

  /**
   * setPassword.
   *
   * @param passwordParam the password to set
   */
  public void setPassword(final String passwordParam) {
    this.password = passwordParam;
  }

  /**
   * getInitalPassword.
   *
   * @return the initalPassword
   */
  public Integer getInitialPassword() {
    return initialPassword;
  }

  /**
   * setInitalPassword.
   *
   * @param initialPasswordParam the initalPassword to set
   */
  public void setInitalPassword(final Integer initialPasswordParam) {
    this.initialPassword = initialPasswordParam;
  }

  /**
   * getRole.
   *
   * @return the role
   */
  public Role getRole() {
    return role;
  }

  /**
   * setRole.
   *
   * @param roleParam the role to set
   */
  public void setRole(final Role roleParam) {
    this.role = roleParam;
  }

  /**
  * get Department.
  *
  * @return the department
  */
  public Department getDepartment() {
    return department;
  }

  /**
  * set department.
  *
  * @param departmentParam the department to set
  */
  public void setDepartment(
      final Department departmentParam) {
    this.department = departmentParam;
  }

  /**
   * To string method.
   */
  @Override
  public String toString() {
    return "UserDto [userId=" + userId + ", username="
      + username + ", fullName=" + fullName + ", email="
      + email + ", password=" + password + ", initalPassword="
      + initialPassword + ", role=" + role + ", department="
      + department + "]";
  }

}
