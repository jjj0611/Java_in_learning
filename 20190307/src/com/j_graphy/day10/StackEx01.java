package com.j_graphy.day10;

import java.util.Stack;

public class StackEx01 {

	public static Stack back = new Stack();
	public static Stack forward = new Stack();
	
	public static void main(String[] args) {
		
		goURL("1. 네이버");
		goURL("2. 야후");
		goURL("3. 네이버");
		goURL("4. 다음");
		
		printStatus();
		
		goBack();
		System.out.println("= 뒤로 가기 버튼을 누른 후 = ");
		printStatus();
		
		goBack();
		System.out.println("= 뒤로 가기 버튼을 누른 후 = ");
		printStatus();
		
		goForward();
		System.out.println("= 앞으로 가기 버튼을 누른 후 = ");
		printStatus();
		
		goURL("codechobo.com");
		System.out.println("= 새로운 주소로 이동 후 = ");
		printStatus();
		
	}
	
	public static void printStatus() {
		System.out.println("back : " + back);
		System.out.println("forward : " + forward);
		System.out.println("현재 화면은 '" + back.peek() + "' 입니다.");		// 현재 페이지는 항상 back의 가장 마지막
		System.out.println();
	}
	
	public static void goURL(String url) {
		back.push(url);								// 입력받은 url을 back에 스택 구조로 하나씩 쌓아 올림
		if(!forward.empty())						// forward가 비어 있지 않으면
			forward.clear();						// forward 스택 클리어 -> 새로운 페이지로 이동하는 것이기 때문에 forward에 데이터 하나도 없어야 함
	}
	
	public static void goForward() {
		if(!forward.empty())						// forward가 비어있지 않으면
			back.push(forward.pop());				// forward에서 제거한 마지막 값을 back에 마지막으로 넣어줌
	}
	
	public static void goBack() {
		if(!back.empty())							// 뒤로 가기 눌렀을 때, back이 비어있지 않다면
			forward.push(back.pop());				// 백에 있는 것을 포워드에 넣어줌
	}
}
