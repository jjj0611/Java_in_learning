package com.j_graphy.day08;

import java.util.*;

class Circle implements Cloneable {
	
	Point p;
	double r;
	
	Circle() {
		this(new Point(0, 0), 1.0);
	}
	
	Circle(Point p, double r) {
		this.p = p;
		this.r = r;
	}
	
	public Circle shallowCopy() {
		Object obj = null;
		
		try {
			obj = super.clone();
		} catch ( CloneNotSupportedException e ) {}
		
		return (Circle) obj;
	}
	
	public Circle deepCopy() {
		Object obj = null;
		
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException e) {}
		
		Circle c = (Circle) obj;
		c.p = new Point(this.p.x, this.p.y);
		
		return c;
	}
	
	public Circle clone() {
		Circle c = new Circle();
		c.p.x = this.p.x;
		c.p.x = this.p.y;
		c.r = this.r;
		
		return c;
		
	}
	
	public String toString() {
		return "[p=" + p + ", r= " + r + "]";
	}
	
}

class Point {
	int x;
	int y;
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}

public class ShallowDeepCopy {

	public static void main(String[] args) {
		
		Circle c1 = new Circle(new Point(1, 1), 2.0);
		Circle c2 = c1.shallowCopy();
		Circle c3 = c1.deepCopy();
		
		System.out.println("c1 = " + c1);
		System.out.println("c2 = " + c2);
		System.out.println("c3 = " + c3);
		
		c1.p.x = 9;
		c1.p.y = 9;
		
		System.out.println("= c1의 변경 후 =");
		System.out.println("c1 = " + c1);
		System.out.println("c2 = " + c2);
		System.out.println("c3 = " + c3);
		
	}
	
}
