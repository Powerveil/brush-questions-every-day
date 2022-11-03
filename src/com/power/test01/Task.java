package com.power.test01;

import java.util.Scanner;

public class Task {
	/********* Begin *********/
	public static void main(String[] args) throws MyException {
		Scanner sc = new Scanner(System.in);
		String username = sc.next();

		//判断用户名
		if (username.length() < 3) {
			throw new MyException("用户名小于三位Exception");
		}
		//Exception in thread "main"  用户名小于三位Exception at
		//Exception in thread "main"  用户名小于三位Exception at
		//Exception in thread "main" com.power.test01.MyException: 用户名小于三位at com.power.test01.Task.main(Task.java:13)
	}
}

class MyException extends Exception {
	public MyException(String message) {
		super(message);
	}
}