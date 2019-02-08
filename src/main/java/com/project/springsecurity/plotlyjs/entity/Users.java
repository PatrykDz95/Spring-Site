package com.project.springsecurity.plotlyjs.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class Users {

//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@Column(name = "user_id")
//	private long id;
	
	@NotNull(message="is required")
	@Size(min=1, message="is required")
	@Id
	@Column(name = "username")
	private String userName;
	
	@NotNull(message="is required")
	@Size(min=1, message="is required")
	@Column(name = "password")
	private String password;
	
	@OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "users")
    private List<WeatherTable> weatherTable;
	
	public Users() {
		
	}
	
	public Users(@NotNull(message = "is required") @Size(min = 1, message = "is required") String userName,
			@NotNull(message = "is required") @Size(min = 1, message = "is required") String password) {
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<WeatherTable> getWeatherTable() {
		return weatherTable;
	}

	public void setWeatherTable(List<WeatherTable> weatherTable) {
		this.weatherTable = weatherTable;
	}

	@Override
	public String toString() {
		return "Users [userName=" + userName + ", password=" + password + 
				", weatherTable=" + weatherTable + "]";
	}
	
	
	
}