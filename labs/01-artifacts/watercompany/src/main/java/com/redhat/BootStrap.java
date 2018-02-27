package com.redhat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrap implements CommandLineRunner{

	private AccountRepository accountrepo;
	private PaymentRepository paymentrepo;
	
	@Autowired
	public void setAccountRepo(AccountRepository accountrepo) {
		this.accountrepo = accountrepo;
	}
	
	@Autowired
	public void setPaymentRepo(PaymentRepository paymentrepo) {
		this.paymentrepo = paymentrepo;
	}
	
	private Integer getRandomInt() {
		return (int)Math.round(Math.random() * 1000);
	}
	
	private Integer getRandomMonth() {
		return (int)Math.round(Math.random() * 12)+1;
	}
	
	private Integer getRandomDate() {
		return (int)Math.round(Math.random() * 28)+1;
	}
	
	@Override
	public void run(String... strings) throws Exception {
		/**Account account1 = new Account();
		account1.setAccountid("ChristinaLin");
		account1.setBalance(300);
		accountrepo.save(account1);
		
		Account account2 = new Account();
		account2.setAccountid("Choco");
		account2.setBalance(455);
		accountrepo.save(account2);
		
		
		
		
		Payment payment1 = new Payment();
		payment1.setPaymentid("1");
		payment1.setAccountid("ChristinaLin");
		payment1.setPaiddate("2017-"+getRandomMonth() +"-"+getRandomDate());
		payment1.setPaidamt(100);
		paymentrepo.save(payment1);
		
		Payment payment2 = new Payment();
		payment2.setPaymentid("2");
		payment2.setAccountid("ChristinaLin");
		payment2.setPaiddate("2017-"+getRandomMonth() +"-"+getRandomDate());
		payment2.setPaidamt(200);
		paymentrepo.save(payment2);
		
		Payment payment3 = new Payment();
		payment3.setPaymentid("3");
		payment3.setAccountid("Choco");
		payment3.setPaiddate("2017-"+getRandomMonth() +"-"+getRandomDate());
		payment3.setPaidamt(99);
		paymentrepo.save(payment3);
		
		Payment payment4 = new Payment();
		payment4.setPaymentid("4");
		payment4.setAccountid("Choco");
		payment4.setPaiddate("2017-"+getRandomMonth() +"-"+getRandomDate());
		payment4.setPaidamt(101);
		paymentrepo.save(payment4);
		
		Payment payment5 = new Payment();
		payment5.setPaymentid("5");
		payment5.setAccountid("Choco");
		payment5.setPaiddate("2017-"+getRandomMonth() +"-"+getRandomDate());
		payment5.setPaidamt(80);
		paymentrepo.save(payment5);
		
		Payment payment6 = new Payment();
		payment6.setPaymentid("6");
		payment6.setAccountid("Choco");
		payment6.setPaiddate("2017-"+getRandomMonth() +"-"+getRandomDate());
		payment6.setPaidamt(70);
		paymentrepo.save(payment6);
		**/
		
		
		
	}
}
