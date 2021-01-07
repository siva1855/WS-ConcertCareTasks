package com.concertcare.sivatask.vo;

import java.io.Serializable;

public class StudentVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer studentId;
	private String studentName;
	private String studentCourse;
	private Double studentFee;

	public StudentVO() {
		super();
	}

	public StudentVO(Integer studentId, String studentName, String studentCourse, Double studentFee) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentCourse = studentCourse;
		this.studentFee = studentFee;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentCourse() {
		return studentCourse;
	}

	public void setStudentCourse(String studentCourse) {
		this.studentCourse = studentCourse;
	}

	public Double getStudentFee() {
		return studentFee;
	}

	public void setStudentFee(Double studentFee) {
		this.studentFee = studentFee;
	}

	@Override
	public String toString() {
		return "StudentVO [studentId=" + studentId + ", studentName=" + studentName + ", studentCourse=" + studentCourse
				+ ", studentFee=" + studentFee + "]";
	}

}
