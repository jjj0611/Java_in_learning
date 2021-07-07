package com.j_graphy.day02;

import java.util.*;

public class ArrayExExtra01 {
	
	public static void main(String[] args) {
		
		int[] arr1 = {1, 2, 3};
		int[] arr2 = {1, 2, 3};
		
		// 두 배열의 값을 하나하씩 비교해보면 되지.
		// 비교해보고 같은지 아닌지 판단하고, 하나라도 아니면 바로 스탑
		
		boolean isSame = true;	// 같은지 아닌지 저장할 플래
		
		if (arr1.length == arr2.length) {
			
			for (int i = 0; i < arr1.length; i++) {			// 배열을 하나씩 돌려가며 체크
				if (arr1[i] != arr2[i]) {					// 배열 내 값이 같지 않으면
					isSame = false;							// 플래그 값 false
					break;									// 더 판단할 필요가 없으니 break
				}
			}
			
		} else {
			isSame = false;
		}
		
		if (isSame)
			System.out.println("같습니다.");
		else
			System.out.println("다릅니다.");
		
		/*
		if (Arrays.equals(arr1, arr2))
			System.out.println("같습니다.");
		else
			System.out.println("다릅니다.");
		*/
		
		
		// 두 배열에 같은 숫자가 몇 개 있는지?
		// 각 요소 하나에 대하여 다른 배열 모든 요소를 비교해야 함.
		// 배열을 두번 반복해야지(첫번째 배열의 요소하나에 대하여 두번째 배열 모든 요소)
		
		int numOfSameNumber = 0;							// 같은 숫자의 개수를 담을 변수 선언
		
		for (int i = 0; i < arr1.length; i++) {				// arr1에서 요소 하나씩 돌려가면서
			for (int j = 0; j < arr2.length; j++) {			// arr2에서 요소 하나씩 비교
				if ( arr1[i] == arr2[j] ) {					// 두 요소가 같으
					numOfSameNumber += 1;					// 같은 숫자의 개수 하나씩 증가 -> 중복 수가 있을 수도 있으니 break하지 않음
				}
					
			}
		}
		
		System.out.printf("arr1과 arr2에 같은 숫자는 총 %d개입니다. ", numOfSameNumber);	//같은 숫자의 총 개수 출력
		
		
	}

}
