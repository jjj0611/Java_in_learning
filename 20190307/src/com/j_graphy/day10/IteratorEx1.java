package com.j_graphy.day10;

import java.util.*;

public class IteratorEx1 {

	public static void main(String[] args) {
		
		ArrayList list = new ArrayList();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		
		Iterator it = list.iterator();
		
		Object obj;
		while(it.hasNext()) {
			obj = it.next();
			System.out.println(obj);
		}
		
	}
	
}
