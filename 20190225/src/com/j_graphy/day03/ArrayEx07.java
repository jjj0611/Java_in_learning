package com.j_graphy.day03;

public class ArrayEx07 {

	public static void main(String[] args) {
		
		int[] numArr = new int[10];
		
		for (int i = 0; i < numArr.length; i++) {
			numArr[i] = (int) (Math.random() * 10);
			System.out.print(numArr[i]);
		}
		
		System.out.println();
		int tmp;
		int j;
		
		for (int i = 0; i < 100; i++) {
			j = (int) (Math.random() * 10);
			tmp = numArr[0];
			numArr[0] = numArr[j];
			numArr[j] = tmp;
			
		}
		
		for (int i = 0; i < numArr.length; i++) {
			System.out.print(numArr[i]);
		}
		
	}
	
}
