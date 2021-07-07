package com.j_graphy.day03;

public class ArrayEx09 {

	public static void main(String[] args) {
		
		int[] code = {-3, 5, 7, -2, 11, 24, 31};
		int[] arr = new int[10];
		
		int j;
		for (int i = 0; i < arr.length; i++) {
			j = (int) (Math.random() * code.length);
			arr[i] = code[j];
		}
		
		for ( int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ",");
		}
		
	}
	
}
