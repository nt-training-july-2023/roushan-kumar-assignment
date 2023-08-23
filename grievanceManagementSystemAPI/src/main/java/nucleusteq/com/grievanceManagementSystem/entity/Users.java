package nucleusteq.com.grievanceManagementSystem.entity;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.JoinColumn;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@ToString
@Entity
@Table(name = "users" ,uniqueConstraints = {
		@UniqueConstraint(columnNames = "username")
})
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	@Column(name="username", unique = true)
	private String username;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private String email;
	@Column
	private String password;
	@Column
	private Integer initalPassword;
	@ManyToMany(fetch = FetchType.LAZY, cascade= {CascadeType.DETACH,
			 CascadeType.MERGE,
			 CascadeType.PERSIST,
			 CascadeType.REFRESH})
		@JoinTable(name = "users_roles", 
		joinColumns = @JoinColumn(name = "user_id"), 
		inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Collection<Role> role;
	public Users() {}
	public Users(Integer id, String username, String firstName, String lastName, String email, String password,
			Integer initalPassword,Collection<Role> role) {
		super();
		this.userId = id;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.initalPassword = initalPassword;
		this.role = role;
	}
	public Users(String username, String firstName, String lastName, String email, String password,
			Integer initalPassword, Collection<Role> role) {
		super();
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.initalPassword = initalPassword;
		this.role = role;
	}
	/**
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the initalPassword
	 */
	public Integer getInitalPassword() {
		return initalPassword;
	}
	/**
	 * @param initalPassword the initalPassword to set
	 */
	public void setInitalPassword(Integer initalPassword) {
		this.initalPassword = initalPassword;
	}
	/**
	 * @return the role
	 */
	public Collection<Role> getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(Collection<Role> role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Users [userId=" + userId + ", username=" + username + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", password=" + password + ", initalPassword=" + initalPassword
				+ ", role=" + role + "]";
	}
	
	
	
	
	
}
