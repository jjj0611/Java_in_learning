package com.j_graphy.day03;

import java.util.Scanner;
import java.lang.*;

class Bingo {
	
	int size;
	int winningCount;
	
	int[][] bingoBoard;

	Scanner inputNum = new Scanner(System.in);
	
	Bingo() {
		System.out.print("빙고판의 크기를 입력하세요 : ");
		String input = inputNum.nextLine();
		this.size = Integer.parseInt(input);
		this.bingoBoard = new int[this.size][this.size];
		System.out.print("승리를 위한 빙고 숫자를 입력하세요 : ");
		input = inputNum.nextLine();
		this.winningCount = Integer.parseInt(input);
	}
	
	void createBingoBoard () {
		for (int i = 0; i < bingoBoard.length; i++) {
			for (int j = 0; j < bingoBoard[i].length; j++) {
				bingoBoard[i][j] = (size * i) + (j + 1);
			}
		}
		
		for (int k = 0; k < 100; k++) {
			int i = (int) (Math.random() * bingoBoard.length);
			int j = (int) (Math.random() * bingoBoard.length);
			int tmp;
			
			tmp = bingoBoard[i][j];
			bingoBoard[i][j] = bingoBoard[0][0];
			bingoBoard[0][0] = tmp;
		}
		
	}
	
	void printBingoBoard() {
		for (int i = 0; i < bingoBoard.length; i++) {
			for (int j = 0; j < bingoBoard[i].length; j++) {
				System.out.printf("[%2d]", bingoBoard[i][j]);
			}
			System.out.println();
		}
	}
	
	int getBingoNum() {
		
		System.out.print("숫자를 입력하세요 : (1~25)");
		String input = inputNum.nextLine();
		int getNum = Integer.parseInt(input);
		
		return getNum;
		
	}	
	
	void eraseBingoNum(int getNum) {
		
		if (1 <= getNum && getNum <= this.size * this.size) {
			boolean numCalled = true;
			outer:
			for (int i = 0; i < bingoBoard.length; i++) {
				for (int j = 0; j < bingoBoard[i].length; j++) {
					if ( getNum == bingoBoard[i][j]) {
						bingoBoard[i][j] = 0;
						numCalled = false;
						break outer;
					}
				}
			}
			if (numCalled) {
				System.out.println("이미 입력된 숫자입니다.");
			}
		} else {
			System.out.printf("1 ~ %d 사이의 수를 입력해주세요\n", this.size * this.size );
		}
	}
	
	int getBingoCount() {
		
		int bingoCount = 0;
		
		int diagonalCount = 0;
		int reversedDiagonalCount = 0;
		for (int i = 0; i < bingoBoard.length; i++) {
			
			if ( bingoBoard[i][i] == 0 ) {						// 대각선 한개씩 검사
				diagonalCount++;
			}
			if ( bingoBoard[i][bingoBoard.length - 1 - i] == 0) {	// 반대 대각선 한개씩 검사
				reversedDiagonalCount++;
			}
			
			int rowCount = 0;
			int columnCount = 0;
			for (int j = 0; j < bingoBoard[i].length; j++) {
				if (bingoBoard[i][j] == 0) {						// 가로 한줄씩 검사
					rowCount++;
				}
				if (bingoBoard[j][i] == 0) {						// 세로 한줄씩 검사
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
		
		return bingoCount;
	
	}
	
}

public class ArrayExExtra_04 {
	
	public static void main(String[] args) {
		
		Bingo bingo = new Bingo();
		bingo.createBingoBoard();
		
		while(true) {
			System.out.println();
			bingo.printBingoBoard();
			bingo.eraseBingoNum(bingo.getBingoNum());
			
			int bingoCount = bingo.getBingoCount();
			
			if (bingoCount >= bingo.winningCount) {
				System.out.printf("빙고 개수 : %d개 달성!! 승리하셨습니다.\n", bingoCount);
				break;
			} else {
				System.out.printf("빙고 개수 : %d개 달성!, %d개 남았습니다.\n", bingoCount, bingo.winningCount - bingoCount);
			}
			
		}
		
		
//		 do {
//			bingo.printBingoBoard();
//			bingo.eraseBingoNum(bingo.getBingoNum());
//		} while (bingo.getBingoCount() > 3);
		
		
//		//빙고게임!!
//		final int SIZE = 5;
//		int[][] multiArr = new int[SIZE][SIZE];
//		
//		for (int i = 0; i < multiArr.length; i++) {
//			for (int j = 0; j < multiArr[i].length; j++) {
//				multiArr[i][j] = (SIZE * i) + (j + 1);
//			}
//		}
//		
//		for (int k = 0; k < 100; k++) {
//			int i = (int) (Math.random() * multiArr.length);
//			int j = (int) (Math.random() * multiArr.length);
//			int tmp;
//			
//			tmp = multiArr[i][j];
//			multiArr[i][j] = multiArr[0][0];
//			multiArr[0][0] = tmp;
//		}
//		
//		for (int i = 0; i < multiArr.length; i++) {
//			for (int j = 0; j < multiArr[i].length; j++) {
//				System.out.printf("[%2d]", multiArr[i][j]);
//			}
//			System.out.println();
//		}
//		
//		// 사용자한테 입력을 받을 거야 -> 1~25까지
//		// 1~25가 아니면 다시 입력 받아야 하고, 입력한 수를 또 입력하면 다시 입력 받아야 해.
//		// 한 줄이 모두 0이면 빙고 카운트 증가
//		
//		Scanner scan = new Scanner(System.in);
//		
//		int bingoCount = 0;
//		
//		do {
//		System.out.print("번호를 입력하세요. (입력 범위 1 ~ 25) >");
//		int getNum = scan.nextInt();
//		
//		if (1 <= getNum && getNum <= 25) {
//			boolean numCalled = true;
//			outer:
//			for (int i = 0; i < multiArr.length; i++) {
//				for (int j = 0; j < multiArr[i].length; j++) {
//					if ( getNum == multiArr[i][j]) {
//						multiArr[i][j] = 0;
//						numCalled = false;
//						break outer;
//					}
//				}
//			}
//			if (numCalled) {
//				System.out.println("이미 입력된 숫자입니다.");
//			}
//		} else {
//			System.out.println("1 ~ 25 사이의 수를 입력해주세요");
//		}
		
		
//		// 가로 한줄이 0인지부터 확인
//		for (int i = 0; i < multiArr.length; i++) {
//			int check_same = 0;
//			for (int j = 0; j < multiArr[i].length; j++) {
//				if ( multiArr[i][j] == 0) {
//					check_same++;
//				}
//			}
//			if ( check_same == 5) {
//				bingocount++;
//			}
//		}
//		
//		// 세로 한 줄이 0인지 확인
//		for (int i = 0; i < multiArr.length; i++) {
//			int check_same = 0;
//			for (int j = 0; j < multiArr[i].length; j++) {
//				if ( multiArr[j][i] == 0) {
//					check_same++;
//				}
//			}
//			if ( check_same == 5) {
//				bingocount++;
//			}
//		}
		
		
//		// 가로와 세로를 하나로 합쳐서 확인
//		for (int i = 0; i < multiArr.length; i++) {
//			int checkSameRow = 0;
//			int checkSameColumn = 0;
//			for (int j = 0; j < multiArr[i].length; j++) {
//				if (multiArr[i][j] == 0) {
//					checkSameRow++;
//				}
//				if (multiArr[j][i] == 0) {
//					checkSameColumn++;
//				}
//			}
//			if (checkSameRow == 5) {
//				bingoCount++;
//			}
//			if (checkSameColumn == 5) {
//				bingoCount++;
//			}
//		}
		
		
//		// 두 대각선 확인, i와 j가 같은 숫자들이 0인지 체크
//		// i와 j의 역순(length -i)이 0인지 체크
//		int checkSameDiagonal = 0;
//		int checkSameReversedDiagonal = 0;
//		for (int i = 0; i < multiArr.length; i++) {
//			if ( multiArr[i][i] == 0 ) {
//				checkSameDiagonal++;
//			}
//			if ( multiArr[i][multiArr.length - 1 - i] == 0) {
//				checkSameReversedDiagonal++;
//			}
//			
//		}
//		if ( checkSameDiagonal == 5) {
//			bingoCount++;
//		}
//		if (checkSameReversedDiagonal == 5) {
//			bingoCount++;
//		}
//		
//		for (int i = 0; i < multiArr.length; i++) {
//			for (int j = 0; j < multiArr[i].length; j++) {
//				System.out.printf("[%2d]", multiArr[i][j]);
//			}
//			System.out.println();
//		}
//		System.out.println("bingo 개수는 : " + bingoCount);
//		
//		} while(bingoCount < 3);
		
		
	}
	
}
