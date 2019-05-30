package com.j_graphy.day01;

public class Variable_constant {

	public static void main(String[] args) {
		
		//두 변수의 값을 바꾸기
		int x = 10;
		int y = 20;
		
		//우유와 콜라가 담긴 두 컵의 내용을 바꾸기 위해선 '새로운 컵'이 필요
		int temp; //새로운 변수 하나를 지정하여 옮길 그릇의 역할을 하게 함
		temp = x;
		x  = y;
		y = temp;
		System.out.println("x : " + x + ", " + "y :" + y);
		
		
		//상수로 선언하는 변수는 자료형 앞에 final을 붙임
		final int WIDTH = 20;
		final int HEIGHT = 10;
		
		int triangleArea = (WIDTH * HEIGHT) / 2;
		int rectangleArea = (WIDTH * HEIGHT);
		System.out.println(triangleArea);
		System.out.println(rectangleArea);
		
		
	}
	
}
