package com.jysoft.demos.jms;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import com.jysoft.demos.jms.simple.NotifyMessageListener;
import com.jysoft.demos.jms.simple.NotifyMessageProducer;
import com.jysoft.entity.User;
import org.springside.modules.test.category.UnStable;
import org.springside.modules.test.log.Log4jMockAppender;
import org.springside.modules.test.spring.SpringContextTestCase;
import org.springside.modules.utils.Threads;

@Category(UnStable.class)
@DirtiesContext
@ContextConfiguration(locations = { "/applicationContext.xml", "/jms/applicationContext-jms-simple.xml" })
public class JmsSimpleTest extends SpringContextTestCase {

	@Autowired
	private NotifyMessageProducer notifyMessageProducer;

	@Test
	public void queueMessage() {
		Threads.sleep(1000);
		Log4jMockAppender appender = new Log4jMockAppender();
		appender.addToLogger(NotifyMessageListener.class);

		User user = new User();
		user.setName("calvin");
		user.setEmail("calvin@sringside.org.cn");

		notifyMessageProducer.sendQueue(user);
		logger.info("sended message");

		Threads.sleep(1000);
		assertEquals("UserName:calvin, Email:calvin@sringside.org.cn", appender.getFirstMessage());
	}

	@Test
	public void topicMessage() {
		Threads.sleep(1000);
		Log4jMockAppender appender = new Log4jMockAppender();
		appender.addToLogger(NotifyMessageListener.class);

		User user = new User();
		user.setName("calvin");
		user.setEmail("calvin@sringside.org.cn");

		notifyMessageProducer.sendTopic(user);
		logger.info("sended message");

		Threads.sleep(1000);
		assertEquals("UserName:calvin, Email:calvin@sringside.org.cn", appender.getFirstMessage());
	}
}
