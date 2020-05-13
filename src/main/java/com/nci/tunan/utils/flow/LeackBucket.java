package com.nci.tunan.utils.flow;

public class LeackBucket {

	private static long startTime = System.currentTimeMillis();

	private static long speed = 20;

	private static long maxCount = 100;

	private static long nowCount = 0;
	static {
		System.out.println(startTime);
		
	}
	public static boolean isAccess() {
		long nowTime = System.currentTimeMillis();
		long outCount = (nowTime - startTime) * speed;
 		System.out.println("----相隔----"+ (nowTime - startTime));
		startTime = nowTime;
		nowCount = nowCount - outCount <= 0 ? 0 : nowCount - outCount;
		if (nowCount < maxCount) {
			nowCount++;
			return true;
		} else {
			return false;
		}

	}

	public static void main(String[] args) {
		for (int i = 0; i < 500; i++) {
			if (isAccess()) {
				System.out.println("业务顺利进行...");
			} else {
				System.out.println("业务被丢弃...");
			}
		}
		System.out.println(startTime);
	}
}
