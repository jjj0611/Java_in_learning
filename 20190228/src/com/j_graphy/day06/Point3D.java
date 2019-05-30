package com.j_graphy.day06;

public class Point3D extends Point {

	int z;
	
	Point3D() {
		this(1, 1, 1);
	}

	Point3D(int x, int y, int z){
		super(x, y);
		this.z = z;
	}
	
	public String toString() {
		
		return super.toString() + ", z : " + this.z;
	}
	
//	public int sum() {
//		
//		return this.x + this.y + this.z;
//	}
}
