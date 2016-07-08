package br.com.cinq.greet.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class GreetMessage {
	
	private String messageOfDay;
	
	public GreetMessage(){
		
	}
	public GreetMessage(String messageOfDay){
		this.messageOfDay = messageOfDay;	
	}
	
	public String getMessageOfDay() {
		return messageOfDay;
	}
	public void setMessageOfDay(String messageOfDay) {
		this.messageOfDay = messageOfDay;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((messageOfDay == null) ? 0 : messageOfDay.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GreetMessage other = (GreetMessage) obj;
		if (messageOfDay == null) {
			if (other.messageOfDay != null)
				return false;
		} else if (!messageOfDay.equals(other.messageOfDay))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "GreetMessage [messageOfDay=" + messageOfDay + "]";
	}
	
	

}


