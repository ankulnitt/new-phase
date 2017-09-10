package com.abc.token;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import com.abc.model.Token;
import com.abc.service.CounterService;

/**
 * 
 * @author ankul1874
 * @purpose This class is responsible for processing tokens. 
 */
public class TokenProcessor implements Runnable {

	/**
	 * Queue of tokens.
	 */
	private BlockingQueue<Token> jobQueue;
	/**
	 * flag to find out when to stop processing tokens
	 */
	private volatile boolean keepProcessing;
	
	/**
	 * Counter service to provide service to token.
	 */
	private CounterService counterService;

	/**
	 * 
	 * @param queue
	 *            {@link BlockingQueue} Tokens queue.
	 * @param counterService
	 *            CounterService.
	 */
	public TokenProcessor(BlockingQueue<Token> queue, CounterService counterService) {
		jobQueue = queue;
		keepProcessing = true;
		this.counterService = counterService;
	}

	@Override
	public void run() {
		while (keepProcessing || !jobQueue.isEmpty()) {
			try {
				//getting token from queue.
				Token j = jobQueue.poll(10, TimeUnit.SECONDS);

				//processing token.
				if (j != null) {
					counterService.serve(j);
				}
			} catch (InterruptedException ie) {
				Thread.currentThread().interrupt();
				return;
			}
		}

	}

	/**
	 * Method to cancel token processing.
	 */
	public void cancelExecution() {
		this.keepProcessing = false;
	}

}
