package com.j_graphy.day08;

interface Hello {
	abstract int mul(int a, int b);
}

class Cal {
	public static int add(int a, int b) {
		return a + b;
	}
}

class CalMul extends Cal implements Hello {

	@Override
	public int mul(int a, int b) {
		// TODO Auto-generated method stub
		return a * b;
	}
	
}

public class InterfaceTest {
	
	public static void main(String[] args) {
		
		CalMul c = new CalMul();
		System.out.println(CalMul.add(10,  20));
		System.out.println(c.mul(10, 20));
		
	}
}
