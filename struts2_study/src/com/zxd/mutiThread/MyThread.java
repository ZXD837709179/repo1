package com.zxd.mutiThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;


	public  class MyThread extends Thread {
		public void run() {
			ReentrantLock lock = new ReentrantLock();
			lock.lock();
				try {
					Thread.sleep(300);
					for (int i = 0; i < 10; i++) {
						System.out.print(i + " ");
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					lock.unlock();
				}
				
			
		}
	

	public static void main(String[] args) throws InterruptedException {
		ExecutorService pool = Executors.newCachedThreadPool();
		MyThread myThread = new MyThread();
		MyThread myThread2 = new MyThread();

		
		
		  pool.execute(()->myThread.run()); 
		  pool.execute(()->myThread2.run());
		 
		 

		
		  //不同的对象，两个之间没有关系 
//		  myThread.start(); 
//		  myThread2.start();
		 

	}
}
