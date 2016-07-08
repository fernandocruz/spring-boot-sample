package br.com.cinq.greet.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cinq.greet.model.GreetMessage;
import br.com.cinq.greet.service.GreetMessageService;

@Service
public class GreetMessageServiceImpl implements GreetMessageService {
	
	private static final int MIN_NUMBER = 0;
	private static final int MAX_NUMBER = 3;
	
	@Autowired
	private GreetMessage greet;
	
	List<String> messages = Collections.synchronizedList(new ArrayList<String>());
	
	@PostConstruct
	public void init(){
		messages.add("Great Surprise, you win U$10");
		messages.add("Great Surprise, you win U$20");
		messages.add("Great Surprise, you win U$30");
		messages.add("Today is not your lucky day");
	}
	
	@Override
	public GreetMessage setNewGreetMessage(GreetMessage greetMessage){
		greet.setMessageOfDay(greetMessage.getMessageOfDay());
		return greet;
	}
	
	@Override
	public GreetMessage getGreet(){	
		greet.setMessageOfDay(getRandomMessageForGreet());
		return greet;
	}
	
	private String getRandomMessageForGreet(){
		
		Random rand = new Random();
		int randomNum = rand.nextInt((MAX_NUMBER - MIN_NUMBER) + 1) + MIN_NUMBER;		
		return messages.get(randomNum);
	}

}
