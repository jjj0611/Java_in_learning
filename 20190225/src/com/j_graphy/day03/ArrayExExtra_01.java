package com.j_graphy.day03;

public class ArrayExExtra_01 {

	public static void main(String[] args) {
		
		// 수업 시간 예제
		
		int[] arr = {4, 4, 4, 6, 5, 7, 9, 7, 5, 3};
		
		// 문제 1) 배열 arr를 오름차순정렬하여 출력 -> 3444556779
		// ArrayEx_11_1에서 사용한 중복되는 값의 개수 count[]를 활용하여 정렬
		// count[] 배열을 만들어서 arr를 반복하며 개수를 세줌
		
		int[] count = new int[arr.length];
		
		for (int i = 0; i < arr.length; i++) {
			count[arr[i]]++;
		}
		
		for(int i = 0; i < count.length; i++) {
			System.out.print(count[i]);
		}
		
		System.out.println();
		// 카운팅을 한 결과에서 작은수부터 큰 수대로 count의 결과 만큼 배열에 추가하면 되지
		// count[]를 반복하면서 그 값이 0이 아니면 그만큼 돌면서 넣어주면 돼.
		// count[i] 만큼 tmp에 한번씩 i 값을 넣어주면 돼.
		// 근데 문제는 tmp에 한번 들어간 곳 인덱스 이상을 넣어주어야 한다는 것.
		
//		int i = 0;
//		int[] tmp = new int[arr.length];
//		while(i < tmp.length) {
//			for (int j = 0; j < count.length; j++) {
//				if (count[j] > 0) {
//					for (int k = 0; k < count[j]; k++) {
//						tmp[i] = j;
//						i++;
//					}
//				}
//			}
//		}
		
		int[] tmp = new int[arr.length];
		int tmp_index =0;
		
		for (int i = 0; i < count.length; i++) {
			if(count[i] > 0) {
				for (int j = 0; j < count[i]; j++) {
					tmp[tmp_index] = i;
					tmp_index++;
				}
			}
		}
		
		arr = tmp;
		
		for (int i = 0; i <arr.length; i++) {
			System.out.print(arr[i]);
		}	
		
		System.out.println();
		
		
		
		// 이러한 방식을 버킷 정렬이라고 한다.
		// 버블 정렬과 다른점.
		
		
//		int[] arr = {4, 4, 4, 6, 5, 7, 9, 7, 5, 3};
//		int[] count = new int[arr.length];
//		
//		for (int i = 0; i < arr.length; i++) {
//			count[arr[i]]++;
//		}
		
		// count를 돌면서 count가 1보다 큰 인덱스 개수 추출(tmp 배열의 길이를 만들기 위해)
		
		
		
	}
	
}
