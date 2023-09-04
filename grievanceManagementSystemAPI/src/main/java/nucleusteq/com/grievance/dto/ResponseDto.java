package nucleusteq.com.grievance.dto;

public class ResponseDto {
	private Integer id;
  private String message;
  private String status;

  /**
   * @param id
   * @param message
   * @param status
   */public ResponseDto(Integer id, String message, String status) {
    super();
    this.id = id;
    this.message = message;
    this.status = status;
  }

  /**
   * @param message
   * @param status
   */public ResponseDto(String message, String status) {
    super();
    this.message = message;
    this.status = status;
  }

  /**
   * @return the id
   */
  public Integer getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * @return the message
   */
  public String getMessage() {
    return message;
  }

  /**
   * @param message the message to set
   */
  public void setMessage(String message) {
    this.message = message;
  }

  /**
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * @param status the status to set
   */
  public void setStatus(String status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "ResponseDto [id=" + id + ", message=" + message + ", status=" + status + "]";
  }
}

