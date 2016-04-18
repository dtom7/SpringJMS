package com.example.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;
import javax.jms.MessageListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service(value="messageListenerImpl")
public class MessageListenerImpl implements MessageListener {
	
	private static final Logger logger = LoggerFactory.getLogger(MessageListenerImpl.class);

	public void onMessage(Message message) {
		
		try {
			logger.info("Message received:- " + ((TextMessage)message).getText());
		} catch (JMSException e) {
			throw new RuntimeException(e);
		}
	}

}
