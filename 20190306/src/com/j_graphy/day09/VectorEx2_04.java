package com.j_graphy.day09;

// Q. 2-4 MyVector 클래스의 객체 배열 objArr에 객체를 추가하는 메서드
// void add(Object obj)를 작성하라

//class MyVector {
//	
//	Object[] objArr;
//	int capacity;
//	int size;
//	
//	MyVector() {
//		this(16);
//	}
//	
//	MyVector (int capacity) {
//		if ( capacity < 0)
//			throw new IllegalArgumentException("유효하지 않은 값입니다. : " + capacity);
//		this.capacity = capacity;
//		objArr = new Object[this.capacity];
//	}
//	
//	int size() {
//		return this.size;
//	}
//	 
//	int capacity() {
//		return this.capacity;
//	}
//	
//	// size로 체크하는 방법 1
//	// objArr을 돌면서 체크해보고 null이 아닌 순간 false로 바꾸고 반환
// 	// 나중에 빈 인덱스를 안생기게 만들면 그냥 objArr[0]만 검사해보면 됨
//	boolean isEmpty() {
////		if ( this.size == 0 ) {
////			return true;
////		} else {
////			return false;
////		}
//		boolean isEmpty = true;
//		for (int i = 0; i < objArr.length; i++) {
//			if ( objArr[i] != null) {
//				isEmpty = false;
//				break;
//			}
//		}
//		
//		return isEmpty;
//		
//	}
//	
//	// objArr을 돌면서 null을 만나면 추가	
//	void add(Object obj) {
//		for (int i = 0; i < objArr.length; i++) {
//			if ( objArr[i] == null) {
//				objArr[i] = obj;
//			}
//		}
//	}
//	
//}

public class VectorEx2_04 {

}
