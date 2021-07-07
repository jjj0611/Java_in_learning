package com.j_graphy.day03;

public class ArrayEx13 {

	public static void main(String[] args) {
		
		// 16진수를 2진수로 나타내는 방법
		// A : 1010(2), B: 1011(2), C: 1100(2), D: 1101(2), E: 1110(2), F: 1111(2)
		
		char[] hex = {'C', 'A', 'F', 'E'};
		
		String[] binary = { "0000", "0001", "0010", "0011",
							"0100", "0101", "0110", "0111",
							"1000", "1001", "1010", "1011",
							"1100", "1101", "1110", "1111" };
		
		String result = "";
		
		// hex의 요소가 숫자가 아닐 때 A만큼 빼고 10을 더해준다. 문자에서 A만큼 빼면 해당 문자의 순서-1만큼 값이 나오고
		// 'A'는 0번째지만, 2진수표에서 10번째를 나타내므로 10을 더해주는 방식으로 2진수를 구할 수 있다.
		for (int i = 0; i < hex.length; i++) {
			if ('0' <= hex[i] && hex[i] <'9') {
				result += binary[hex[i] - '0']; 
			} else {
				result += binary[hex[i] - 'A' + 10];
			}
		}
		
		System.out.println("hex : " + new String(hex));
		System.out.println("result : " + result);

	}

}
