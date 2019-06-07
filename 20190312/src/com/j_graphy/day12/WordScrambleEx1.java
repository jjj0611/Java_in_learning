package com.j_graphy.day12;

/*
 * [문제1] 다음의 예제를 완성하시오.

getAnswer(String[] strArr)는 배열strArr의 요소중의 하나를 임의로 골라서 반환한다.(Math.random()사용)

getScrambledWord(String str)는 주어진 문자열 str의 각 문자의 순서를 뒤섞은 다음, 새로운 문자열로 반환한다.

                                             (Math.random()사용)
 */

public class WordScrambleEx1 { 
      public static void main(String[] args) { 
            String[] strArr = { "CHANGE", "LOVE", "HOPE", "VIEW"}; 

            String answer = getAnswer(strArr); 
            String question = getScrambledWord(answer); 

            System.out.println("Question:"+question); 
            System.out.println("Answer:"+answer); 
      } // main 

      public static String getAnswer(String[] strArr) { 
           // 하나 임의로 골라서반환
    	 return strArr[(int) (Math.random() * strArr.length)];
    	  
      } 
      
      public static String getScrambledWord(String str) { 
            // str의 순서를 뒤섞어서 새로운 문자열로 반환
    	  char[] chArr = str.toCharArray();
    	  for (int i = 0; i < chArr.length; i++) {
    		  int random = (int) (Math.random() * chArr.length);
    		  char tmp = chArr[random];
    		  chArr[random] = chArr[i];
    		  chArr[i] = tmp;
    	  }
    	  return String.valueOf(chArr);

      } // scramble(String str) 
}
