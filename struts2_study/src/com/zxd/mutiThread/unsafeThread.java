package com.zxd.mutiThread;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * ��ʾ���̲߳���ȫ����add��get��������������ÿ��ֻ��һ���߳̿��Ի�ã�����
 * @author Xudong Zhang
 *
 */
public class unsafeThread {
	public static class ThreadUnsafeExample {
	    	private int cnt = 0;
		    public  void add() {
		        synchronized (ThreadUnsafeExample.class) {
		        	cnt++;
				}
		    }
		    public int get() {
		        synchronized (ThreadUnsafeExample.class) {
		        	return cnt;
				}
		    }
		 
		     
	    
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		
      
		
	  int times = 1000;
	  ThreadUnsafeExample ex = new ThreadUnsafeExample();
	  CountDownLatch countDownLatch = new CountDownLatch(times);
	  ExecutorService executorService = Executors.newCachedThreadPool();
	  for (int q = 0; q < times; q++) {
		executorService.execute(()->{
			ex.add();
			countDownLatch.countDown();			
		});
	}
	  countDownLatch.await();
	  executorService.shutdown();
	  System.out.println(ex.get());
	  
	  
	}
}
