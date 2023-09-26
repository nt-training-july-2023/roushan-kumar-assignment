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
   * username.
   */
  private String username;

  /**
   * full name.
   */
  private String fullName;

  /**
   * email in string.
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
   * no argument constructor.
   * Users data transfer object
   */
  public AllUsersDto() {

  }

 /**
 * All argument constructor.
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
   * @return the serialNumber
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

