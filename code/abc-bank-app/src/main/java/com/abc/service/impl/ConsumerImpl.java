package com.abc.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.model.Token;
import com.abc.service.Consumer;
import com.abc.service.CounterService;
import com.abc.token.TokenProcessor;

@Service
public class ConsumerImpl implements Consumer {
	
	@Autowired
	private CounterService counterService;	

	private BlockingQueue<Token> itemQueue = new LinkedBlockingQueue<Token>();
	private ExecutorService executorService = Executors.newCachedThreadPool();

	private volatile boolean shutdownCalled = false;
	private List<TokenProcessor> jobList = new LinkedList<TokenProcessor>();

	public ConsumerImpl() {
		for (int i = 0; i < 10; i++) {
			TokenProcessor jobThread = new TokenProcessor(itemQueue, counterService);

			jobList.add(jobThread);
			executorService.submit(jobThread);
		}
	}

	@Override
	public boolean consume(Token j) {
		if (!shutdownCalled) {
			try {
				itemQueue.put(j);
			} catch (InterruptedException ie) {
				Thread.currentThread().interrupt();
				return false;
			}
			return true;
		} else {
			return false;
		}
	}

	public void finishConsumption() {
		for (TokenProcessor j : jobList) {
			j.cancelExecution();
		}

		executorService.shutdown();
	}


}
