package com.j_graphy.day09;

// Q. 2-8 MyVector 클래스의 객체배열 objArr에서 지정된 객체를 삭제하는
// boolean remove(Obejct obj)를 작성하시오(indexOf()를 이용할 것)

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
//	// objArr[0]만 검사해보면 됨
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
//	
//	// objArr에서 지정된 객체를 삭제
//	// indexOf()를 이용
//	// 찾은 인덱스부터 다음 인덱스와 교체하는 것을 size-1까지 함
//	// 만약 반환된 인덱스 값이 가장 마지막이라면 교체하는 작업 없애도 됨
//	// 그리고 마지막 인덱스 값 null 및 사이즈 줄이기
//	boolean remove(Object obj) {
//		int index = indexOf(obj);
//		if ( index != - 1 ) {
//			
//			if ( index != size-1) {
//				for (int i = index; i < size - 1; i++) {
//					objArr[i] = objArr[i+1];
//				}	
//			}
//			
//			objArr[size-1] = null;
//			size--;
//			
//			return true;
//			
//		} else {
//			System.out.println("존재하지 않는 값입니다.");
//			return false;
//			
//		}
//	}
//}

public class VectorEx2_08 {

	
}
