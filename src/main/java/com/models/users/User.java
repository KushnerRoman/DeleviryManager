package com.models.users;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.utils.ServiceUtils.UserTypeUtils;

import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;

import lombok.NoArgsConstructor;


@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class User {
	
	


	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	protected long id;
	
	@Column(nullable = false ,unique = true)
	@ApiModelProperty(example = "name@email.com", value=" Min=1 Max=255 " )
	protected String email;
	
	@ApiModelProperty(value = "Min=1, Max=255.")
	protected String password;	
	
	@Column(nullable = false ,unique = false)
	@ApiModelProperty(value = "Min=1, Max=12 ")
	protected String firstName;
	
	@Column(nullable = false ,unique = false)
	@ApiModelProperty(value = "Min=1, Max=15 ")
	protected String lastName;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	public UserTypeUtils role;


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public UserTypeUtils getRole() {
		return role;
	}
	public void setRole(UserTypeUtils role) {
		this.role = role;
	}
	@Override
	public int hashCode() {
		return Objects.hash(email, firstName, id, lastName, password, role);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName) && id == other.id
				&& Objects.equals(lastName, other.lastName) && Objects.equals(password, other.password)
				&& role == other.role;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", role=" + role + "]";
	}
	
}
