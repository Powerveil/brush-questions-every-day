package com.power.study_2022_12.test;

public class Child extends Parent {
	public Child(){
		super(3);
	}
	public int compareTo(Object o) {
			// TODO Auto-generated method stub
			System.out.println("method of child");
//			Child o1 = (Child)o;
			return 1;
	}
}