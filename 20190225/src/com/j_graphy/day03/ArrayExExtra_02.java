package com.j_graphy.day03;

public class ArrayExExtra_02 {

	public static void main(String[] args) {
		
		
		
		// 문제 2) 배열 arr에서 중복값을 제하여 출력하시오. -> 345679
		// ArrayEx11의 count를 활용하여 중복 값 제거
		// count라는 배열을 만들어서 해당 값의 숫자를 담을 그릇 설정(arr에 담긴 숫자가 양수라는 가정 하에)
		
		int[] arr = {4, 4, 4, 6, 5, 7, 9, 7, 5, 3};
		
		int[] count = new int[arr.length];
				
		for (int i = 0; i < arr.length; i++) {
			count[arr[i]]++;
		}
		
		for(int i = 0; i < count.length; i++) {
			System.out.print(count[i]);
		}
		System.out.println();
		
		// count배열을 활용해서 0이상인 값의 개수를 구함 -> 중복이 제거 된 배열의 길이
		// 다시 count배열을 돌리면서 값이 0이상이면 해당 인덱스를 tmp 배열에 추가해준다.
		int lenOfTmp = 0;
		for ( int i = 0; i < count.length; i++) {
			if (count[i] > 0) {
				lenOfTmp++;
			}
		}
		
		int[] tmp = new int[lenOfTmp];
		int tmp_index = 0;
		for (int i = 0; i < count.length; i++) {
			if ( count[i] > 0) {
				tmp[tmp_index] = i;
				tmp_index++;
			}
		}
		
		for (int i = 0; i < tmp.length; i++) {
			System.out.print(tmp[i]);
		}
		
	}
	
}
