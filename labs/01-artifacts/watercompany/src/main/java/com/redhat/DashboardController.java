package com.redhat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DashboardController {
	
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
	
	@RequestMapping("/main")
    public String greeting(@RequestParam(value="userid", required=false, defaultValue="ABCDEF") String userid, Model model) {
        model.addAttribute("userid", userid);
        model.addAttribute("accounts", accountrepo.findAll());
        model.addAttribute("payments", paymentrepo.findAll());
        return "main";
    }
	
	
}
