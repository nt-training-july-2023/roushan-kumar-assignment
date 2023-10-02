package nucleusteq.com.grievance.dto;

public class ChangePassword {

   /**
   * UserId is integer.
   */
  private Integer userId;

  /**
   * Old password as a string.
   */
  private String oldPassword;

  /**
   * New password as a string.
   */
  private String newPassword;

  /**
  * @return The userId
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
   * @return The old password
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
   * @return The new password
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
