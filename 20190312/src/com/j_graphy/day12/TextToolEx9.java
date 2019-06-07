package com.j_graphy.day12;

/* [문제9] TextArea의 라인의 내용중 중복된 것을 제고하고 정렬해서 보여주는 'distinct'버튼에 기능을 추가해서

중복된 라인의 수도 같이 보여주는 'distinct2'버튼을 구현하세요. */

import java.awt.*; 
import java.awt.event.*; 
import java.util.*;
import java.util.Map.Entry; 

public class TextToolEx9 extends Frame implements WindowListener 
{ 
TextArea ta; 
TextField tfParam1, tfParam2; 
Panel pNorth, pSouth; 
Label lb1, lb2; 

String[] btnName = { 
"Undo",              // 작업이전 상태로 되돌림 
"짝수줄삭제",      // 짝수줄을 삭제하는 기능 
"문자삭제",         // Param1에 지정된 문자들을 삭제하는 기능 
"trim",                // 라인의 앞뒤 공백을 제거 
"빈줄삭제",         // 빈 줄 삭제 
"접두사추가",      // Param1과 Param2의 문자열을 각 라인의 앞뒤에 붙이는 기능 
"substring",        // Param1과 Param2에 지정된 문자열을 각 라인에서 제거하는 기능 
"substring2",       // Param1과 Param2에 지정된 문자열로 둘러싸인 부분을 남기고 제거하는 기능 
"distinct",           // 중복값제거한 후 정렬해서 보여주기 
"distinct2",         // 중복값제거한 후 정렬해서 보여주기 - 중복카운트 포함 
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
               /* 내용 생략 */

      } 
}); 

btn[n++].addActionListener(new ActionListener() { // trim - 라인의 좌우공백을 제거하는 기능 
      public void actionPerformed(ActionEvent ae) { 
               /* 내용 생략 */

      } 
}); 

btn[n++].addActionListener(new ActionListener() { // 빈줄삭제 - 빈 줄 삭제 
      public void actionPerformed(ActionEvent ae) { 
               /* 내용 생략 */

      } 
}); 

btn[n++].addActionListener(new ActionListener() { // 접두사 - 각 라인에 접두사, 접미사 붙이기 
      public void actionPerformed(ActionEvent ae) { 
               /* 내용 생략 */

      } 
}); 

btn[n++].addActionListener(new ActionListener() { // substring - 문자열 자르기 
      public void actionPerformed(ActionEvent ae) { 
               /* 내용 생략 */

      } 
}); 

btn[n++].addActionListener(new ActionListener() { // substring2 - 지정된 문자를 찾아서 그 위치까지 잘라내기 
      public void actionPerformed(ActionEvent ae) { 
               /* 내용 생략 */

      } 
}); 

btn[n++].addActionListener(new ActionListener() { // distinct - 중복 라인 제거 
      public void actionPerformed(ActionEvent ae) { 
            String curText = ta.getText(); 
            StringBuffer sb = new StringBuffer(curText.length()); 

            prevText = curText; 

            Scanner s = new Scanner(curText); 
            HashSet set = new HashSet(); 

            for(int i=0;s.hasNextLine();i++) { 
                  String line = s.nextLine(); 
                  set.add(line); 
            } 

            ArrayList list = new ArrayList(set); 
            Collections.sort(list); 

            int size = list.size(); 

            for(int i=0; i < size;i++){ 
                  sb.append(list.get(i)); 
                  sb.append(CR_LF); 
            } 

            ta.setText(sb.toString()); 
      } 
}); 

btn[n++].addActionListener(new ActionListener() { // distinct2 - 중복 라인 제거 + 카운트 
      public void actionPerformed(ActionEvent ae) { 
            String curText = ta.getText(); 
            StringBuffer sb = new StringBuffer(curText.length()); 

            prevText = curText; 
            String textFromParam1 = tfParam1.getText();
            
            if (textFromParam1.length() == 0) textFromParam1 = ","; 
            
           // Scanner 클래스와 반복문을 사용 curText를 라인 단위로 읽는다
            
            Scanner sc = new Scanner(curText);
            
            // 저장할 트리맵 만들어주
            TreeMap treeMap = new TreeMap();
            
            while ( sc.hasNextLine()) {
            	
            	String tmp = sc.nextLine();
            	
            	// 맵이 이미 문자열을 가지고 있으면
            	if ( treeMap.containsKey(tmp) ) {
            		// 밸류값을 얻어서 1 증가시키고 다시 넣어줌
            		Integer value = (Integer) treeMap.get(tmp);
            		treeMap.put(tmp, value + 1);
            	} else {
            		// 그렇지 않으면 1 그냥 넣어줌
            		treeMap.put(tmp, 1);
            	}
            	
            }
                   
            // 맵을 이터레이터로 꺼내기 위해 셋으로 만들고, 이터레이터화
            Set eSet = treeMap.entrySet();
            Iterator it = eSet.iterator();
            
            while (it.hasNext() ) {
            	
            	// 하나씩 꺼내면서
            	Map.Entry mapEntry = (Entry) it.next();
            	
            	// 키 값과 벨류 값을 얻어서
            	String tmp = (String) mapEntry.getKey();
            	Integer value = (Integer) mapEntry.getValue();
            	
            	// Param1에 아무것도 없으면, ","를 기본으로 추가시키고
            	// 있으면 해당 문자열을 중간에 삽입
            	sb.append(tmp).append(textFromParam1).append(value).append(CR_LF);
            		
            	
            	
            }
            
            ta.setText(sb.toString());

           /*

               다음의 코드를 완성하세요.



              1. Scanner클래스와 반복문을 이용해서 curText를 라인단위로 읽어서 TreeMap에 담는다.

                  1.1 TreeMap에 담을 때, 각 라인을 키로 저장하고 값으로는 중복회수를 저장한다.

                  1.2 TreeMap에 담을 때, 이미 같은 내용의 값이 저장되어 있는지 확인하고

                     1.1.1 이미 같은 내용이 저장되어 있으면, 해당 키의 값을 읽어서 1증가시키고

                     1.1.2  새로운 키값이면 1을 값으로 저장한다.

              2. param1에 지정된 문자열이 있으면, 그 문자열을 키와 값의 구분자로 사용하고

                  없으면, ','를 구분자로 지정한다.

              3. Iterator를 이용해서 TreeMap에 저장된 키와 값을 구분자와 함께 sb에 저장한다.

                 (TreeMap을 사용했기 때문에, 자동적으로 키값을 기준으로 오름차순 정렬된다.)

              4. sb에 저장된 내용을 TextArea에 보여준다.

           */

      } 
}); 
}       // end of registerEventHandler() 

public static void main(String[] args) { 
TextToolEx9 win = new TextToolEx9("Text Tool"); 
win.show(); 
} 

public TextToolEx9(String title) { 
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

for(int i=0;i < btn.length;i++) {  //<BTN.LENGTH;I++) style="COLOR: #008200" { // 버튼배열을 하단 Panel에 넣는다. 
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

