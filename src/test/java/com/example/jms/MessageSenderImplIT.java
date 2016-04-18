package com.example.jms;

import static org.junit.Assert.*;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:testApplicationContext.xml" })
public class MessageSenderImplIT {
	
	@Autowired
	private MessageSender messageSender;
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Test
	public void testSendMessage() throws Exception {
		assertNotNull(messageSender);
		assertNotNull(jmsTemplate);
		messageSender.sendMessage("Test Message");
		Message message = jmsTemplate.receive("queueDestination");
		assertNotNull(message);
		assertEquals("Test Message", ((TextMessage)message).getText());
	}

}
