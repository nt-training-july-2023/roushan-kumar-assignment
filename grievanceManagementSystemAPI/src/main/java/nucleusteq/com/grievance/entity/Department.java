package nucleusteq.com.grievance.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Represents a Department entity for the grievance management system.
 */
@Entity
@Table(
  name = "department",
  uniqueConstraints = { @UniqueConstraint(columnNames = "deptName") }
)
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
  public Department(
      final Integer deptIdParam,
      final String deptNameParam) {
    super();
    this.deptId = deptIdParam;
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

  /**
   * Returns a hash code value for the object.
   *
   * @return A hash code value for this object.
   */
  @Override public int hashCode() {
    return Objects.hash(deptId, deptName);
  }

  /**
   * Indicates whether some other object is "equal to" this one.
   *
   * @param obj The reference object with which to compare.
   * @return {@code true} if this object is the same as the obj argument;
   *         {@code false} otherwise.
   */
  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Department other = (Department) obj;
    return Objects.equals(deptId, other.deptId)
        && Objects.equals(deptName, other.deptName);
  }
}

