package org.blogdemo.claimdemo;

import java.util.Date;

public class ClaimInput {
	
	String customerName = "";
	String customerId="";
	Date claimDate= null;
	String contactPhone = "";
	String email = "";
	String polno = "";
	int applyItem = 0;
	int claimType = 0;
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public Date getClaimDate() {
		return claimDate;
	}
	public void setClaimDate(Date claimDate) {
		this.claimDate = claimDate;
	}
	public String getContactPhone() {
		return contactPhone;
	}
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPolno() {
		return polno;
	}
	public void setPolno(String polno) {
		this.polno = polno;
	}
	public int getApplyItem() {
		return applyItem;
	}
	public void setApplyItem(int applyItem) {
		this.applyItem = applyItem;
	}
	public int getClaimType() {
		return claimType;
	}
	public void setClaimType(int claimType) {
		this.claimType = claimType;
	}
	
	

}
