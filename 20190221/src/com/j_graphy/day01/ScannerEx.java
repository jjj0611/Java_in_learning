// shift + cmd + space : 자동완성
// alt(option) + up, down : 행이동
// cmd + / : 주석(toggle)
// cmd + d : 한줄 삭제
// cmd + shift + f : 자동 정

package com.j_graphy.day01;

import java.util.Scanner;

public class ScannerEx {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("두 자리 정수를 하나 입력해주세요. >");
		String input = scan.nextLine();
		int num = Integer.parseInt(input);
		
		System.out.println("입력 내용 : " + input);
		System.out.printf("num : %d%n", num);
		
		System.out.print("정수를 한번 더 입력하세요. >");
		int num2 = scan.nextInt();
		System.out.printf("num2 = %d%n", num2);
		
		scan.close();
		
	} 

}
