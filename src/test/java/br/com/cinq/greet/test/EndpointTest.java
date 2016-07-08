package br.com.cinq.greet.test;


import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import br.com.cinq.greet.Application;
import br.com.cinq.greet.model.GreetMessage;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=Application.class)
@WebIntegrationTest(randomPort = true)
public class EndpointTest {
	
	private static final String HOST_NAME = "http://localhost:";
	private static final String CONTEXT = "/greet";
	private static final String TEST_POST_MESSAGE = "New Test Message Post";
	
	@Value("${local.server.port}")
	private int port;

	private URI url;
	private RestTemplate restTemplate;

	
	@Before
	public void setup(){
		
		this.restTemplate = new RestTemplate();
		try {
			this.url = new URI(new StringBuilder(HOST_NAME).append(port).append(CONTEXT).toString());
		} catch (URISyntaxException e) {
			Assert.fail("The url is poorly formatted ");
		}		
	}
	
	@Test
	public void testGetMessage(){
		ResponseEntity<GreetMessage> entity = restTemplate.getForEntity(url, GreetMessage.class);
		Assert.assertTrue(entity.getStatusCode().is2xxSuccessful());
	}
	
	@Test
	public void testSetMessage(){
		GreetMessage newGreet = new GreetMessage(TEST_POST_MESSAGE);
		ResponseEntity<GreetMessage> entity = restTemplate.postForEntity(url, newGreet, GreetMessage.class);
		Assert.assertTrue(entity.getStatusCode().is2xxSuccessful());
		Assert.assertEquals(entity.getBody().getMessageOfDay(), TEST_POST_MESSAGE);
	}
}
