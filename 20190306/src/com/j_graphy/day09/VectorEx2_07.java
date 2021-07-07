package com.j_graphy.day09;

// Q. 2-7 MyVector 클래스의 객체배열 objArr에서 지정된 객체가 저장되어 있는 위치(index)를
// 반환하는 int indexOf(Object obj)를 작성하시오.


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
//	// 나중에 빈 인덱스를 안생기게 만들면 그냥 objArr[0]만 검사해보면 됨
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
//				this.size++;
//			}
//		}
//	}
//	
//	// 입력받은 인덱스를 objArr의 인덱스에 넣어서 그대로 반환
//	Object get(int index) {
//		return objArr[index];
//	}
//
//	//toString() 오버라이딩
//	// 모든 객체를 문자열로 이어서 반환하도록 한다
//	// 모든 객체의 toString()을 이어
//	public String toString() {
//		String result = "";
//		for (int i = 0; i < objArr.length; i++) {
//			if ( objArr[i] != null) {
//				result += objArr[i].toString();
//			}
//		}
//		return result;
//	}
//	
//	// 객체를 받아서 objArr을 돌면서 객체를 찾고
//	// 객체를 찾으면 해당 인덱스 반환
//	// 객체를 못찾으면 -1 반한
//	int indexOf(Object obj) {
//		for (int i = 0; i < objArr.length; i++) {
//			if ( objArr[i] == obj )
//				return i;
//		}
//		
//		return -1;
//	}
//}

public class VectorEx2_07 {

}
