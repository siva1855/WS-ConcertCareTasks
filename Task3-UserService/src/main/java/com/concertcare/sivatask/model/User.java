package com.concertcare.sivatask.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "cc_userservice")
public class User implements Serializable {

	private static final long serialVersionUID = 2372979318509080977L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Integer userId;

	@Column(name = "user_firstname")
	private String userFirstName;

	@Column(name = "user_lastname")
	private String userLasetName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "user_dob")
	private Date userDateOfBirth;

	@Column(name = "user_contact")
	private Long userContactNumber;

	@Column(name = "user_email")
	private String userEmail;

	@Column(name = "user_location")
	private String userLocation;
	
	@Column(name = "department_Id")
	private Integer departmentId;

	public User() {
		super();
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLasetName() {
		return userLasetName;
	}

	public void setUserLasetName(String userLasetName) {
		this.userLasetName = userLasetName;
	}

	public Date getUserDateOfBirth() {
		return userDateOfBirth;
	}

	public void setUserDateOfBirth(Date userDateOfBirth) {
		this.userDateOfBirth = userDateOfBirth;
	}

	public Long getUserContactNumber() {
		return userContactNumber;
	}

	public void setUserContactNumber(Long userContactNumber) {
		this.userContactNumber = userContactNumber;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserLocation() {
		return userLocation;
	}

	public void setUserLocation(String userLocation) {
		this.userLocation = userLocation;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userFirstName=" + userFirstName + ", userLasetName=" + userLasetName
				+ ", userDateOfBirth=" + userDateOfBirth + ", userContactNumber=" + userContactNumber + ", userEmail="
				+ userEmail + ", userLocation=" + userLocation + ", departmentId=" + departmentId + "]";
	}

}
