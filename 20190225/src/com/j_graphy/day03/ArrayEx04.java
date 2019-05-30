package com.j_graphy.day03;

public class ArrayEx04 {

	public static void main(String[] args) {
		
		// 배열의 복사는 for문을 쓰면서 복사하는 것보다
		// System.arraycopy() 메서드를 사용하는 것이 효율적이다.
		// 배열은 메모리의 연속적인 공간에 저장된다는 특성을 활용하는 것이다.
		
		
		char[] abc = {'A', 'B', 'C', 'D' };
		char[] num = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		System.out.println(abc);
		System.out.println(num);
		
		//  배열 abc와 num을 붙여서 하나의 배열(result)로 만든다.
		char[] result = new char[abc.length + num.length];
		System.arraycopy(abc, 0, result, 0, abc.length);
		System.arraycopy(num, 0, result, abc.length, num.length);
		System.out.println(result);
		
		// 배열 abc을 배열 num의 첫 번째 위치부터 배열 abc의 길이만큼 복사
		System.arraycopy(abc, 0, num, 0, abc.length);
		System.out.println(num);
		
		// number의 인덱스 6위치에 3개를 복
		System.arraycopy(abc, 0, num, 6, 3);
		System.out.println(num);
		
		
		// System.arraycopy(arr1, start_index1, arr2, start_index2, length);
		// 위는 arr1의 start_index1에서부터 length만큼 arr2에 start_index2부터 시작하여 복사하겠다는 의미
		// 다른 배열과 달리 char 배열은 그냥 프린트 해도 괜찮다.
	}
	
}
