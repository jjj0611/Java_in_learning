package com.j_graphy.day12;

/* [문제4] TextArea의 데이터에서 각 라인의 앞뒤 공백을 제거하는 버튼 'trim'과 빈 줄을 제거하는 기능의 '빈줄삭제'버튼의 기능을

완성하세요.*/
import java.awt.*; 
import java.awt.event.*; 
import java.util.*; 

public class TextToolEx4 extends Frame implements WindowListener 
{ 
TextArea ta; 
TextField tfParam1, tfParam2; 
Panel pNorth, pSouth; 
Label lb1, lb2; 

String[] btnName = { 
 "Undo",         // 작업이전 상태로 되돌림 
 "짝수줄삭제", // 짝수줄을 삭제하는 기능 
 "문자삭제",    // Param1에 지정된 문자들을 삭제하는 기능 
 "trim",           // 라인의 앞뒤 공백을 제거 
 "빈줄삭제",   // 빈 줄 삭제 
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
              /* 내용 생략 */

       } 
 }); 

 btn[n++].addActionListener(new ActionListener() { // 문자삭제 - Param1에 지정된 문자를 삭제하는 기능 
       public void actionPerformed(ActionEvent ae) { 
             String curText = ta.getText(); 
             StringBuffer sb = new StringBuffer(curText.length()); 

             prevText = curText; 

             String delText = tfParam1.getText(); 

             if("".equals(delText)) return; 

             for(int i=0;i< curText.length();i++) { 
                   char ch = curText.charAt(i); 
                   
                   if(delText.indexOf(ch)==-1) 
                         sb.append(ch); 
             } 

             ta.setText(sb.toString()); 
       } 
 }); 

 btn[n++].addActionListener(new ActionListener() { // trim - 라인의 좌우공백을 제거하는 기능 
       public void actionPerformed(ActionEvent ae) { 
             String curText = ta.getText(); 
             StringBuffer sb = new StringBuffer(curText.length()); 

             prevText = curText; 
             
             // Scanner 클래스를 이용하여 curText를 라인단위로 읽기
             Scanner sc = new Scanner(curText);
             
             // sc가 다음 라인을 가지고 있는 동안에
             while( sc.hasNextLine() ) {
            	 
            	 // 하나씩 읽어오면서 공백을 제거한 후 sb에 담으면 된다.
//            	 String tmp = sc.nextLine();
//            	 tmp = tmp.trim();
//            	 sb.append(tmp);
            	 sb.append(sc.nextLine().trim()).append(CR_LF);
            	 
             }
             
             // 작업이 끝난후 sb를 보여줌
             ta.setText(sb.toString());
             
       } 
 }); 

 btn[n++].addActionListener(new ActionListener() { // 빈줄삭제 - 빈 줄 삭제 
       public void actionPerformed(ActionEvent ae) { 
             String curText = ta.getText(); 
             StringBuffer sb = new StringBuffer(curText.length()); 

             prevText = curText; 
             
             // Scanner 클래스를 이용하여 curText를 라인단위로 읽기
             Scanner sc = new Scanner(curText);
             
             // sc가 다음 라인을 가지고 있는 동안에
             while( sc.hasNextLine() ) {
            	
            	 // 읽어온 라인이 내용이 없는 빈 라인이면 sb에 저장하지 않는다.
            	 String tmp = sc.nextLine();
            	 // 읽어온 라인이 비어 있을 떄 저장하지 않고건너뜀
            	 if ( "".equals(tmp) )
            		 continue;
            	 sb.append(tmp).append(CR_LF);
            	 
             }
             
             ta.setText(sb.toString());
            

       } 
 }); 
}       // end of registerEventHandler() 

public static void main(String[] args) { 
 TextToolEx4 win = new TextToolEx4("Text Tool"); 
 win.show(); 
} 

public TextToolEx4(String title) { 
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

 for(int i=0;i < btn.length;i++) {  // 버튼배열을 하단 Panel에 넣는다. 
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


