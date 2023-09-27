package nucleusteq.com.grievance.dto;
import nucleusteq.com.grievance.entity.Department;
import nucleusteq.com.grievance.entity.Role;

public class AllUsersDto {
  /**
   * Serial Number.
   */
  private Integer serialNumber;

  /**
   * User Id.
   */
  private Integer userId;

  /**
   * Username.
   */
  private String username;

  /**
   * Full name.
   */
  private String fullName;

  /**
   * Email in string.
   */
  private String email;

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
  public AllUsersDto() {

  }

 /**
 * All arguments constructor.
 *
 * @param serialNumberParam
 * @param userIdParam
 * @param usernameParam
 * @param fullNameParam
 * @param emailParam
 * @param roleParam
 * @param departmentParam
 */
  public AllUsersDto(
    final Integer serialNumberParam,
    final Integer userIdParam,
    final String usernameParam,
    final String fullNameParam,
    final String emailParam,
    final Role roleParam,
    final Department departmentParam) {
   super();
   this.serialNumber = serialNumberParam;
   this.userId = userIdParam;
   this.username = usernameParam;
   this.fullName = fullNameParam;
   this.email = emailParam;
   this.role = roleParam;
   this.department = departmentParam;
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
   * @return The firstName
   */
  public String getFullName() {
    return fullName;
  }

  /**
   * Set first name.
   *
   * @param firstNameParam the firstName to set
   */
  public void setFullName(final String firstNameParam) {
    this.fullName = firstNameParam;
  }

  /**
   * Get email.
   *
   * @return The email
   */
  public String getEmail() {
    return email;
  }

  /**
   * Set email.
   *
   * @param emailParam the email to set
   */
  public void setEmail(final String emailParam) {
    this.email = emailParam;
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
   * @return The serialNumber
   */
  public Integer getSerialNumber() {
    return serialNumber;
  }

  /**
   * @param serialNumberParam the serialNumber to set
   */
  public void setSerialNumber(final Integer serialNumberParam) {
    this.serialNumber = serialNumberParam;
  }
}

