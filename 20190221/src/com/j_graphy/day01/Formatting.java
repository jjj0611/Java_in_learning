package com.j_graphy.day01;

public class Formatting {

	public static void main(String[] args) {

		
		// 우리가 원하는 '형식'으로 출력하고 싶을 때가 있다.
		
		int age = 20;
		System.out.printf("age : %d%n", age); // 'age : 숫자'의 형식으로 출력 가능. println 대신 printf 사용
		
		System.out.printf("[%5d]%n", 10);		// 5자리에 맞춰서 오른쪽 정렬
		System.out.printf("[%-5d]%n", 10);		// 5자리에 맞춰서 왼쪽 정렬
		System.out.printf("[%05d]%n", 10);		// 5자리에 맞춰서 오른쪽 정렬후 빈자리 0으로 채움
		
		System.out.printf("[%10s]%n", "Hello");		// 10자리에 맞춰서 오른쪽 정렬
		System.out.printf("[%-10s]%n", "Hello");	// 10자리에 맞춰서 왼쪽 정렬
		System.out.printf("[%10.8s]%n", "Hello World");		// 10자리에 맞춰서 8자리까지만 출력 후 오른쪽 정렬
		
		
	}

}
