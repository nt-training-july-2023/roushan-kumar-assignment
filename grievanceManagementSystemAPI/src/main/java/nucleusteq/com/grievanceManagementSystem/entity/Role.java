package nucleusteq.com.grievanceManagementSystem.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "role" ,uniqueConstraints = {
		@UniqueConstraint(columnNames = "name")
})
public class Role {	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer roleId;
	@Column(name="name" , unique = true)
	private String name;
	public Role(){}
	public Role(Integer roleId, String name) {
		super();
		this.roleId = roleId;
		this.name = name;
	}
	/**
	 * @return the roleId
	 */
	public Integer getRoleId() {
		return roleId;
	}
	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}