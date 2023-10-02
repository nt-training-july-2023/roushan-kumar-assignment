package nucleusteq.com.grievance.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import nucleusteq.com.grievance.entity.Department;
import nucleusteq.com.grievance.entity.Role;

/**
 * User class.
 *
 * @author Roushan Kumar
 * @version 1.0.0
 */

public class UserDto {
  /**
   *Class variable.
   */
  private Integer userId;

  /**
   * username.
   */
  @NotEmpty(message = "username is required size > 2")
  @Size(min = 2)
  private String username;

  /**
   * Full name.
   */
  @NotEmpty(message = "full name is required")
  private String fullName;

  /**
   * Email as string.
   */
  @Email(regexp = "^[a-zA-Z0-9]+\\.[a-zA-Z0-9]+@nucleusteq\\.com$",
      message = "Email address invalid")
  @NotNull(message = "email is required")
  private String email;

  /**
   * Password as string.
   */
  @NotNull(message = "Password is required")
  private String password;

  /**
  * Initial password is integer.
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
   * No arguments constructor.
   * Users data transfer object
   */
  public UserDto() {

  }

  /**
   * Get user id.
   *
   * @return The userId
   */
  public Integer getUserId() {
    return userId;
  }

  /**
   * Set user id.
   *
   * @param userIdParam the userId to set
   */
  public void setUserId(final Integer userIdParam) {
    this.userId = userIdParam;
  }

  /**
   * Get username.
   *
   * @return The username
   */
  public String getUsername() {
    return username;
  }

  /**
   * Set username.
   *
   * @param usernameParam the username to set
   */
  public void setUsername(final String usernameParam) {
    this.username = usernameParam;
  }

  /**
   * Get first name.
   *
   * @return The fullname.
   */
  public String getFullName() {
    return fullName;
  }

  /**
   * Set full name.
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
   * Get password.
   *
   * @return The password
   */
  public String getPassword() {
    return password;
  }

  /**
   * Set password.
   *
   * @param passwordParam the password to set
   */
  public void setPassword(final String passwordParam) {
    this.password = passwordParam;
  }

  /**
   * Get inital password.
   *
   * @return the initalPassword
   */
  public Integer getInitialPassword() {
    return initialPassword;
  }

  /**
   * Set inital password.
   *
   * @param initialPasswordParam the initalPassword to set
   */
  public void setInitialPassword(final Integer initialPasswordParam) {
    this.initialPassword = initialPasswordParam;
  }

  /**
   * Get role.
   *
   * @return The role
   */
  public Role getRole() {
    return role;
  }

  /**
   * Set role.
   *
   * @param roleParam the role to set
   */
  public void setRole(final Role roleParam) {
    this.role = roleParam;
  }

  /**
  * Get Department.
  *
  * @return the department
  */
  public Department getDepartment() {
    return department;
  }

  /**
  * Set department.
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
