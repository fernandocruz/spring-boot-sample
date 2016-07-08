package br.com.cinq.greet.service;

import br.com.cinq.greet.model.GreetMessage;

public interface GreetMessageService {
	
	public GreetMessage setNewGreetMessage(GreetMessage greetMessage);
	public GreetMessage getGreet();

}
