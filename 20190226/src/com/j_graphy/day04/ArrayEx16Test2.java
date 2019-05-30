package com.j_graphy.day04;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArrayEx16Test2 {

	// 길이가 3인 두 개의 int 배열을 입력 받아서 비교한 결과를
	// String으로 변환하는 메서드를 작성하시오.
	// 두 배열에 같은 값이 있으면 ball이고,
	// 같은 값이면서 위치까지 같으면 strike이다.
	// 만일 {1, 2, 3}과 {1, 3, 2}를 비교하면 "1S2B"를 반환해야 한다.

	// arr1과 arr2를 하나씩 비교해가면서 ball 카운트와 strike 카운트
	// 조건 1 : 같은 수이다 -> ball 혹은 strike
	// 조건 2 : 같은 위치이다 -> strike
	// 즉, 비교할 때 위치가 같은가 or 다른가를 판단
	// 같을 때 두 값이 같으면 strike
	// 같지 않을 때 두 값이 같으면 ball

	String check(int[] arr1, int[] arr2) {
		int ballCount = 0;
		int strikeCount = 0;

//		for (int i = 0; i < arr1.length; i++) {
//
//			for (int j = 0; j < arr2.length; j++) {
//
//				if (i == j) {
//
//					if (arr1[i] == arr2[j])
//						strikeCount++;
//
//				} else {
//
//					if (arr1[i] == arr2[j])
//						ballCount++;
//
//				}
//			}
//		}
		
		for (int i = 0; i < arr1.length; i++) {

			for (int j = 0; j < arr2.length; j++) {

				if (arr1[i] == arr2[j]) {

					if ( i == j )
						strikeCount++;
					else
						ballCount++;
					

				}
			}
		}

		String result = strikeCount + "S" + ballCount + "B";
		return result;

	}

	// 모두 숫자가 같은 경우
	@Test
	void test01() {
		assertTrue(check(new int[] { 1, 2, 3 }, new int[] { 1, 2, 3 }).equals("3S0B"));
	}

	@Test
	void test02() {
		assertTrue(check(new int[] { 1, 2, 3 }, new int[] { 1, 3, 2 }).equals("1S2B"));
	}

	@Test
	void test03() {
		assertTrue(check(new int[] { 1, 2, 3 }, new int[] { 2, 1, 3 }).equals("1S2B"));
	}

	@Test
	void test04() {
		assertTrue(check(new int[] { 1, 2, 3 }, new int[] { 2, 3, 1 }).equals("0S3B"));
	}

	@Test
	void test05() {
		assertTrue(check(new int[] { 1, 2, 3 }, new int[] { 3, 1, 2 }).equals("0S3B"));
	}

	@Test
	void test06() {
		assertTrue(check(new int[] { 1, 2, 3 }, new int[] { 3, 2, 1 }).equals("1S2B"));
	}

	// 중복되는 숫자가 들어가는 경우
	@Test
	void test07() {
		assertTrue(check(new int[] { 1, 2, 3 }, new int[] { 1, 1, 2 }).equals("1S2B"));
	}

	@Test
	void test08() {
		assertTrue(check(new int[] { 1, 2, 3 }, new int[] { 1, 2, 1 }).equals("2S1B"));
	}

	@Test
	void test09() {
		assertTrue(check(new int[] { 1, 2, 3 }, new int[] { 2, 1, 1 }).equals("0S3B"));
	}

	@Test
	void test10() {
		assertTrue(check(new int[] { 1, 2, 3 }, new int[] { 1, 1, 1 }).equals("1S2B"));
	}

	// 중복 숫자 & 중복 숫
	@Test
	void test11() {
		assertTrue(check(new int[] { 1, 1, 2 }, new int[] { 2, 2, 1 }).equals("0S4B"));
	}
	
	@Test
	void test12() {
		assertTrue(check(new int[] { 1, 1, 2 }, new int[] { 2, 1, 2 }).equals("2S2B"));
	}
	
	@Test
	void test13() {
		assertTrue(check(new int[] { 1, 1, 2 }, new int[] { 1, 2, 2 }).equals("2S2B"));
	}
	
	// 완전 다른 숫자
	@Test
	void test14() {
		assertTrue(check(new int[] { 1, 2, 3 }, new int[] { 4, 5, 6 }).equals("0S0B"));
	}
	
	@Test
	void test15() {
		assertTrue(check(new int[] { 1, 2, 3 }, new int[] { 1, 3, 2 }).equals("1S2B"));
	}
	
	@Test
	void test16() {
		assertTrue(check(new int[] { 1, 2, 3 }, new int[] { 1, 3, 2 }).equals("1S2B"));
	}
	
	@Test
	void test17() {
		assertTrue(check(new int[] { 1, 2, 3 }, new int[] { 1, 3, 2 }).equals("1S2B"));
	}
	
	

}
