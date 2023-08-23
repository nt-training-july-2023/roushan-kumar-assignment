package nucleusteq.com.grievanceManagementSystem.dto;

import java.util.Collection;

import nucleusteq.com.grievanceManagementSystem.entity.Role;

public class UserDto {
	private Integer userId;
	private String username;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private Integer initalPassword;
	private Collection<Role> role;
	public UserDto() {}
	public UserDto(Integer userId, String username, String firstName, String lastName, String email, String password,
			Integer initalPassword, Collection<Role> role) {
		super();
		this.userId = userId;
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
	
	
}
