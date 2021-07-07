package com.j_graphy.day04;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArrayEx16Test3 {

	int bingoCheck(int[][] multiArr) {
		
		int bingoCount = 0;
		
		int diagonalCount = 0;
		int reversedDiagonalCount = 0;
		for (int i = 0; i < multiArr.length; i++) {
			
			if ( multiArr[i][i] == 1 ) {						// 대각선 한개씩 검사
				diagonalCount++;
			}
			if ( multiArr[i][multiArr.length - 1 - i] == 1) {	// 반대 대각선 한개씩 검사
				reversedDiagonalCount++;
			}
			
			int rowCount = 0;
			int columnCount = 0;
			for (int j = 0; j < multiArr[i].length; j++) {
				if (multiArr[i][j] == 1) {						// 가로 한줄씩 검사
					rowCount++;
				}
				if (multiArr[j][i] == 1) {						// 세로 한줄씩 검사
					columnCount++;
				}
			}
			
			if (rowCount == 5) {								// 가로 한줄에 0의 개수가 5이면 빙고
				bingoCount++;
			}
			if (columnCount == 5) {								// 세로 한줄에 0의 개수가 5이면 빙고
				bingoCount++;
			}
			
		}
		
		if ( diagonalCount == 5) {								// 대각선 한줄에 0의 개수가 5이면 빙고
			bingoCount++;
		}
		if (reversedDiagonalCount == 5) {						// 반대 대각선 한 줄에 0의 개수가 5이면 빙고
			bingoCount++;
		}
		
//		boolean checkDiagonal = true;
//		boolean checkReversedDiagonal = true;
//		for (int i = 0; i < multiArr.length; i++) {
//			
//			boolean checkRow = true;
//			boolean checkColumn = true;
//			for (int j = 0; j < multiArr[i].length; j++) {
//				if (multiArr[i][j] != 1) {						// 가로 한줄씩 검사
//					checkRow = false;
//				}
//				if (multiArr[j][i] == 1) {						// 세로 한줄씩 검사
//					checkColumn = false;
//				}
//			}
//			
//			if (checkRow) {								// 가로 한줄에 0의 개수가 5이면 빙고
//				bingoCount++;
//			}
//			if (checkColumn) {								// 세로 한줄에 0의 개수가 5이면 빙고
//				bingoCount++;
//			}
//			
//			if ( multiArr[i][i] != 1 ) {						// 대각선 한개씩 검사
//				checkDiagonal = false;
//			}
//			if ( multiArr[i][multiArr.length - 1 - i] != 1) {	// 반대 대각선 한개씩 검사
//				checkReversedDiagonal = false;
//			}
//			
//		}
//		
//		if ( checkDiagonal ) {								// 대각선 한줄에 0의 개수가 5이면 빙고
//			bingoCount++;
//		}
//		if (checkReversedDiagonal ) {						// 반대 대각선 한 줄에 0의 개수가 5이면 빙고
//			bingoCount++;
//		}
		

//		boolean checkDiagonal = true;
//		boolean checkReversedDiagonal = true;
//		for (int i = 0; i < multiArr.length; i++) {
//			boolean checkRow = true;
//			boolean checkColumn = true;
//			for (int j = 0; j < multiArr.length; j++) {
//				if ( ( multiArr[i][j] != multiArr[i][j+1] ) && ( j < multiArr.length - 1 ) )
//					checkRow = false;
//				
//				if ( ( multiArr[j][i] != multiArr[j][i] ) && ( j < multiArr.length - 1 ) )
//					checkColumn = false;
//				
//			}
//			if (checkRow)
//				bingoCount++;
//			if (checkColumn)
//				bingoCount++;
//			
//			if ( (multiArr[i][i] != multiArr[i+1][i+1] ) && ( i < multiArr.length - 1) )
//				checkDiagonal = false;
//			if ( (multiArr[i][multiArr.length - 1 - i] != multiArr[i+1][multiArr.length - 1 - (i + 1)] ) && ( i < multiArr.length - 1) )
//				checkReversedDiagonal = false;
//		}
//		
//		if (checkDiagonal)
//			bingoCount++;
//		if (checkReversedDiagonal)
//			bingoCount++;

		return bingoCount;										// 빙고 카운트 반환
		
	}
		
	
	// 가로
	@Test
	void test01() {
		int[][] arr = {
				{0, 0, 0, 0, 0},
				{1, 1, 1, 1, 1},
				{0, 0, 0, 0, 0},
				{1, 1, 1, 1, 1},
				{1, 1, 1, 1, 1}
		};
		
		assertTrue(bingoCheck(arr) == 3);
	
	}
	
	//세로
	@Test
	void test02() {
		int[][] arr = {
				{1, 0, 0, 1, 0},
				{1, 1, 0, 1, 1},
				{1, 0, 0, 1, 1},
				{1, 1, 0, 1, 1},
				{1, 1, 0, 1, 1}
		};
		
		assertTrue(bingoCheck(arr) == 2);
	
	}
	
	
	//대각선
	@Test
	void test03() {
		int[][] arr = {
				{1, 0, 1, 0, 1},
				{1, 1, 1, 1, 0},
				{1, 1, 1, 0, 1},
				{0, 0, 1, 1, 1},
				{1, 1, 0, 1, 1}
		};
		
		assertTrue(bingoCheck(arr) == 1);
	
	}
	
	@Test
	void test04() {
		int[][] arr = {
				{0, 1, 1, 1, 1},
				{0, 0, 0, 1, 0},
				{0, 0, 1, 0, 0},
				{0, 1, 0, 0, 0},
				{1, 0, 0, 0, 0}
		};
		
		assertTrue(bingoCheck(arr) == 1);
	
	}
	
	// 가로 + 세로
	@Test
	void test05() {
		int[][] arr = {
				{1, 0, 1, 0, 0},
				{1, 1, 1, 1, 1},
				{1, 0, 1, 1, 1},
				{1, 1, 1, 0, 1},
				{1, 1, 1, 1, 1}
		};
		
		assertTrue(bingoCheck(arr) == 4);
	
	}
	
	// 가로 + 대각선
	@Test
	void test06() {
		int[][] arr = {
				{1, 0, 0, 0, 0},
				{1, 1, 1, 1, 1},
				{1, 1, 1, 0, 1},
				{1, 1, 0, 1, 1},
				{1, 0, 1, 1, 1}
		};
		
		assertTrue(bingoCheck(arr) == 3);
	
	}
	
	
	// 세로 + 대각선
	@Test
	void test07() {
		int[][] arr = {
				{1, 1, 0, 0, 1},
				{1, 1, 0, 1, 1},
				{1, 1, 1, 0, 1},
				{1, 1, 1, 0, 0},
				{1, 1, 1, 0, 1}
		};
		
		assertTrue(bingoCheck(arr) == 3);
	
	}
	
	// 가로 + 세로 + 대각선
	@Test
	void test08() {
		int[][] arr = {
				{1, 0, 1, 0, 1},
				{1, 1, 0, 0, 1},
				{1, 1, 1, 0, 1},
				{1, 1, 1, 1, 1},
				{1, 1, 1, 0, 1}
		};
		
		assertTrue(bingoCheck(arr) == 4);
	
	}
	
	// 총 빙고 
	@Test
	void test09() {
		int[][] arr = {
				{1, 1, 1, 1, 1},
				{1, 1, 1, 1, 1},
				{1, 1, 1, 1, 1},
				{1, 1, 1, 1, 1},
				{1, 1, 1, 1, 1}
		};
		
		assertTrue(bingoCheck(arr) == 12);
	
	}
	
	
	

}
