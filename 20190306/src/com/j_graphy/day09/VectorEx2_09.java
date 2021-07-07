package com.j_graphy.day09;

// Object 배열 objArr을 인스턴스 변수로 갖는 MyVector클래스 선언
class MyVector{
	
	Object[] objArr;
	int size;

	// MyVector(int capacity)와 MyVector(capacity = 16)의 기본 생성자
	MyVector (int capacity) {
		if ( capacity < 0)
			throw new IllegalArgumentException("유효하지 않은 값입니다. : " + capacity);
		objArr = new Object[capacity];
	}
	
	MyVector () {
		this(16);
	}
	
	// 객체배열에 저장된 객체의 개수를 저장하기 위한 인스턴스 변수 size를 추가
	// 이 size를 반환하는 size() 메서드
	int size() {
		return this.size;
	}
	
	// objArr의 길이를 반환하는 capacity()
	int capacity() {
		return objArr.length;
	}
	
	// 객체 배열이 비었는지 확인하는 isEmpty()
	// 언제 비어있는가?
	// null이 있을 때?? 아니
	// size의 값이 0일때
	// 왜냐하면 우리는 size라는 인스턴스 변수를 객체배열에 저장된 객체의 개수라고 정의했기 때문에
	// 이 size가 0이라는 것은 객체배열에 저장된 객체의 개수가 0개다라는 의미
	boolean isEmpty() {
		return size == 0;
//		if ( size == 0 )
//			return true;
//		else
//			return false;
	}
	
	// MyVector클래스의 객체 배열 objArr에 객체를 추가하는 메서드
	// void add(Object obj)를 작성
	// 어디에 추가할거야?
	// null을 만났을 때 추가하면 그 널이 내가 넣은 데이터일 수 있지
	// 그럼 결국에 size수 만큼에 저장하면 되지
	// 그리고 size를 높여 나가면 되지
	// 근데 문제는 size가 capacity와 같아질 때야
	void add(Object obj) {
		if ( size == capacity()) {
			// size는 capacity보다 클 일이 절대 없다.
			// 기본 생성시에 capacity를 0으로 설정한다고 해도
			// 결국 size도 0으로 설정이 되기 때문에(기본값 초기화)
			// size와 capacity가 같아지는 지점에서 사이즈를 키워주면 됨
			// 복사 한뒤에 추가
			// capacity는 두배로 늘어나야 함
			Object[] tmp = new Object[capacity() * 2];
			System.arraycopy(objArr, 0, tmp, 0, size);
			this.objArr = tmp;
		} 
		
		// 그렇지 않으면 size가 1이라는 것은 0번째 인덱스에 데이터가 있고,
		// size가 2라는 것은 1번째 인덱스까지 데이터가 있다는 것이기 때문에
		// size를 인덱스로 하여 데이터를 추가하고, size를 1키워 줌.
		objArr[size++] = obj;
		
	}
	
	
	
	// objArr에서 인덱스 값을 넣으면 해당 인덱스의 객체 반환
	// 단순히 그냥 index를 넣으면 된다.
	Object get(int index) {
		if (index >= size || index < 0)
			throw new ArrayIndexOutOfBoundsException(index);
		
		return objArr[index];
	}
	
	// 객체 배열에 저장된 모든 객체를 문자열로 이어서 반환하는
	// toString()을 오버라이딩 하라
	// 저장된 객체이기 때문에 size만큼 반복하자
	public String toString() {
		String result = "";
		for (int i = 0; i < size; i++) {
			result += objArr[i].toString();
		}
		return result;
	}
	
	// obj 객체를 넣으면 그 객체가 위치한 인덱스를 반환하는 메서드
	// 위치하면 해당 인덱스를 반환하면 되는데
	// 만약 위치 하지 않으면? 즉, 입력한 인덱스가 없는 값이라면 -1 반환
	int indexOf(Object obj) {
		if (obj == null) {	
			for (int i = 0; i < size; i++) {
				if ( objArr[i] == null) 
					return i;
			}
		} else {
			for (int i = 0; i < size; i++) {
				if ( objArr[i].equals(obj)) 
					return i;
			}
		}
		return -1;
	}
	
	// 객체 배열 objArr에서 지정된 객체를 삭제하는
	// boolean remove(Object obj)를 작성하라
	// indexOf()를 이용하여
	// 일단 indexOf()를 이용하여 찾고자 하는 인덱스가 어디인지 확인
	boolean remove(Object obj) {
		int index = indexOf(obj);
		// index가 -1인 경우와 size-1인 경우를 나누자
		if (index == -1) return false;
		// size-1이 아니면 해당 인덱스부터 덮어쓰기
//		if (index != size - 1) {
//			for (int i = index; i < size - 1; i++) {
//				objArr[i] = objArr[i+1];
//			}
//		}
		System.arraycopy(objArr, index+1, objArr, index, size - index - 1);
		// index가 가장 마지막이든 가장 마지막이 아니든
		// 다 덮어 쓴 후에는 가장 마지막 값을 null로 바꾸고
		// size는 1 줄여야 함
		objArr[size - 1] = null;
		size--;
		return true;
	}
}

public class VectorEx2_09 {

	public static void main(String[] args) {
		
		MyVector v = new MyVector();
		MyVector v2 = new MyVector(21);
		
		// 생성자 테스트
		System.out.println(v.capacity() + " & " + v2.capacity());
	
		// size(), capacity() 메서드
		System.out.println("v.size() : " + v.size() + " &  v2.size() : " + v2.size());
		System.out.println("v.capacity() : " + v.capacity() + " &  v2.capacity() : " + v2.capacity());
		
		// isEmpty() 메서드 테스트
		System.out.println("v.isEmpty() : " + v.isEmpty() + " & v2.isEmpty() : " + v2.isEmpty());
		
		// add() 메서드 테스트
		for (int i = 0; i < 20; i++) {
			v.add(i + "");
			v2.add(i+2 + "");
		}
		// v의 capacity는 16이었고 20번을 반복하기 때문에 capacity를 32로 증가시키고 값을 추가
		// v2의 capacity는 21이었고 20번을 반복하기 때문에 capacity는 그대로 20
		// 비어있다는 것은 false가 나올 것
		System.out.println("v.size() : " + v.size() + " &  v2.size() : " + v2.size());
		System.out.println("v.capacity() : " + v.capacity() + " &  v2.capacity() : " + v2.capacity());
		System.out.println("v.isEmpty() : " + v.isEmpty() + " & v2.isEmpty() : " + v2.isEmpty());
	
		// add() 메서드 테스트 2
		for (int i = 0; i < 13; i++) {
			v.add(i * 3 + "");
			v2.add(i * 4 + "");
		}
		
		//v의 capacity는 32로 변했고 size는 20이었는데 총 13번 반복하고 size가 32가 되었을 때
		// capacity를 2배로 늘려서 64가 될 것이고, 사이즈는 33이 될 것이다.
		// v2의 capacity는 21이었고 size가 20이었는데 총 13번 반복하기 때문에 size가 21이 된 후
		// 22번째 추가할 때 capacity는 42로 늘어나고, 사이즈는 33이 될 것이다.
		System.out.println("v.size() : " + v.size() + " &  v2.size() : " + v2.size());
		System.out.println("v.capacity() : " + v.capacity() + " &  v2.capacity() : " + v2.capacity());
		
		// get() 메서드 테스트
		// 지금 v에는 "0", "1", ... "19"와 "0", "3", "6", ... "36"
		// v2에는 "2", "3", "4", ... "21"와 "0", "4", "8", ..., "48"이 추가 되어 있을 것
		// v에서 인덱스 19를 넣으면 "19"를 반환, 인덱스 32를 넣으면 "36"을 반환
		// v2에서 인덱스 17을 넣으면 "19"를 반환, 인덱스 31을 넣으면 "44"를 반환
		System.out.println("v.get(19) : " + v.get(19) + " & v.get (32) : " + v.get(32));
		System.out.println("v2.get(17) : " + v2.get(17) + " & v2.get (31) : " + v2.get(31));
		
		// toString() 오버라이딩 테스트
		System.out.println(v.toString());
		System.out.println(v2.toString());
		
		// indexOf() 메서드 테스트
		// v.indexOf(18)은 인덱스 18 반환, "33"은 인덱스 31반환
		// v에 18을 넣으면 인덱스 16 반환, "36"은 인덱스 29 반환
		System.out.println("v.indexOf(\"18\") : " + v.indexOf("18") + " & v.indexOf(\"33\") : " + v.indexOf("33"));
		System.out.println("v2.indexOf(\"18\") : " + v2.indexOf("18") + " & v2.indexOf(\"36\") : " + v2.indexOf("36"));
		// 없는 인덱스 판단
		System.out.println("v.indexOf(\"200\") : " + v.indexOf("200") + " & v.indexOf(\"300\") : " + v.indexOf("300"));
		System.out.println("v2.indexOf(\"100\") : " + v2.indexOf("100") + " & v2.indexOf(\"400\") : " + v2.indexOf("400"));
		
		//remove() 메서드 테스트 다 트루 트루 나와야 함
		System.out.println("v.remove(\"18\") : " + v.remove("18") + " & v.remove(\"33\") : " + v.remove("33") );
		System.out.println("v2.remove(\"18\") : " + v2.remove("18") + " & v2.remove(\"36\") : " + v2.remove("36") );
		//여긴 다 false false
		System.out.println("v.remove(\"200\") : " + v.remove("200") + " & v.indexOf(\"300\") : " + v.remove("300"));
		System.out.println("v2.remove(\"100\") : " + v2.remove("100") + " & v2.indexOf(\"400\") : " + v2.remove("400"));
	
		// 위에서 지워지기 때문에 v의 사이즈는 31이 될 것이고, v2의 사이즈도 31이 될 것이다.
		System.out.println("v.size() : " + v.size() + " &  v2.size() : " + v2.size());
		System.out.println("v.capacity() : " + v.capacity() + " &  v2.capacity() : " + v2.capacity());
		
		// 다시 오버라이딩 하면 v에서는 중간에 첫번째 18이 빠져있고, 33이 빠져있게 된다
		// v2에서는 첫번째 18과 36이 빠지게 된다.
		System.out.println(v.toString());
		System.out.println(v2.toString());
		
		System.out.println(v.indexOf(null));
		
		v.add(1);
		System.out.println(v.get(v.size() - 1));
		System.out.println(v.indexOf(1));
		
		MyVector v3 = new MyVector();
		for ( int i = 0; i < 10; i++) {
			v3.add(i+"");
		}
		v3.remove("7");
		System.out.println(v3.toString());
		
		MyVector v4 = new MyVector();
		System.out.println(v4.toString());
	}
}
