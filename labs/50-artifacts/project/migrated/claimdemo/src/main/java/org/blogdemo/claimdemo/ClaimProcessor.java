package org.blogdemo.claimdemo;

import java.util.ArrayList;
import java.util.List;

public class ClaimProcessor {
	public ClaimOutput process(ClaimInput input) throws Exception {
        // get the id of the input
    	//ClaimInput input = exchange.getIn().getBody(ClaimInput.class);

    	System.out.println(input);
    	
    	// set reply including the id
        ClaimOutput output = new ClaimOutput();
        output.setClaimNo("A00099484");
        output.setCustomerName(input.getCustomerName());
        output.setStatus("DONE");
        //exchange.getOut().setBody(output);
        return output;
    }
	
	 public ClaimStatus cancel(String claimNo) throws Exception {
	      
			ClaimStatus status = new ClaimStatus();
		   	status.setClaimNo(claimNo);
		   	status.setStatus("OK");
		   	
		   	return status;
	   }
	 
	 
	   public ClaimStatus status(String id, String fuseversion) throws Exception {
	       // get the id of the input
	   	//ClaimInput input = exchange.getIn().getBody(ClaimInput.class);

	   	System.out.println(id);
	   	System.out.println("ClaimInput :["+ClaimInput.class.getPackage().getName()+"]");
	   	
	       // set reply including the id
	   	ClaimStatus status = new ClaimStatus();
	   	status.setCustomerID(id);
	   	status.setPolno("A123456789");
	   	status.setClaimNo("34567789");
	   	status.setStatus("OK");
	   	status.setFuseversion(fuseversion);
	   	return status;
	   }
	   
	   public List<String> prepareList(String polno){
		   final List<String> params = new ArrayList<String>();
		   params.add(polno);
		   
		   return params;
	   }
}
