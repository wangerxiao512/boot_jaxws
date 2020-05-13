package com.nci.tunan.utils.flow;

import com.google.common.util.concurrent.RateLimiter;

public class LimiterDemo {

	public static void main(String[] args) {
		RateLimiter limiter = RateLimiter.create(1);
		for (int i = 1; i < 10; i = i + 2) {
			double waitTime = limiter.acquire(i);
			System.out.println("cutTime = " + System.currentTimeMillis() + " acq:" + i + " waitTime:" + waitTime);
		}
	}
}
