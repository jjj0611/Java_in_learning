package com.j_graphy.day12;

//[문제1] 주어진 문자열 데이터를 가지고 실행결과와 같이 출력되도록 코드를 완성하세요.

//데이터의 형식은 문제, 답, 선택지의 순서로 되어 있으며 구분자는 `(숫자1옆의 키)입니다.

class QuizEx1 { 
	public static void main(String[] args) { 
		String[] data = { 
		      "다음 중 키워드가 아닌 것은?`2`final`True`if`public", 
		      "다음 중 자바의 연산자가 아닌 것은?`5`&`|`++`!=`/`^", 
		      "다음 중 메서드의 반환값이 없음을 의미하는 키워드는?`1`void`null`false", 
		}; 

		for(int i=0;i<data.length;i++) {
		
		       // 1. String클래스의 String[] split(String regex, int limit)를 사용해서 문제와 선택지를 나누세요.
		
		       // 2. 문제를 출력하세요.
		
		       // 3. 선택지를 나누기 위해 String[] split(String regex)를 사용하세요.
		
		       // 4.반복문을 이용해서 선택지를 출력하세요.
			
			// 문제 안에서 regex가 뭐가 있지? '2', '1', '5' 이것들이지? 즉 split할 정규 표현식으로는 '[0-9]'
			String[] questionAnswer = data[i].split("`[0-9]`");
			String question = questionAnswer[0];
			String[] answer = questionAnswer[1].split("`");
			System.out.println("[" + (i+1) + "]" + question);
			for (int j = 0; j < answer.length; j++) {
				System.out.print(j+1 + ". " + answer[j] + "\t");
			}
			System.out.println();
		
		} 
	
	} // main 
}


/*
[실행결과]

[1] 다음 중 키워드가 아닌 것은?
1.final 2.True  3.if    4.public



[2] 다음 중 자바의 연산자가 아닌 것은?
1.&     2.|     3.++    4.!=    5./     6.^



[3] 다음 중 메서드의 반환값이 없음을 의미하는 키워드는?
1.void  2.null  3.false

*/
