package nucleusteq.com.grievance.dto;

/**
 * Response class.
 */
public class ResponseDto {

  /**
   * Id as integer.
   */
  private Integer id;

  /**
   * Message as string.
   */
  private String message;

  /**
   * Status as string.
   */
  private String status;

  /**
   * Constructs a ResponseDto object with an ID, message, and status.
   *
   * @param idParam     The unique identifier for the response.
   * @param messageParam The message associated with the response.
   * @param statusParam  The status is message for the response.
   */
  public ResponseDto(
      final Integer idParam,
      final String messageParam,
      final String statusParam) {
    super();
    this.id = idParam;
    this.message = messageParam;
    this.status = statusParam;
  }

  /**
   * Constructs a ResponseDto object with a message and status.
   *
   * @param messageParam The message associated with the response.
   * @param statusParam  The status is message for the response.
   */
  public ResponseDto(
      final String messageParam,
      final String statusParam) {
    super();
    this.message = messageParam;
    this.status = statusParam;
  }

  /**
   * Gets the ID of the response.
   *
   * @return The unique identifier for the response.
   */
  public Integer getId() {
    return id;
  }

  /**
   * Sets the ID of the response.
   *
   * @param idParam The unique identifier to set for the response.
   */
  public void setId(final Integer idParam) {
    this.id = idParam;
  }

  /**
   * Gets the message associated with the response.
   *
   * @return The message associated with the response.
   */
  public String getMessage() {
    return message;
  }

  /**
   * Sets the message associated with the response.
   *
   * @param messageParam The message to set for the response.
   */
  public void setMessage(final String messageParam) {
    this.message = messageParam;
  }

  /**
   * Gets the status code or status message for the response.
   *
   * @return The status code or status message for the response.
   */
  public String getStatus() {
    return status;
  }

  /**
   * Sets the status code or status message for the response.
   *
   * @param statusParam The status is message to set for the response.
   */
  public void setStatus(final String statusParam) {
    this.status = statusParam;
  }

  /**
   * Generates a string representation of the ResponseDto object.
   *
   * @return A string containing the ID, message, and status of the response.
   */
  @Override
  public String toString() {
    return "ResponseDto [id=" + id + ", message=" + message
       + ", status=" + status + "]";
  }
}
