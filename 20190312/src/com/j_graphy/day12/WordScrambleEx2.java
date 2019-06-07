package com.j_graphy.day12;

// [문제2] 다음의 예제에서 while문의 내부를 주석의 내용을 참고해서 완성하세요.

import java.util.*; 

class WordScrambleEx2 { 
      public static void main(String[] args) { 
            String[] strArr = { "CHANGE", "LOVE", "HOPE", "VIEW"}; 

            String answer = getAnswer(strArr); 
            String question = getScrambledWord(answer); 

            while(true) { 
            	
	              System.out.println("Question :" + question); 
	              System.out.print("Your answer is :"); 
                  

                  // 1. 화면을 통해 사용자의 입력을 받는다.(Scanner클래스 사용)

                  // 2. 사용자가 q 또는 Q를 입력하면 프로그램을 종료한다.

                  // 3. 사용자가 정답을 맞출때까지 반복하다가

                  //     사용자가 정답을 맞추면, while문을 빠져나간다.
                  
              
                Scanner scanner = new Scanner(System.in);
				String input = scanner.nextLine();
                
				
                if ( input.equalsIgnoreCase("Q") ) System.exit(0);
                 
                if ( input.equalsIgnoreCase(answer)) break;


            } // while 

      } // main 

      public static String getAnswer(String[] strArr) { 
            int idx = (int)(Math.random()*strArr.length); 
            return strArr[idx]; 
      } 
      
      public static String getScrambledWord(String str) { 
            char[] chArr = str.toCharArray(); 

            for(int i=0;i<str.length();i++) {
                   int idx = (int)(Math.random()*str.length()); 
                  
                  char tmp = chArr[i]; 
                  chArr[i] = chArr[idx]; 
                  chArr[idx] = tmp; 
            } 

            return new String(chArr); 
      } // scramble(String str) 
      
}

