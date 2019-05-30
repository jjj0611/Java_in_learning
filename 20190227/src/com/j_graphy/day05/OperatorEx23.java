package com.j_graphy.day05;

class Point extends Object {
	int x;
	int y;
}

public class OperatorEx23 {

	public static void main(String[] args) {
		
		
		//Object 클래스를 상속하는 것을 보기 위함
		// toString이나 equals가 없어도 사용 가능
		Point p = new Point();
		Point p2 = new Point();
		
		System.out.println(p.toString());
		System.out.println(p.equals(p2));
		
	}
	
}
