package com.concertcare.sivatask.template;

import java.io.Serializable;

import com.concertcare.sivatask.model.User;
import com.concertcare.sivatask.vo.DepartmentVO;

public class UserDepartmentResponseTemplate implements Serializable {

	private static final long serialVersionUID = 2906218365582363680L;

	private User user;
	private DepartmentVO departmentVO;

	public UserDepartmentResponseTemplate() {
		super();
	}

	public UserDepartmentResponseTemplate(User user, DepartmentVO departmentVO) {
		super();
		this.user = user;
		this.departmentVO = departmentVO;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public DepartmentVO getDepartmentVO() {
		return departmentVO;
	}

	public void setDepartmentVO(DepartmentVO departmentVO) {
		this.departmentVO = departmentVO;
	}

	@Override
	public String toString() {
		return "UserDepartmentResponseTemplate [user=" + user + ", departmentVO=" + departmentVO + "]";
	}

}
