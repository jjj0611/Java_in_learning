package com.j_graphy.day09;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

// 테스트가 코드 안에서 더 길어도 됨다
// 이게 무슨 말이지?

class Card {}

class VectorEx2_09Test {

	MyVector v = new MyVector();		// 이렇게 셋업해도 된다
	
	@Test
	void sizeTest() {
		assertTrue(v.size() == 0);
		
		v.add("1");
		assertTrue(v.size() == 1);
		
		v.remove("2");
		assertTrue(v.size() == 1);
		
		v.remove("1");
		assertTrue(v.size() == 0);
		
	}
	
	@Test
	void capacityTest(){
		MyVector v3 = new MyVector(100);
		assertTrue(v3.capacity() == 100);
		
		MyVector v4 = new MyVector();
		assertTrue(v4.capacity() == 16);	
	}
	
//	@Before								// Before어노테이션은 테스트가 돌아가기 전에 딱 한번 실행되는 것
//	void setup() {
//		System.out.println("hihi");
//	}
//	
//	@After
//	void cleanup() {
//		// 테스트가 끝난 후에 수행할 작업을 넣는다.
//	}
	// 기본 생성자 테스트
	@Test
	void defaultInitializerTest() {
		assertTrue(v.capacity() == 16);
	}
	
	MyVector v2 = new MyVector(21);
	// MyVector(capacity) 생성자 테스트
	@Test
	void InitializerTest() {
		assertTrue(v2.capacity() == 21);
	}

	// size(), capacity() 테스트
	@Test
	void sizeMethodTest() {
		assertTrue(v.size() == 0);
	}
	@Test
	void sizeMethodTest2() {
		v2.add(3);							// 추가하면 사이즈가 늘어나나?
		assertTrue(v2.size() == 1);			// 1개 추가하고 사이즈가 맞는지 확인
	}
	void sizeMethodTest3() {
		v.add(20);							// 요소를 3개 추가하고 사이즈 확인
		v.add(40);
		v.add(50);
		assertTrue(v.size() == 3);
	}
	
	@Test
	void capacityMethodTest() {
		assertTrue(v.capacity() == 16);		// 기본으로 capacity를 반환하는 capacity() 메서드 확인
		assertTrue(v2.capacity() == 21);	// v2에서의 capacity 확인
	}

	// isEmpty() 테스트
	@Test
	void isEmptyMethodTest() {
		assertTrue(v.isEmpty() == true);	// 객체를 생성한 후 아무것도 하지 않았을 떄 비어있는지 확인
	}
	@Test
	void isEmptyMethodTest2() {
		v.add(1);							// 요소 하나를 추가한 후 비어있는지 확인
		assertTrue(v.isEmpty() == false);	// false 반환
	}
	@Test
	void isEmptyMethodTest3() {
		v.add("kfkdjasl");					// 문자열 객체를 추가한 뒤 확인
		assertTrue(v.isEmpty() == false);
	}
	@Test
	void isEmptyMethodTest6() {
		v2.add(new Card());					// 임의의 Card객체를 만들어서 확인
		assertTrue(v2.isEmpty() == false);
	}
	
	// add 메서드 테스트
	@Test
	void addMethodTest() {
		v.add("hi");							// 요소 하나를 추가
		assertTrue(v.size() == 1);				// 사이즈가 1 증가했는지 확인
		assertTrue(v.get(0).equals("hi"));		// 인덱스 0에 잘 추가 되었는지 확인
		assertTrue(v.indexOf("hi") == 0);		// 추가한 요소 "hi"의 인덱스를 구한 값이 0이 나오는지 확인
	}
	@Test
	void addMethodTest2() {
		v.add("hi");
		v.add("hello");
		v.add("hoo");
		assertTrue(v.get(1).equals("hello"));	// 요소 세개를 추가하고 두번째 추가한 "hello"가 1번 인덱
		assertTrue(v.indexOf("hoo") == 2);		// 세번째 추가한 요소 "hoo"가 인덱스 2인지 확인
	}
	
	// add 메서드 테스트
	// isEmpty가 false로 바뀌는지
	// capacity의 크기를 초과하면 자동으로 배열의 길이를 늘려주는지
	@Test
	void addMethodTest3() {
		for (int i = 0; i < 20; i++ ) {				// 요소 총 20개를 추가
			v.add(i + "");							// 비어있지 않다로 잘 바뀌는지, 사이즈는 20개가 맞는지
		}											// 원래 전체 용량은 16이었는데 용량이 자동으로 32로 늘어났는지
		assertTrue(v.isEmpty() == false );
		assertTrue(v.size() == 20);
		assertTrue(v.capacity() == 32);
	}
	
	@Test
	void addMethodTest4() {
		for (int i = 0; i < 21; i++ ) {				// 요소 21개 추가
			v2.add(i + 5 + "");						// 비어있지 않다로 잘 바뀌는지
		}											// v2는 원래 용량이 21이었기 때문에 용량이 그대로 있는지
		assertTrue(v2.isEmpty() == false );
		assertTrue(v2.size() == 21);
		assertTrue(v2.capacity() == 21);
	}
	
	// add 메서드 테스트 두번 째
	//v의 capacity는 32로 변했고 size는 20이었는데 총 13번 반복하고 size가 32가 되었을 때
	// capacity를 2배로 늘려서 64가 될 것이고, 사이즈는 33이 될 것이다.
	// v2의 capacity는 21이었고 size가 20이었는데 총 13번 반복하기 때문에 size가 21이 된 후
	// 22번째 추가할 때 capacity는 42로 늘어나고, 사이즈는 33이 될 것이다.
	@Test
	void addMethodTest5() {
		for (int i = 0; i < 20; i++) {				// 일단 위와 동일하게 20개 추가함
			v.add(i + "");
		}
		assertTrue(v.isEmpty() == false );			// 비어있지 않다 확인
		assertTrue(v.size() == 20);					// 사이즈 20 확인
		assertTrue(v.capacity() == 32);				// 용량 32확인
		
		for (int i = 20; i < 33; i++ ) {			// 요소 13개 추가
			v.add(i * 3 + "");
		}
		assertTrue(v.isEmpty() == false);
		assertTrue(v.size() == 33);					// 사이즈가 33이고, 원래 32이었던 용량보다 늘어나므로
		assertTrue(v.capacity() == 64);				// 64가 잘 되었는지 확인한다
	}
	
	@Test
	void addMethodTest6() {
		for (int i = 0; i < 20; i++) {				// capacity용량이 다른 v2로 반복하여 실행
			v2.add(i + 5 + "");						// 첫 20번 반복 동안은 용량이 늘지 않다가
		}
		assertTrue(v2.isEmpty() == false );
		assertTrue(v2.size() == 20);
		assertTrue(v2.capacity() == 21);
		for (int i = 20; i < 33; i++ ) {			// 다음 13번의 반복동안 사이즈가 21을 넘어가게 되므로
			v2.add(i * 4 + "");						// 사이즈는 2배인 42가 되는지 확인
		}
		assertTrue(v2.isEmpty() == false );
		assertTrue(v2.size() == 33);
		assertTrue(v2.capacity() == 42);
	}

	// get() 메서드 테스트
	@Test
	void getMethodTest() {
		
		for (int i = 0; i < 20; i++) {
			v.add(i + "");							
		}
		for (int i = 20; i < 33; i++ ) {
			v.add(i * 3 + "");
		}												// 지금 v에는 "0", "1", ... "19"와 "60", "63", "66", ... "96"
		assertTrue(v.get(19).equals("19")); 			// v에서 인덱스 19를 넣으면 "19"를 반환, 인덱스 32를 넣으면 "96"을 반환
		assertTrue(v.get(32).equals("96"));
	}
	@Test
	void getMethodTest2() {
		
		for (int i = 0; i < 20; i++) {
			v2.add(i + 5 + "");
		}
		for (int i = 20; i < 33; i++ ) {
			v2.add(i * 4 + "");
		}												// v2에는 "5", "6", "7", ... "24"와 "80", "84", "88", ..., "128"이 추가 되어 있을 것
		assertTrue(v2.get(17).equals("22")); 			// v2에서 인덱스 17을 넣으면 "22"를 반환, 인덱스 31을 넣으면 "124"를 반환
		assertTrue(v2.get(31).equals("124"));
	}
	@Test
	void getMethodTest3() {
		
		for (int i = 0; i < 20; i++) {
			v.add(i + "");
		}
		for (int i = 20; i < 33; i++ ) {
			v.add(i * 3 + "");
		}
		assertTrue(v.indexOf(v.get(19)) == 19);			// indexOf와 get을 조합하여 테스트 인덱스를 넣어 반환한 객체의 인덱스가
		assertTrue(v.indexOf(v.get(32)) == 32);			// 해당 인덱스와 같은지 테스트
		
	}
	@Test
	void getMethodTest4() {
		
		for (int i = 0; i < 20; i++) {
			v2.add(i + 5 + "");
		}
		for (int i = 20; i < 33; i++ ) {
			v2.add(i * 4 + "");
		}
		assertTrue(v2.indexOf(v2.get(17)) == 17);
		assertTrue(v2.indexOf(v2.get(31)) == 31);
		
	}
	
	// toString 테스트
	// 안녕하세요저는장재주입니다.
	// 0123456789
	@Test
	void toStringTest() {
		v.add("안녕하세요");					// "안녕하세요"
		v.add("저는");							// "저는"
		v.add("장재주입니다.");					// "장재주입니다"
		assertTrue(v.toString().equals("안녕하세요저는장재주입니다."));
		
	}
	@Test
	void toStringTest2() {
		for (int i = 0; i < 10; i++) {
			v.add(i+"");
		}
		assertTrue(v.toString().equals("0123456789"));
	}
	@Test
	void toStringTest3() {
		v.add("안녕하세요");
		v.add("저는");
		v.add("장재주입니다.");
		for (int i = 0; i < 10; i++) {
			v.add(i+"");
		}
		assertTrue(v.toString().equals("안녕하세요저는장재주입니다.0123456789"));
	}

	// indexOf() 메서드 테스트
	@Test
	void indexOfMethodTest() {
		for (int i = 0; i < 20; i++) {
			v.add(i + "");
		}
		for (int i = 20; i < 33; i++ ) {
			v.add(i * 3 + "");
		}
		assertTrue(v.indexOf("18") == 18);		// v.indexOf("18")은 인덱스 18 반환, "93"은 인덱스 31반환	
		assertTrue(v.indexOf("93") == 31);
	}
	
	@Test
	void indexOfMethodTest2() {
		for (int i = 0; i < 20; i++) {
			v2.add(i + 5 + "");
		}
		for (int i = 20; i < 33; i++ ) {
			v2.add(i * 4 + "");
		}
		assertTrue(v2.indexOf("18") == 13);
		assertTrue(v2.indexOf("116") == 29);	// v2에 18을 넣으면 인덱스 13 반환, "116"은 인덱스 29 반환
	}
	
	@Test
	void indexOfMethodTest3() {
		for (int i = 0; i < 20; i++) {
			v.add(i + "");
		}
		for (int i = 20; i < 33; i++ ) {
			v.add(i * 3 + "");
		}
		assertTrue(v.get(v.indexOf("18")).equals("18"));	// indexOf와 get메서드 조합 테스트
		assertTrue(v.get(v.indexOf("93")).equals("93"));	// 객체를 넣어 indexOf로 얻은 인덱스값을 get()에 넣으면 해당 객체가 반환되는가
	}
	
	@Test
	void indexOfMethodTest4() {
		for (int i = 0; i < 20; i++) {
			v2.add(i + 5 + "");
		}
		for (int i = 20; i < 33; i++ ) {
			v2.add(i * 4 + "");
		}
		assertTrue(v2.get(v2.indexOf("18")).equals("18"));
		assertTrue(v2.get(v2.indexOf("116")).equals("116"));
	}
	// 없는 인덱스 판단
	@Test
	void indexOfMethodTest5() {
		for (int i = 0; i < 20; i++) {
			v.add(i + "");
		}
		assertTrue(v.indexOf("20") == -1);			// 존재하지 않는 객체를 넣었을 때 -1이 잘 반환되는가?
	}	
	
	// 매개변수로 null 값주기
	@Test
	void indexOfMethodTest6() {
		for (int i = 0; i < 20; i++) {
			v.add(i + "");
		}
		v.add(null);								// null을 객체로써 추가했을 때 null을 잘 찾을 수 있는가?
		assertTrue(v.indexOf(null) == 20);			// 20개의 객체(19번째 인덱스)까지 추가한 뒤 null을 추가하면 20번째 인덱스에 들어감
	}

	// remove 메서드 테스트
	// 먼저 지워져서 true 반환 되는가
	// 사이즈 줄어 들었는가
	// 빈자리 메워 졌는가?
	@Test
	void removeMethodTest() {
		for (int i = 0; i < 20; i++) {
			v.add(i +"");
		}
		assertTrue(v.remove("13") == true);				// 지워지면 true 반환
		// 원래 "13"의 인덱스는 13
		// 이제 인덱스 13의 값은 "14"가 되어야 함
		assertTrue(v.get(13).equals("14") == true);
		// 사이즈는 원래 20이었다가 19로 줄어들어야 한다.
		assertTrue(v.size() == 19);
	}
	@Test
	void removeMethodTest2() {
		v.add("10");
		assertTrue(v.remove("20") == false);			// 없는 객체 지우면 false 반환
		assertTrue(v.size() == 1);						// 사이즈 그대로 0
	}
	@Test
	void removeMethodTest3() {
		for (int i = 0; i < 10; i++) {
			v.add(i +"");
		}
		assertTrue(v.remove("7") == true);				// 있는 객체 지우면 true 반환
		assertTrue(v.toString().equals("012345689"));	// toString으로 지워졌는지 확인
		assertTrue(v.size() == 9);						// 사이즈 줄었는지 확인
	}
	
	@Test
	void removeMethodTest4() {
		for (int i = 0; i < 10; i++) {
			v.add(i +"");
		}
		assertTrue(v.toString().equals("0123456789"));	// 
		
		for (int i = 0; i < 10; i++) {
			v.remove(i+"");
		}
		assertTrue(v.size() == 0);
//		assertTrue(v.get(0) == null);
	}

}
