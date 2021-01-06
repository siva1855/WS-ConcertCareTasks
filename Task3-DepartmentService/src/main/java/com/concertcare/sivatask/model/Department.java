package com.concertcare.sivatask.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cc_departmentservice")
public class Department implements Serializable {

	private static final long serialVersionUID = 938884906591273873L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "department_id")
	private Integer departmentId;

	@Column(name = "department_name")
	private String departmentName;

	@Column(name = "department_code")
	private String departmentCode;

	@Column(name = "department_address")
	private String departmentAddress;

	@Column(name = "department_contactnumber")
	private Long departmentContactNumber;

	@Column(name = "department_email")
	private String departmentEmail;

	public Department() {
		super();
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public String getDepartmentAddress() {
		return departmentAddress;
	}

	public void setDepartmentAddress(String departmentAddress) {
		this.departmentAddress = departmentAddress;
	}

	public Long getDepartmentContactNumber() {
		return departmentContactNumber;
	}

	public void setDepartmentContactNumber(Long departmentContactNumber) {
		this.departmentContactNumber = departmentContactNumber;
	}

	public String getDepartmentEmail() {
		return departmentEmail;
	}

	public void setDepartmentEmail(String departmentEmail) {
		this.departmentEmail = departmentEmail;
	}

	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + ", departmentCode="
				+ departmentCode + ", departmentAddress=" + departmentAddress + ", departmentContactNumber="
				+ departmentContactNumber + ", departmentEmail=" + departmentEmail + "]";
	}
}
