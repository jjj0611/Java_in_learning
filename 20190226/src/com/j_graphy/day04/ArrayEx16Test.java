package com.j_graphy.day04;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArrayEx16Test {

	// Q. 세개의 정수를 입력 받아서 그 중 2번째로 큰 값을 반환하는 메서드
	// int mid(int x, int y, int z)를 작성하시오.

	int mid(int x, int y, int z) {
		// 완성하시오
		// 배열 만들고 돌리면서 큰 값 정렬
		// 중복으로 입력하는 값도 처리

//		if (x == y)
//			return x;
//		else if (y == z)
//			return y;
//		else if (x == z)
//			return z;
//		else {
//
//			if (x > y) {
//
//				if (y > z) {
//
//					return y;
//
//				} else {
//
//					if (x > z)
//						return z;
//					else
//						return x;
//
//				}
//			} else {
//
//				if (x > z)
//					return x;
//				else {
//
//					if (y > z)
//						return z;
//					else
//						return y;
//
//				}
//
//			}
//
//		}

//		if (x > y) { // x > y
//
//			if (x > z) { // x > z ( x > y)
//
//				if (y > z) // y > z ( x > z ( x > y) ) => x > y > z
//
//					return y;
//
//				else // z >= y ( x > z ( x > y) ) -> x > z >= y
//
//					return z;
//
//			} else { // z >= x (x > y) => z >= x > y
//
//				return x;
//
//			}
//
//		} else { // y >= x
//
//			if (y > z) { // y > z ( y >= x)
//
//				if (x > z) // x > z ( y > z ( y >= x) ) => y >= x > z
//					return x;
//				else // z >= x ( y > z ( y >= x) ) => y > z >= x
//					return z;
//
//			} else // z >= y ( y >= x) => z >= y >= x
//
//				return y;
//
//		}

//		int[] arr = {x, y, z};
//		
//		for (int i = 0; i < arr.length - 1; i++) {
//			boolean changed = false;
//			for (int j = 0; j < arr.length - 1 - i; j++) {
//				int tmp;
//				if (arr[j] > arr[j+1]) {
//					tmp = arr[j];
//					arr[j] = arr[j+1];
//					arr[j+1] = tmp;
//					changed = true;
//				}
//			}
//			if (!changed)
//				break;
//		}
//		
//		return arr[1];
		
		if( (x <= y && y <= z) || (z <= y && y <= x))
			return y;
		else if ( (y <= x && x <= z) || (z <= x && x <= y) )
			return x;
		else
			return z;
		
	}
	


	// 3개가 다 다른 것 순서 바꿔

	@Test
	void test01() {
		assertTrue(mid(1, 2, 3) == 2);

	}

	@Test
	void test02() {
		assertTrue(mid(1, 3, 2) == 2);

	}

	@Test
	void test03() {
		assertTrue(mid(2, 1, 3) == 2);

	}

	@Test
	void test04() {
		assertTrue(mid(2, 3, 1) == 2);

	}

	@Test
	void test05() {
		assertTrue(mid(3, 1, 2) == 2);

	}

	@Test
	void test06() {
		assertTrue(mid(3, 2, 1) == 2);

	}

	// 2개가 같은 것 중 같은게 큰 수
	@Test
	void test07() {
		assertTrue(mid(2, 2, 1) == 2);

	}

	@Test
	void test08() {
		assertTrue(mid(1, 2, 2) == 2);

	}

	@Test
	void test09() {
		assertTrue(mid(2, 1, 2) == 2);

	}

	// 2개가 같은 것 중 같은게 작은 수
	@Test
	void test10() {
		assertTrue(mid(1, 1, 2) == 1);

	}

	@Test
	void test11() {
		assertTrue(mid(1, 2, 1) == 1);

	}

	@Test
	void test12() {
		assertTrue(mid(2, 1, 1) == 1);

	}

	// 3개가 같은 수
	@Test
	void test13() {
		assertTrue(mid(1, 1, 1) == 1);

	}

}
