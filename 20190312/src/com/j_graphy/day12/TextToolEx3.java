package com.j_graphy.day12;

/* [문제3] TextArea의 데이터 중에서 Param1에 입력된 문자 또는 문자들을 제거하는 기능의 '문자삭제'버튼의 기능을

완성하세요.*/
import java.awt.*; 
import java.awt.event.*; 
import java.util.*; 

public class TextToolEx3 extends Frame implements WindowListener 
{ 
TextArea ta; 
TextField tfParam1, tfParam2; 
Panel pNorth, pSouth; 
Label lb1, lb2; 

String[] btnName = { 
 "Undo",         // 작업이전 상태로 되돌림 
 "짝수줄삭제", // 짝수줄을 삭제하는 기능 
 "문자삭제",    // param1에 지정된 문자들을 삭제하는 기능 
}; 

Button[] btn = new Button[btnName.length]; 

private final String CR_LF = System.getProperty("line.separator"); // 줄바꿈문자 

private String prevText =""; 

private void registerEventHandler() { 
 addWindowListener(this); 

 int n = 0; // 버튼순서 

 btn[n++].addActionListener(new ActionListener() { // Undo - 작업이전 상태로 되돌림 
       public void actionPerformed(ActionEvent ae) { 
             String curText = ta.getText(); 

             if(!prevText.equals("")) { 
                   ta.setText(prevText);                         
             } 

             prevText = curText; 
       } 
 }); 

 btn[n++].addActionListener(new ActionListener() { // 짝수줄삭제 - 짝수줄을 삭제하는 기능 
       public void actionPerformed(ActionEvent ae) { 
             String curText = ta.getText(); 
             StringBuffer sb = new StringBuffer(curText.length()); 

             prevText = curText; 

             Scanner s = new Scanner(curText); 

             for(int i=0;s.hasNextLine();i++) { 
                   String line = s.nextLine(); 

                   if(i%2==0) { 
                         sb.append(line).append(CR_LF); 
                   } 
             } 

             ta.setText(sb.toString()); 
       } 
 }); 

 btn[n++].addActionListener(new ActionListener() { // 문자삭제 - Param1에 지정된 문자를 삭제하는 기능

       public void actionPerformed(ActionEvent ae) { 

             String curText = ta.getText(); 
             StringBuffer sb = new StringBuffer(curText.length()); 

             prevText = curText; 
             
             // 1. TextField Param1의 값을 가져온다
             String p1 = tfParam1.getText();
             
             // 반복문을 이용해서 curText를 한글자씩 읽어서 Param1에서 가져온 문자열에 포함되어 있는지 확인
             // 포함되어 있으면 sb에 저장하지 않고, 포함되어 있지 않으면 sb에 저장
             // 작업이 끝난 후 sb에 남긴 내용을 ta에 보여준다.
             
             for (int i = 0; i < curText.length(); i++) {
            	 // curText에 있는 한 문자 마다 존재 하는지 안하는지 파악
            	 boolean notExisting = true;
            	 // p1에 담긴 문자열을 하나씩 돌면서
            	 // 하나라도 같을게 나오면 false로 바꿔준 후 반복문을 빠져나가서
            	 for (int j = 0; j < p1.length(); j++) {
            		 if ( p1.charAt(j) == curText.charAt(i)) {
            			 notExisting = false;
            			 break;
            		 } 
            	 }
            	 // j 반복문이  모두 끝나고도 여전히 notExisting이 true이면 해당 문자는 Param1에서 가져온 문자열에 없는 문자이므로
            	 // sb에 추가해주어서 삭제한다.
            	 if (notExisting)
        			 sb.append(curText.charAt(i));
            	 
             }
             
             ta.setText(sb.toString());

           /*

            다음의 코드를 완성하세요.



            1. TextField Param1의 값을 가져온다.(getText()사용)

            2. 반복문을 이용해서 curText를 한글자씩 읽어서

               Param1에서 가져온 문자열에 포함되어 있는지 확인한다.

               2.1 만일 포함되어 있으면 sb에 저장하고

               2.2 포함되어 있지 않으면 sb에 저장하지 않는다.

            3. 작업이 끝난 후에 sb에 담긴 내용을 ta에 보여준다.(setText()사용)

          */

       } 
 }); 
}       // end of registerEventHandler() 

public static void main(String[] args) { 
 TextToolEx3 win = new TextToolEx3("Text Tool"); 
 win.show(); 
} 

public TextToolEx3(String title) { 
 super(title); 
 lb1 = new Label("param1:", Label.RIGHT); 
 lb2 = new Label("param2:", Label.RIGHT); 
 tfParam1 = new TextField(15); 
 tfParam2 = new TextField(15); 

 ta = new TextArea(); 
 pNorth = new Panel(); 
 pSouth = new Panel(); 

 for(int i=0;i < btn.length;i++) { 
       btn[i] = new Button(btnName[i]); 
 } 

 pNorth.setLayout(new FlowLayout()); 
 pNorth.add(lb1); 
 pNorth.add(tfParam1); 
 pNorth.add(lb2); 
 pNorth.add(tfParam2); 

 pSouth.setLayout(new GridLayout(2,10)); 

 for(int i=0; i < btn.length;i++) {             // 버튼배열을 하단 Panel에 넣는다. 
       pSouth.add(btn[i]); 
 } 

 add(pNorth,"North"); 
 add(ta,"Center"); 
 add(pSouth,"South"); 

 setBounds(100, 100, 600, 300); 
 ta.requestFocus(); 
 registerEventHandler(); 
 setVisible(true); 
} // public TextToolEx1(String title) { 

public void windowOpened(WindowEvent e) {} 
public void windowClosing(WindowEvent e) { 
 e.getWindow().setVisible(false); 
 e.getWindow().dispose(); 
 System.exit(0); 
} 
public void windowClosed(WindowEvent e) {} 
public void windowIconified(WindowEvent e) {} 
public void windowDeiconified(WindowEvent e) {} 
public void windowActivated(WindowEvent e) {} 
public void windowDeactivated(WindowEvent e) {} 
} // end of class 


