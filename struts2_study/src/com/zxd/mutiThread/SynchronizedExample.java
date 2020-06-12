package com.zxd.mutiThread;


	public class SynchronizedExample {

	    public void func1() {
	        synchronized (this) {
	            for (int i = 0; i < 10; i++) {
	            	try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	                System.out.print(i + " ");
	            }
	        }
	    }
	}

