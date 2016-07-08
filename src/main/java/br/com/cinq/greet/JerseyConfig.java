package br.com.cinq.greet;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig {
	
	public JerseyConfig(){
		this.packages("br.com.cinq.greet.controller");
		this.property(ServletProperties.FILTER_FORWARD_ON_404, true);
	}

}
