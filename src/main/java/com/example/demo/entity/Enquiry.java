package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "enquiry")
public class Enquiry {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "enquiry_id")
	private Long enquiryId;
	
	@Column(name = "name")
	private String name;
	@Column(name = "mob_no")
	private String mobNo;
	@Column(name = "email")
	private String email;
	@Column(name = "subject")
	private String subject;
	@Column(name = "message")
	private String message;
	public Long getEnquiryId() {
		return enquiryId;
	}
	public void setEnquiryId(Long enquiryId) {
		this.enquiryId = enquiryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobNo() {
		return mobNo;
	}
	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "Enquiry [enquiryId=" + enquiryId + ", name=" + name + ", mobNo=" + mobNo + ", email=" + email
				+ ", subject=" + subject + ", message=" + message + "]";
	}
	
}
