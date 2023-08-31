package nucleusteq.com.grievance.dto;

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
  @NotNull(message = "email is required")
  private String email;

  /**
   * Password in string.
   */
  @NotNull(message = "password is required")
  private String password;

  /**
  * intailPassword is integer.
  */
  private Integer initalPassword;

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
   * All arg constructor.
   *
   * @param userIdParam unique id for user
   * @param usernameParam unique email for user
   * @param fullNameParam first name
   * @param emailParam email
   * @param passwordParam password
   * @param initalPasswordParam initalPassword
   * @param roleParam userType
   */
  public UserDto(
      final Integer userIdParam,
      @NotEmpty(message = "username is required") @Size(min = 2)
      final String usernameParam,
      @NotEmpty(message = "full name is required")
      final String fullNameParam,
      @NotNull(message = "email is required")
      final String emailParam,
      @NotNull(message = "password is required")
      final String passwordParam,
      final Integer initalPasswordParam,
      final Role roleParam,
      final Department departmentParam
  ) {
    super();
    this.userId = userIdParam;
    this.username = usernameParam;
    this.fullName = fullNameParam;
    this.email = emailParam;
    this.password = passwordParam;
    this.initalPassword = initalPasswordParam;
    this.role = roleParam;
    this.department = departmentParam;
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
  public Integer getInitalPassword() {
    return initalPassword;
  }

  /**
   * setInitalPassword.
   *
   * @param initalPasswordParam the initalPassword to set
   */
  public void setInitalPassword(final Integer initalPasswordParam) {
    this.initalPassword = initalPasswordParam;
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
  * @param department the department to set
  */
  public void setDepartment(Department department) {
    this.department = department;
  }

  /**
   * To string method.
   */
  @Override
  public String toString() {
    return "UserDto [userId=" + userId + ", username="
      + username + ", fullName=" + fullName + ", email="
      + email + ", password=" + password + ", initalPassword="
      + initalPassword + ", role=" + role + ", department="
      + department + "]";
  }

}
