package com.redhat;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Account {

	@Id
	String accountid;
	Integer balance;
	
	public String getAccountid() {
		return accountid;
	}
	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}
	public Integer getBalance() {
		return balance;
	}
	public void setBalance(Integer balance) {
		this.balance = balance;
	}
	
	public int getNumerator() {
		if (balance > 0 &&  balance < 999)
			return balance/10;
		else if (balance > 999 && balance < 9999)
			return balance/100;
		else if (balance > 9999 && balance < 99999 )
			return balance/1000;
		else if (balance > 99999 && balance < 999999 )
			return balance/10000;
		else 
			return 100;
	}
	
	public int getRemains() {
		return 100-getNumerator();
	}
	
	public String getNumeratorStyle() {
		
		return "width: "+getNumerator()+"%;";
		
	}
	
	public String getRemainsStyle() {
		
		return "width: "+getRemains()+"%;";
		
	}
	
}
