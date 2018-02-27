package com.redhat;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Payment {

	@Id
	String paymentid;
	String accountid;
	String paiddate;
	Integer paidamt;
	
	public String getPaiddate() {
		return paiddate;
	}
	public void setPaiddate(String paiddate) {
		this.paiddate = paiddate;
	}
	public String getAccountid() {
		return accountid;
	}
	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}
	public Integer getPaidamt() {
		return paidamt;
	}
	public void setPaidamt(Integer paidamt) {
		this.paidamt = paidamt;
	}
	public String getPaymentid() {
		return paymentid;
	}
	public void setPaymentid(String paymentid) {
		this.paymentid = paymentid;
	}
	
	
	
}
