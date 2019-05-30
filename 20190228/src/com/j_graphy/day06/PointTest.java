package com.j_graphy.day06;

public class PointTest {
	
	public static void main(String[] args) {
		
		Point p1 = new Point();
		
		p1.x = 3;
		p1.y = 5;
		System.out.println(p1.x);
		System.out.println(p1.y);
		System.out.println(p1);
		
		Point p2 = new Point(4, 5);				// Point(int x, int y) 생성자
		System.out.println(p2);
		
		Point p3 = new Point();					// Point() 생성자 1, 1초기화
		System.out.println(p3);
		
		double distance;
		
		distance = Point.getDistance(p1, p2);	// staticMethod
		System.out.println(distance);
		
		distance = p1.getDistance(p3);			// instanceMethod
		System.out.println(distance);
		
		Point p4 = new Point(p1);
		String p5 = "Hello world";
		System.out.println(p1.equals(p5));		// equals 비교, Point 클래스가 아닐 때
		System.out.println(p1.equals(p2));		// PointClass는 맞지만 x, y가 다를때
		System.out.println(p1.equals(p4));		// PointClass이면서 x, y가 같을 때
		
		Point3D p6 = new Point3D();				// 3D 기본 생성자 1, 1, 1 초기화
		System.out.println(p6);
		
		Point3D p7 = new Point3D(1, 4, 7);		// 3D(x, y, z) 생성자
		System.out.println(p7);

		Point p8 = new Point3D();				// Point 리모콘으로 Point3D 객체 다뤄보기
		System.out.println(p8);					// 얘는 오버라이딩 돼서 그냥 나옴
//		System.out.println(p8.sum());			// 얘는 Point 리모콘에 없는 내용이라 에러
		
		Point3D p9 = new Point3D(1, 4, 8);		// 상속된 equals 사용해보기
		System.out.println(p7.equals(p9));		// x와 y만 비교하기 때문에 앞 두개만 맞으면 true
		
		
		
	}
}
