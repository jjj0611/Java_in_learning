package com.j_graphy.day06;

public class Point {
	int x;
	int y;
	
	Point() {
		this(1, 1);
	}
	
	Point(Point p) {
		this(p.x, p.y);				// 복사용 추가해서 만들어보기
	}
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return "x : " + this.x + ", y : " + this.y;
	}

	static double getDistance(Point p1, Point p2) {
		double result;
		
		result = Math.sqrt( (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y) );
		
		return result;
	}
	
	double getDistance(Point p) {
		double result;
		
		result = getDistance(this, p);
		
		return result;
	}
	
	public boolean equals(Object obj) {			// 즉, 매개변수로 Object 클래스를 받는다는 것
		if ( obj instanceof Point ) {			// extends Object하는 모든 클래스를 매개변수로 넣을 수 있다는 것
												// 그리고 그것이 Point의 조상 
			Point p = (Point) obj;
			return (this.x == p.x && this.y == p.y);
			
		} else {
				return false;
		}
		
	}
}
