package nucleusteq.com.grievance.dto;

public class LoginDto {

  /**
   * username.
   */
  private String username;

  /**
   * password.
   */
  private String password;

  /**
   * No arg constructor.
   */
  public LoginDto() {
  }

  /**
   * All arg constructor.
   *
   * @param usernameParam
   * @param passwordParam
   */
   public LoginDto(
       final String usernameParam,
       final String passwordParam) {
    super();
    this.username = usernameParam;
    this.password = passwordParam;
  }

  /**
   * User username.
   *
   * @return the username
   */
  public String getUsername() {
    return username;
  }

  /**
   * User username.
   *
   * @param usernameParam the username to set
   */
  public void setUsername(final String usernameParam) {
    this.username = usernameParam;
  }

  /**
   * User password.
   *
   * @return the password
   */
  public String getPassword() {
    return password;
  }

  /**
   * User password.
   *
   * @param passwordParam the password to set
   */
  public void setPassword(final String passwordParam) {
    this.password = passwordParam;
  }

  /**
   * Login dto details.
   */
  @Override
  public String toString() {
    return "LoginDto [username=" + username + ", password=" + password + "]";
  }
}
