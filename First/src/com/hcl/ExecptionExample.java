package com.hcl;

public class ExecptionExample {
	public void show() {
		try {
			throw new NullPointerException();
			// return;
		} catch (Exception ex) {
			System.out.println("Hello from  catch block");
			return;
		} finally {
			System.out.println("Hello from  finally block");
		}
	}

	public static void main(String[] args) {
		ExecptionExample ex = new ExecptionExample();
		ex.show();
	}

}
