package com.j_graphy.day12;

//[문제2] 문제1에서 완성된 코드에 사용자 입력을 받아서 정답여부를 판단하여 마지막에 최종점수를

//실행결과와 같이 출력하도록 코드를 완성하세요.

import java.util.*; 

class QuizEx2 { 
	public static void main(String[] args) {
		String[] data = { 
	       "다음 중 키워드가 아닌 것은?`2`final`True`if`public", 
	       "다음 중 자바의 연산자가 아닌 것은?`6`&`|`++`!=`/`^", 
	       "다음 중 메서드의 반환값이 없음을 의미하는 키워드는?`1`void`null`false`", 
		}; 
	 
		Scanner s = new Scanner(System.in); 
		int score = 0; 
	
		for(int i=0;i < data.length;i++) { 
			String[] tmp = data[i].split("`",3); 
	
			String question = tmp[0]; 
			String answer = tmp[1]; 
			String[] choices = tmp[2].split("`"); 
	
			System.out.println("["+(i+1)+"] "+question); 
	       
			for(int x=0;x < choices.length;x++) { 
	             System.out.print((x+1)+"."+choices[x]+"\t"); 
			} 
		
			System.out.println(); 
	
			System.out.println("답을 입력하시오");
	        String input = s.nextLine();
	        if ( answer.equals(input) ) score++;
	       
	        System.out.println("[답]" + answer);
	
	
	        System.out.println(); 
	        System.out.println(); 
		}
		
		System.out.println("점수는 : " + score);
		
	
	
	 // 알맞은 코드를 넣으세요.
	
	} // main 
}

