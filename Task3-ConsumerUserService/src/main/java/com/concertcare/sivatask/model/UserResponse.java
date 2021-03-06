package com.concertcare.sivatask.model;

import java.io.Serializable;

public class UserResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String status;
	private String token;

	public UserResponse() {
		super();
	}

	public UserResponse(String status, String token) {
		super();
		this.status = status;
		this.token = token;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "UserResponse [status=" + status + ", token=" + token + "]";
	}

}
