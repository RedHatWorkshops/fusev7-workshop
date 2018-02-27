/*
 * Copyright 2016 Red Hat, Inc.
 * <p>
 * Red Hat licenses this file to you under the Apache License, version
 * 2.0 (the "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.  See the License for the specific language governing
 * permissions and limitations under the License.
 *
 */
package com.redhat.demo;

import java.util.LinkedHashMap;

import org.springframework.stereotype.Component;

import com.redhat.demo.data.Account;

/**
 * A sample transform
 */
@Component(value = "balanceService")
public class AccountService {

    public Account getAccountDetail(String accountid) {
        
    	System.out.println("accountid--------> "+accountid);
    		Account account = new Account();
    		
    		Long balance = Math.round(Math.random() * 1000);
    		account.setBalance(balance.intValue());
    		account.setAccountid(accountid);
    		
    	
        return account;
    }
    
    public Account pay(LinkedHashMap<String, Object> payment) {
        
    		System.out.println("body--------> "+payment);
		Account account = new Account();
		
		Long balabnce = Math.round(Math.random() * 1000);
		account.setBalance(balabnce.intValue());
		//account.setBankid(bankid);
		account.setAccountid((String)payment.get("senderid"));
	
    return account;
}

}
