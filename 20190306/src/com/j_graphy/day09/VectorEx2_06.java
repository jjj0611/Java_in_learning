package com.j_graphy.day09;

// Q. 2-6 MyVector 클래스의 객체배열 objArr에 저장된 모든 객체를
// 문자열로 이어서 반환하도록 toString()을 오버라이딩 하시오.

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
//	//	if ( this.size == 0 ) {
//	//		return true;
//	//	} else {
//	//		return false;
//	//	}
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
//	// 입력받은 인덱스 숫자의 objArr의 인덱스 반환	
//	Object get(int index) {
//		return objArr[index];
//	}
//	
//	// toString() 오버라이딩
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
//}

public class VectorEx2_06 {


}
