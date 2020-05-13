package com.nci.tunan.utils.flow;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreTest {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();
		final Semaphore semaphore = new Semaphore(5);
		for (int i = 0; i < 20; i++) {
			final int no = i;
			Runnable run = new Runnable(){

				@Override
				public void run() {
					try {
						semaphore.acquire(2);
						System.out.println("accesss : " + no);
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally {
						semaphore.release(2);
						System.out.println("*" + semaphore.availablePermits());
					}
				}
				
			};
			executor.execute(run);
		}
		executor.shutdown();
	}
}
