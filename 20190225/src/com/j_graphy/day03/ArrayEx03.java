package com.j_graphy.day03;

public class ArrayEx03 {

	public static void main(String[] args) {
		
		
		
		// 배열의 복사
		// 복사를 하는 이유는 보통 배열의 길이를 더 늘리고 싶기 때문
		// 더 긴 배열을 먼저 생성하고,
		// 하나씩 값을 넣어간다.
		// 이때 for 문으로 접근하기 때문에 배열의 요소에 하나씩 접근하게 된다.
		
		int[] arr = new int[5];
		
		for (int i = 0; i < arr.length; i++)
			arr[i] = i + 1;
		
		System.out.println("변경 전 - arr.length : " + arr.length);
		for (int i = 0; i < arr.length; i++)
			System.out.println("arr [" + i + "] = " + arr[i]);
		
		int[] tmp = new int[arr.length * 2];
		
		for (int i = 0; i < arr.length; i++)
			tmp[i] = arr[i];
		
		arr = tmp;
		
		System.out.println("변경 후 - arr.length : " + arr.length);
		
		for (int i = 0; i < arr.length; i++)
			System.out.println("arr [" + i + "] = " + arr[i]);
		
		
	}
	

}
