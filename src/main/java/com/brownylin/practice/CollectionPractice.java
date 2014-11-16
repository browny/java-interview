package com.brownylin.practice;

import java.util.concurrent.BlockingQueue;
import javax.inject.Inject;

public class CollectionPractice
{
	@Inject
	public CollectionPractice() {}

	public static class Producer implements Runnable
	{
		private BlockingQueue<Message> queue;

		public Producer(BlockingQueue<Message> q)
		{
			this.queue = q;
		}

		@Override
		public void run()
		{
			// produce messages
			for (int i = 0; i < 100; i++) {
				Message msg = new Message("" + i);
				try {
					Thread.sleep(i);
					queue.put(msg);
					System.out.println("Produced " + msg.getMsg());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			// adding exit message
			Message msg = new Message("exit");
			try {
				queue.put(msg);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public static class Consumer implements Runnable
	{

		private BlockingQueue<Message> queue;

		public Consumer(BlockingQueue<Message> q)
		{
			this.queue = q;
		}

		@Override
		public void run()
		{
			try {
				Message msg;
				// consuming messages until exit message is received
				while ((msg = queue.take()).getMsg() != "exit") {
					Thread.sleep(10);
					System.out.println("Consumed " + msg.getMsg());
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static class Message
	{
		private String msg;

		public Message(String str)
		{
			this.msg = str;
		}

		public String getMsg()
		{
			return msg;
		}

	}
}
