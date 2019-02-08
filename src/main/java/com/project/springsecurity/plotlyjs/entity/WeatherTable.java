package com.project.springsecurity.plotlyjs.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="weathertable")
public class WeatherTable {

//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@Column(name = "weathertable_id")
//	private long id;
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="weatherId")
	private int weatherId;
	
	@Column(name="town")
	private String town;
	
	@Column(name="weather")
	private int weather;
	
	@Column(name="humidity")
	private float humidity;

	 @ManyToOne(fetch = FetchType.LAZY, optional = false)
	 @JoinColumn(name = "username", nullable = false)
    private Users users;
	
	public WeatherTable() {
		
	}
	
//	public long getId() {
//		return id;
//	}
//
//	public void setId(long id) {
//		this.id = id;
//	}

	public String getTown() {
		return town;
	}

	public int getWeatherId() {
		return weatherId;
	}

	public void setWeatherId(int weatherId) {
		this.weatherId = weatherId;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public int getWeather() {
		return weather;
	}

	public void setWeather(int weather) {
		this.weather = weather;
	}

	public float getHumidity() {
		return humidity;
	}

	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "WeatherTable [weatherId=" + weatherId + ", town=" + town + ", weather=" + weather + ", humidity="
				+ humidity + ", users=" + users + "]";
	}

	
	
	
}