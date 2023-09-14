package nucleusteq.com.grievance.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Represents a user entity for the grievance management system.
 */
@Entity
@Table(name = "users",
    uniqueConstraints = {@UniqueConstraint(columnNames = "username")})
public class Users {

  /**
  * Id in Integer.
  */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer userId;

  /**
  * user name in string and uique.
  */
  @Column(name = "username")
  private String username;

  /**
  * fullname in String.
  */
  @Column
  private String fullName;

  /**
  * email in string.
  */
  @Column(nullable = false,unique = true)
  private String email;

  /**
  * password in string.
  */
  @Column
  private String password;

  /**
  * intialPassword in Integer.
  */
  @Column
  private Integer initialPassword;

  /**
   * Role mapping.
   */
  @ManyToOne(
      cascade = {
        CascadeType.DETACH,
        CascadeType.MERGE,
        CascadeType.PERSIST,
        CascadeType.REFRESH
      })
  @JoinColumn(name = "role_id")
  private Role role;

  /**
   * Department mapping.
   */
  @ManyToOne
  @JoinColumn(name = "department_id")
  private Department department;

  /**
   * No arg constructor.
   */
  public Users() {
  }

//  /**
//  * Constructor with userId (used for creating new users).
//  *
//  * @param userIdParam as Integer.
//  * @param userNameParam as string.
//  * @param fullNameParam as string.
//  * @param emailParam as string.
//  * @param passwordParam as string.
//  * @param initialPasswordParam as Integer.
//  * @param roleParam as Collection.
//  * @param departmentParam as class.
//  */
//  public Users(
//      final Integer userIdParam,
//      final String userNameParam,
//      final String fullNameParam,
//      final String emailParam,
//      final String passwordParam,
//      final Integer initialPasswordParam,
//      final Role roleParam,
//      final Department departmentParam) {
//    this.userId = userIdParam;
//    this.username = userNameParam;
//    this.fullName = fullNameParam;
//    this.email = emailParam;
//    this.password = passwordParam;
//    this.initialPassword = initialPasswordParam;
//    this.role = roleParam;
//    this.department = departmentParam;
//  }

  /**
   * Constructor without userId (used for creating new users).
   *
   * @param userNameParam as string.
   * @param fullNameParam as string.
   * @param emailParam as string.
   * @param passwordParam as string.
   * @param initialPasswordParam as Integer.
   * @param roleParam as class.
   * @param departmentParam as class
   */
  public Users(
      final String userNameParam,
      final String fullNameParam,
      final String emailParam,
      final String passwordParam,
      final Integer initialPasswordParam,
      final Role roleParam,
      final Department departmentParam) {
    this.username = userNameParam;
    this.fullName = fullNameParam;
    this.email = emailParam;
    this.password = passwordParam;
    this.initialPassword = initialPasswordParam;
    this.role = roleParam;
    this.department = departmentParam;
  }

  /**
   * Get the user's ID.
   *
   * @return The user's ID.
   */
  public Integer getUserId() {
    return userId;
  }

  /**
   * Set the user's ID.
   *
   * @param userIdParam The user's ID to set.
   */
  public void setUserId(final Integer userIdParam) {
    this.userId = userIdParam;
  }

  /**
   * Get the username.
   *
   * @return The username.
   */
  public String getUsername() {
    return username;
  }

  /**
   * Set the username.
   *
   * @param usernameParam The username to set.
   */
  public void setUsername(final String usernameParam) {
    this.username = usernameParam;
  }

  /**
   * Get the full name.
   *
   * @return The full name.
   */
  public String getFullName() {
    return fullName;
  }

  /**
   * Set the first name.
   *
   * @param fullNameParam The first name to set.
   */
  public void setFullName(final String fullNameParam) {
    this.fullName = fullNameParam;
  }

  /**
   * Get the email.
   *
   * @return The email.
   */
  public String getEmail() {
    return email;
  }

  /**
   * Set the email.
   *
   * @param emailParam The email to set.
   */
  public void setEmail(final String emailParam) {
    this.email = emailParam;
  }

  /**
   * Get the password.
   *
   * @return The password.
   */
  public String getPassword() {
    return password;
  }

  /**
   * Set the password.
   *
   * @param passwordParam The password to set.
   */
  public void setPassword(final String passwordParam) {
    this.password = passwordParam;
  }

  /**
   * Get the initial password.
   *
   * @return The initial password.
   */
  public Integer getInitialPassword() {
    return initialPassword;
  }

  /**
   * Set the initial password.
   *
   * @param initialPasswordParam The initial password to set.
   */
  public void setInitialPassword(final Integer initialPasswordParam) {
    this.initialPassword = initialPasswordParam;
  }

  /**
   * Get the user's roles.
   *
   * @return The user's roles.
   */
  public Role getRole() {
    return role;
  }

  /**
   * Set the user's roles.
   *
   * @param roleParam The roles to set.
   */
  public void setRole(final Role roleParam) {
    this.role = roleParam;
  }

  
  /**
  * get department.
  *
  * @return the department
  */
  public Department getDepartment() {
    return department;
  }

  /**
  * set Department.
  *
  * @param departmentParam the department to set
  */
  public void setDepartment(Department departmentParam) {
    this.department = departmentParam;
  }

  /**
  * User Details.
  */
  @Override
  public String toString() {
    return "Users [userId=" + userId + ", username="
      + username + ", fullName=" + fullName + ", email="
      + email + ", password=" + password + ", initialPassword="
      + initialPassword + ", role=" + role + ", department="
      + department + "]";
  }

}
