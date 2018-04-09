package org.blogdemo.claimdemo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/status")
public class StatusService {
	
	@GET
	@Path("/custId/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ClaimStatus status(@PathParam("id") String custId){
		return null;
	}

	@GET
	@Path("/restcancel/{claimNo}")
	@Produces(MediaType.APPLICATION_JSON)
	public ClaimStatus restCancel(@PathParam("claimNo") String claimNo){
		return null;
	}
}
