package nucleusteq.com.grievance.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Department Class.
 */
@Entity
@Table(name = "department")
public class Department {
  /**
   * DeptId is Integer.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer deptId;

  /**
   * Department name.
   */
  @Column
  private String deptName;

  /**
   * No args Constructor.
   */
  public Department() {

  }

  /**
   * All arg Constructor.
   *
   * @param deptIdParam department id.
   * @param deptNameParam department name.
   */
  public Department(final Integer deptIdParam,
      final String deptNameParam) {
    super();
    this.deptId = deptIdParam;
    this.deptName = deptNameParam;
  }

  /**
   * All arg Constructor.
   *
   * @param deptNameParam department name.
   */
  public Department(final String deptNameParam) {
    super();
    this.deptName = deptNameParam;
  }

  /**
   * get department Id.
   *
   * @return the deptId
   */
  public Integer getDeptId() {
    return deptId;
  }

  /**
   * set department department id.
   *
   * @param deptIdParam the deptId to set
   */
  public void setDeptId(final Integer deptIdParam) {
    this.deptId = deptIdParam;
  }

  /**
   * get department name.
   *
   * @return the deptName
   */
  public String getDeptName() {
    return deptName;
  }

  /**
   * set department name.
   *
   * @param deptNameParam the deptName to set
   */
  public void setDeptName(final String deptNameParam) {
    this.deptName = deptNameParam;
  }

  /**
   * Department details.
   */
  @Override
  public String toString() {
    return "Department [deptId=" + deptId + ", deptName=" + deptName + "]";
  }

}
