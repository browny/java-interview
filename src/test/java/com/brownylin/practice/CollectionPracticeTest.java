package com.brownylin.practice;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import com.brownylin.leetcode.ArrayProcessingTest;
import com.brownylin.service.DaggerModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class CollectionPracticeTest
{
	private static final Logger logger = LoggerFactory.getLogger(ArrayProcessingTest.class);

	private CollectionPractice tested = DaggerModule.getObjectGraph().get(CollectionPractice.class);


	/**
	 * BlockingQueue example
	 */
	@Test
	public void blockingQueue()
	{
		//Creating BlockingQueue of size 10
		BlockingQueue<CollectionPractice.Message> queue = new ArrayBlockingQueue<>(10);
		CollectionPractice.Producer producer = new CollectionPractice.Producer(queue);
		CollectionPractice.Consumer consumer = new CollectionPractice.Consumer(queue);

		//starting producer to produce messages in queue
		new Thread(producer).start();

		//starting consumer to consume messages from queue
		new Thread(consumer).start();

		System.out.println("Producer and Consumer has been started");
	}
	// :~)
}
