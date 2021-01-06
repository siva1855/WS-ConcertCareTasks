package com.concertcare.sivatask.vo;

import java.io.Serializable;

public class DepartmentVO implements Serializable {

	private static final long serialVersionUID = 6031162103294250838L;

	private Integer departmentId;
	private String departmentName;
	private String departmentCode;
	private String departmentAddress;
	private Long departmentContactNumber;
	private String departmentEmail;

	public DepartmentVO() {
		super();
	}

	public DepartmentVO(Integer departmentId, String departmentName, String departmentCode, String departmentAddress,
			Long departmentContactNumber, String departmentEmail) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.departmentCode = departmentCode;
		this.departmentAddress = departmentAddress;
		this.departmentContactNumber = departmentContactNumber;
		this.departmentEmail = departmentEmail;
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
