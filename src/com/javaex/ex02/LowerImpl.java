package com.javaex.ex02;

public class LowerImpl extends Thread {

	@Override
	public void run() {
		for(int cnt = 0; cnt < 10;cnt++) {
			System.out.println(cnt);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}

	
}
