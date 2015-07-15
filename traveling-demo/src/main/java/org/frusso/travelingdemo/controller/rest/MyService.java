package org.frusso.travelingdemo.controller.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.frusso.travelingdemo.domain.MyObject;
import org.springframework.stereotype.Component;

@Component
@Path("/myService")
public class MyService {
	
	@GET
	@Path("/myObject")
	@Produces(MediaType.APPLICATION_JSON)
	public MyObject get() {
		MyObject myObject = new MyObject();
		myObject.setName("name object");

		return myObject;
	}

}
