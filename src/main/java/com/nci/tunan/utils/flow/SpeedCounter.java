package com.nci.tunan.utils.flow;

import java.util.concurrent.atomic.AtomicLong;

public class SpeedCounter {

	// 起始时间
	private static long startTime = System.currentTimeMillis();
	// 时间间隔 ms
	private static long interval = 10;
	// 每秒限制数量
	private static long maxCount = 1000;
	//
	private static AtomicLong nowCount = new AtomicLong();

	// 计数判断
	private static long isAccess(int taskId, int nth) {
		long nowTime = System.currentTimeMillis();
		if (nowTime < startTime + interval) {
			long oldValue;
			long newValue;
			do {
				oldValue = nowCount.get();
				newValue = oldValue + 1;
			} while (!nowCount.compareAndSet(oldValue, oldValue + 1));
			if (newValue <= maxCount) {
				return newValue;
			} else {
				return -newValue;
			}
		} else {
			synchronized (SpeedCounter.class) {
				System.out.println("waiting in ........................" + taskId + ", nth: " + nth);
				if (nowTime > startTime + interval) { // 双重检验 防止重复初始化
					System.out.println("================init start .================= " + taskId + ", nth: " + nth);
					nowCount.set(0);
					startTime = nowTime;
				}
			}
			return 0;
		}
	}

	public static void main(String[] args) {
		for (int i = 1; i < 2; i++) {
			task(i);
		}
	}

	public static void task(final int taskId) {
		new Thread(new Runnable() {
			public void run() {
				try {
					for (int i = 1; i <= 100; i++) {
						long cnt;
						if ((cnt = isAccess(taskId, i)) > 0) {
							System.out.println("业务" + taskId + "顺利执行" + cnt);
						} else {
							System.out.println("业务" + taskId + "被丢弃" + cnt);
						}
					}
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
}
