package com.j_graphy.day04;

public class Test {

	public static void main(String[] args) {
		
		Rectangle rec = new Rectangle(0, 0);
		rec.p.x = 2;
		
		System.out.println(rec.p.x);
		
	}
	
}

class Point {
	
	int x;
	int y;
	
	Point (int x, int y ){
		this.x = x;
		this.y = y;
	}

}

class Rectangle {
	
	Point p;

	Rectangle(int x, int y){
		this.p = new Point(x, y);
	}
	
}
	
