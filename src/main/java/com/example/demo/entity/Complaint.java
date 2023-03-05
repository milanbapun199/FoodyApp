package com.example.demo.entity;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "merchant_complaint")
public class Complaint {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "complaint_id")
	private Long merchantComplaintId;
	@Column(name = "subject")
	private String subject;
	@Column(name = "body")
	private String body;
	@Column(name = "file_path")
	private String filePath;
	@Column(name = "status")
	private String status;
	@Column(name = "email")
	private String email;
	@Column(name = "merchant_id")
	private Long merchantId;
	public Long getMerchantComplaintId() {
		return merchantComplaintId;
	}
	public void setMerchantComplaintId(Long merchantComplaintId) {
		this.merchantComplaintId = merchantComplaintId;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(Long merchantId) {
		this.merchantId = merchantId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Complaint [merchantComplaintId=" + merchantComplaintId + ", subject=" + subject + ", body=" + body
				+ ", filePath=" + filePath + ", status=" + status + ", email=" + email + ", merchantId=" + merchantId
				+ "]";
	}
	
	
	
}
