package com.pandi.longpooling;

import model.DataModel;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


class LongpoolingApplicationTests {

	public static void main(String[] args) {
		DataModel eventQueue = new DataModel();

		// Consumer Thread: Poll for events
		new Thread(() -> {
			try {
				System.out.println("Waiting for an event...");
				String event = eventQueue.getData(); // Blocks here until an event is available
				System.out.println("Received event: " + event);
			} catch (Exception e) {
				Thread.currentThread().interrupt();
				System.out.println("Thread interrupted");
			}
		}).start();

		// Producer Thread: Add an event after 5 seconds
		new Thread(() -> {
			try {
				Thread.sleep(5000); // Simulate delay
				String event = "pandi added";
				eventQueue.addData(event);
				System.out.println("Event added to the queue");
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}).start();
	}


}
