package com.javaex.ex01;

public class ThreadApp {
	public static void main(String[] args) throws Exception{
		
		
		
		DigitThread t = new DigitThread();
		
		t.start();
		
		for(char ch = 'A';ch <= 'Z';ch++){
			System.out.print(ch);
			Thread.sleep(1000);
		}
	}
}
