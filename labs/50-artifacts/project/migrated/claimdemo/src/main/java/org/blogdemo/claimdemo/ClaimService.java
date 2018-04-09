package org.blogdemo.claimdemo;

public interface ClaimService {
	
	public ClaimOutput apply(ClaimInput input);
	public ClaimStatus cancel(String claimNo);

}
