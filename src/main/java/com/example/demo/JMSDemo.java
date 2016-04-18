package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.jms.MessageSender;

public class JMSDemo {

	private static final Logger logger = LoggerFactory.getLogger(JMSDemo.class);

	public static void main(String[] args) {

		logger.info("Starting ..");
		
		try(ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml")) {
			MessageSender messageSender = context.getBean("messageSenderImpl", MessageSender.class);
			messageSender.sendMessage("Test Message !!!");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
