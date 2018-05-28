package com.hcl;

public class E {
	public static void main(String[] args) {
     Thread t=new Thread();
     t.start();
     t.setPriority(10);
     System.out.println(t.getPriority());
     E e=new E();  
	}
	public void m(Exception ex) {
		
	}
public void m(ArithmeticException ex) {
		
	}
}
