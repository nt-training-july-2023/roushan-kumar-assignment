package nucleusteq.com.grievance.dto;

public class DepartmentDto {
  /**
   * Serial number of department.
   */
  private Integer serialNumber;

  /**
   * Department Id is Integer.
   */
  private Integer deptId;

  /**
   * Department name.
   */
  private String deptName;

  /**
   * No args constructor.
   */
  public DepartmentDto() {

  }

  /**
   * All args constructor.
   *
   * @param serialNumberParam
   * @param deptIdParam
   * @param deptNameParam
   */
    public DepartmentDto(
    final Integer serialNumberParam,
    final Integer deptIdParam,
    final String deptNameParam
  ) {
    super();
    this.serialNumber = serialNumberParam;
    this.deptId = deptIdParam;
    this.deptName = deptNameParam;
  }

  /**
   * @return The department id.
   */
  public Integer getDeptId() {
    return deptId;
  }

  /**
   * @param deptIdParam the deptId to set
   */
  public void setDeptId(final Integer deptIdParam) {
    this.deptId = deptIdParam;
  }

  /**
   * @return The department name.
   */
  public String getDeptName() {
    return deptName;
  }

  /**
   * @param deptNameParam the deptName to set
   */
  public void setDeptName(final String deptNameParam) {
    this.deptName = deptNameParam;
  }

  /**
   * @return The serial number
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

  /**
   * Department.
   */
  @Override
  public String toString() {
    return "DepartmentDto [serialNumber=" + serialNumber
        + ", deptId=" + deptId + ", deptName=" + deptName + "]";
    }
}
