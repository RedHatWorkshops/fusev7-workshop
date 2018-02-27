package com.redhat.demo.data;

import java.io.Serializable;

public class Payment implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6564868614243801682L;
	
	Integer accounttype;
	Integer amount;
	String senderid;
	
	public Integer getAccounttype() {
		return accounttype;
	}
	public void setAccounttype(Integer accounttype) {
		this.accounttype = accounttype;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	public String getSenderid() {
		return senderid;
	}
	public void setSenderid(String senderid) {
		this.senderid = senderid;
	}
	
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Payment:[");
		sb.append("accounttype ="+ accounttype +",");
		sb.append("amount ="+ amount +",");
		sb.append("senderid ="+ senderid +"");
		sb.append("]");
		return sb.toString();
	}
	
}
