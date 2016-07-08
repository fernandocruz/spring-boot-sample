package br.com.cinq.greet.controller;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.cinq.greet.model.GreetMessage;
import br.com.cinq.greet.service.GreetMessageService;

@Component
@Path("/greet")
public class GreetMessageController {
	
	@Autowired
	private  GreetMessageService service;
	
	@GET
	@Produces("application/json")
	public GreetMessage getMessageOfDay(){
		return service.getGreet();
	}
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public GreetMessage updateMessage(GreetMessage greetMessage){	
		return service.setNewGreetMessage(greetMessage);
	}

}
