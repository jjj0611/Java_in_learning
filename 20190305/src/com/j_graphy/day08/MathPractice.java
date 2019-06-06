package com.j_graphy.day08;

public class MathPractice {

	public static void main(String[] args) {
		double sum1 = 0;
		double sum2 = 0;
		double sum3 = 0;
		
		for (int i = 0; i<= 10; i++) {
			double d = i + 0.5;
			double d2 = Math.round(d);
			double d3 = Math.rint(d);
			System.out.printf("%3.1f\t%3d\t%3.1f%n", d, Math.round(d), Math.rint(d));
			
			sum1+= d;
			sum2+= d2;
			sum3+= d3;
			
		}
		
		System.out.printf("%3.1f\t%3.1f\t%3.1f%n", sum1, sum2, sum3);
		
	}
	
}
