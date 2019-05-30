package com.j_graphy.day03;

public class ArrayExExtra_03 {

	public static void main(String[] args) {
		
		// 5*5 int 배열 만들고,
		// 1~25로 초기화
		// 배열의 요소를 섞는다.
		
		
		int[][] multiArr = new int[5][5];
		
		for (int i = 0; i < multiArr.length; i++) {
			for (int j = 0; j < multiArr[i].length; j++) {
				multiArr[i][j] = (5 * i) + (j + 1);
			}
		}
		
		// 배열이 잘 생성되었는지 확인
		for (int i = 0; i < multiArr.length; i++) {
			for (int j = 0; j < multiArr[i].length; j++) {
				System.out.printf("[%2d]", multiArr[i][j]);
			}
			System.out.println();
		}
		
		System.out.println();
		
		// 다차원 배열의 요소를 섞기 위해서는 행과 열의 인덱스에 대한 난수 필요
		// 난수를 두개 생성하고, 섞기 위한 임시 그릇 필요.
		for (int k = 0; k < 100; k++) {
			int i = (int) (Math.random() * multiArr.length);
			int j = (int) (Math.random() * multiArr.length);
			int tmp;
			
			tmp = multiArr[i][j];
			multiArr[i][j] = multiArr[0][0];
			multiArr[0][0] = tmp;
		}
		
		for (int i = 0; i < multiArr.length; i++) {
			for (int j = 0; j < multiArr[i].length; j++) {
				System.out.printf("[%2d]", multiArr[i][j]);
			}
			System.out.println();
		}
		
		// 혹은 배열의 요소 하나하나를 반복하면서 생성한 난수에 해당하는 요소와 교환
		for (int i = 0; i < multiArr.length; i++) {
			for (int j = 0; j < multiArr[i].length; j++) {
				int x = (int) (Math.random() * multiArr.length);
				int y = (int) (Math.random() * multiArr.length);
				
				int tmp = multiArr[i][j];
				multiArr[i][j] = multiArr[x][y];
				multiArr[x][y] = tmp;
				
			}
		}
		System.out.println();
		
		for (int i = 0; i < multiArr.length; i++) {
			for (int j = 0; j < multiArr[i].length; j++) {
				System.out.printf("[%2d]", multiArr[i][j]);
			}
			System.out.println();
		}
		
	}
	
}
