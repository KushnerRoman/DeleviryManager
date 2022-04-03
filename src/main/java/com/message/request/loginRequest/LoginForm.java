package com.message.request.loginRequest;

import java.util.Objects;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.utils.ServiceUtils.UserTypeUtils;
import com.utils.modelUtils.UserEnityUtils;



public class LoginForm {

	@NotBlank
	@Size( min=3 ,max=15)
	private String username;
	
	@NotBlank
	@Size( min=3 ,max=15)
	private String password;
	
	@NotBlank
	@Enumerated(EnumType.STRING)
	private UserTypeUtils role;

	public LoginForm(@NotBlank @Size(min = 3, max = 15) String username,
			@NotBlank @Size(min = 3, max = 15) String password, @NotBlank UserTypeUtils role) {
		
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserTypeUtils getRole() {
		return role;
	}

	public void setRole(UserTypeUtils role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		return Objects.hash(password, role, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoginForm other = (LoginForm) obj;
		return Objects.equals(password, other.password) && role == other.role
				&& Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "LoginForm [username=" + username + ", password=" + password + ", role=" + role + "]";
	}
	
	
}
