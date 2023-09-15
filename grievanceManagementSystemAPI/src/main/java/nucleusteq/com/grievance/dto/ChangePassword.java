package nucleusteq.com.grievance.dto;

public class ChangePassword {

   /**
   * UserId is integer.
   */
  private Integer userId;

  /**
   * oldPassword as string.
   */
  private String oldPassword;

  /**
   * newPassword as string.
   */
  private String newPassword;

  /**
  * @return the userId
  */
  public Integer getUserId() {
    return userId;
  }

  /**
   * @param userIdParam the userId to set
   */
  public void setUserId(
      final Integer userIdParam) {
    this.userId = userIdParam;
  }

  /**
   * @return the oldPassword
   */
  public String getOldPassword() {
    return oldPassword;
  }

  /**
   * @param oldPasswordParam the oldPassword to set
   */
  public void setOldPassword(
      final String oldPasswordParam) {
    this.oldPassword = oldPasswordParam;
  }

  /**
   * @return the newPassword
   */
  public String getNewPassword() {
    return newPassword;
  }

  /**
   * @param newPasswordParam the newPassword to set
   */
  public void setNewPassword(
      final String newPasswordParam) {
    this.newPassword = newPasswordParam;
  }
}
