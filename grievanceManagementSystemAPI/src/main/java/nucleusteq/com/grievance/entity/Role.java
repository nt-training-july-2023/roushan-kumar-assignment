package nucleusteq.com.grievance.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Represents a Role entity for the grievance management system.
 */
@Entity
@Table(name = "role",
    uniqueConstraints = { @UniqueConstraint(columnNames = "name") })
public class Role {

  /**
   * Role Id in integer.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer roleId;

  /**
   * Role type in string.
   */
  @Column(name = "name", unique = true)
  private String name;

  /**
   * No args constructor.
   */
  public Role() {

  }

  /**
   * Role constructor.
   *
   * @param roleIdParam role id as integer.
   * @param nameParam name as String.
   */
  public Role(
      final Integer roleIdParam,
      final String nameParam) {
    super();
    this.roleId = roleIdParam;
    this.name = nameParam;
  }

  /**
   * Get role id.
   *
   * @return the roleId
   */
  public Integer getRoleId() {
    return roleId;
  }

  /**
   * Set role id.
   *
   * @param roleIdParam the roleId to set
   */
  public void setRoleId(final Integer roleIdParam) {
    this.roleId = roleIdParam;
  }

  /**
   * Get name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Set name.
   *
   * @param nameParam the name to set
   */
  public void setName(final String nameParam) {
    this.name = nameParam;
  }

  /**
   * Role details.
   */
  @Override
  public String toString() {
    return "Role [roleId=" + roleId + ", name=" + name + "]";
  }
}
