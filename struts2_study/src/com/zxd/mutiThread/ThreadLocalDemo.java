package com.zxd.mutiThread;

import java.util.concurrent.CountDownLatch;

public class ThreadLocalDemo {

	public static void main(String[] args) throws InterruptedException {
	
		int threads = 3;
		CountDownLatch countDownLatch = new CountDownLatch(threads);
		InnerClass innerClass = new InnerClass();
		for (int i = 1; i <= threads; i++) {
			new Thread(() -> {
				for (int j = 0; j < 4; j++) {
					innerClass.add(String.valueOf(j));
					
					innerClass.print();
					
				}
				innerClass.set("hello world");
				countDownLatch.countDown();
			}, "thread - " + i).start();
		}
		countDownLatch.await();

	}

	private static class InnerClass {

		public void add(String newStr) {
			StringBuilder str = Counter.counter.get();
			Counter.counter.set(str.append(newStr));
		}
		public void print() {
			//Thread.currentThread()为内部静态方法，直接调用
			System.out.printf("Thread name:%s , ThreadLocal hashcode:%s, Instance hashcode:%s, Value:%s\n",
					Thread.currentThread().getName(), Counter.counter.hashCode(), Counter.counter.get().hashCode(),
					Counter.counter.get().toString());
			
		}
    
		public void set(String words) {
			Counter.counter.set(new StringBuilder(words));
			System.out.printf("Set, Thread name:%s , ThreadLocal hashcode:%s,  Instance hashcode:%s, Value:%s\n",
					Thread.currentThread().getName(), Counter.counter.hashCode(), Counter.counter.get().hashCode(),
					Counter.counter.get().toString());
		}
	}
		
	private static class Counter {
		//threadlocal要用private static修饰
		//ThreadLocal 的 get() 方法读取 StringBuidler 实例，也可通过 set(T t) 方法设置 StringBuilder。
		private static ThreadLocal<StringBuilder> counter = new ThreadLocal<StringBuilder>() {
			@Override
			protected StringBuilder initialValue() {
				return new StringBuilder();
			}
		};

	}

}