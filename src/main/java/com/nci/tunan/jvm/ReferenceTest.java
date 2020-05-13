package com.nci.tunan.jvm;

import java.lang.ref.SoftReference;
import java.util.concurrent.TimeUnit;

import org.apache.tomcat.util.collections.SynchronizedStack;

public class ReferenceTest {

	private String id;
	private String name;
	
	public ReferenceTest(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public ReferenceTest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public static void main(String[] args) throws InterruptedException {
		ReferenceTest referenceTest = new ReferenceTest();
		System.gc();
		TimeUnit.SECONDS.sleep(1);
		System.out.println(referenceTest == null);
		SoftReference<ReferenceTest> aa = new SoftReference<>(new ReferenceTest("1","张三"));
		System.out.println(aa.get());
		
		TimeUnit.HOURS.sleep(1);
	}
	@Override
	public String toString() {
		return "ReferenceTest [id=" + id + ", name=" + name + "]";
	}
	
}
