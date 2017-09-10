package com.abc.app;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;

import com.abc.model.Token;
import com.abc.service.Consumer;

public class TokenConsumer implements Runnable {

	private BlockingQueue<Token> queue;
	
	private Consumer counterService;
	
//	private CounterService counterService;
	
	public TokenConsumer(BlockingQueue<Token> queue, Consumer  /*CounterService*/ counterService) {
		this.queue = queue;
		this.counterService = counterService;
	}
	
	@Override
	public void run() {
		processToken();
	}

	private void processToken() {
//		 try {
//		try {
//			Token token = queue.poll(10, TimeUnit.SECONDS);
//			counterService.serve(token);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		Iterator<Token> iterator = queue.iterator();
		while (iterator.hasNext()) {
			Token token = iterator.next();
			counterService.consume(token);
		}
		counterService.finishConsumption();
		
//			Thread.sleep(1000000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
