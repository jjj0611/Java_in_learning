package com.j_graphy.day12;

/* [문제8] TextArea의 라인의 내용중 중복된 것을 제고하고 정렬해서 보여주는 'distinct'버튼을  구현하세요. */

import java.awt.*; 
import java.awt.event.*; 
import java.util.*; 

public class TextToolEx8 extends Frame implements WindowListener 
{ 
      TextArea ta; 
      TextField tfParam1, tfParam2; 
      Panel pNorth, pSouth; 
      Label lb1, lb2; 

      String[] btnName = { 
            "Undo",             // 작업이전 상태로 되돌림 
            "짝수줄삭제",     // 짝수줄을 삭제하는 기능 
            "문자삭제",        // Param1에 지정된 문자들을 삭제하는 기능 
            "trim",               // 라인의 앞뒤 공백을 제거 
            "빈줄삭제",        // 빈 줄 삭제 
            "접두사추가",     // Param1과 Param2의 문자열을 각 라인의 앞뒤에 붙이는 기능 
            "substring",       // Param1과 Param2에 지정된 문자열을 각 라인에서 제거하는 기능 
            "substring2",      // Param1과 Param2에 지정된 문자열로 둘러싸인 부분을 남기고 제거하는 기능 
            "distinct",           // 중복값제거한 후 정렬해서 보여주기 
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
                            /*  내용생략 */

                  } 
            }); 

            btn[n++].addActionListener(new ActionListener() { // 문자삭제 - Param1에 지정된 문자를 삭제하는 기능 
                  public void actionPerformed(ActionEvent ae) { 
                            /*  내용생략 */

                  } 
            }); 

            btn[n++].addActionListener(new ActionListener() { // trim - 라인의 좌우공백을 제거하는 기능 
                  public void actionPerformed(ActionEvent ae) { 
                            /*  내용생략 */

                  } 
            }); 

            btn[n++].addActionListener(new ActionListener() { // 빈줄삭제 - 빈 줄 삭제 
                  public void actionPerformed(ActionEvent ae) { 
                            /*  내용생략 */

                  } 
            }); 

            btn[n++].addActionListener(new ActionListener() { // 접두사 - 각 라인에 접두사, 접미사 붙이기 
                  public void actionPerformed(ActionEvent ae) { 
                            /*  내용생략 */

                  } 
            }); 

            btn[n++].addActionListener(new ActionListener() { // substring - 문자열 자르기 
                  public void actionPerformed(ActionEvent ae) { 
                            /*  내용생략 */

                  } 
            }); 

            btn[n++].addActionListener(new ActionListener() { // substring2 - 지정된 문자를 찾아서 그 위치까지 잘라내기 
                  public void actionPerformed(ActionEvent ae) { 
                        String curText = ta.getText(); 
                        StringBuffer sb = new StringBuffer(curText.length()); 

                        prevText = curText; 

                        String param1 = tfParam1.getText(); 
                        String param2 = tfParam2.getText(); 

                        Scanner s = new Scanner(curText); 

                        for(int i=0;s.hasNextLine();i++) { 
                              String line = s.nextLine(); 

                              int from = line.indexOf(param1); 
                              int to = line.lastIndexOf(param2); 

                              from = (from==-1)? 0 : from + param1.length(); 
                              to = (to==-1)? line.length() : to; 
                              
                              if( from > to) return; 

                              sb.append(line.substring(from, to)); 
                              sb.append(CR_LF); 
                        } 

                        ta.setText(sb.toString()); 
                  } 
            }); 

            btn[n++].addActionListener(new ActionListener() { // distinct - 중복 라인 제거 
                  public void actionPerformed(ActionEvent ae) { 
                        String curText = ta.getText(); 
                        StringBuffer sb = new StringBuffer(curText.length()); 

                        prevText = curText; 
                        
                        //해쉬셋 만들기
                        HashSet hashSet = new HashSet();
                        
                        Scanner sc = new Scanner(curText);
                        
                        // 중복을 없애기 위해서 하나씩 꺼내면서 해쉬셋에 넣어줌
                        while (sc.hasNextLine()) {
                        	
                        	String tmp = sc.nextLine();
                        	hashSet.add(tmp);
                        	
                        }
                        
                        
                        // 해쉬 셋을 정렬하여 이터레이터로 꺼내줌
                        ArrayList list = new ArrayList(hashSet);
                        Collections.sort(list);
                        // 근데 여기서 요구 사항에 왜 정렬하는 부분이 들어간거지?                 
                        
                        ListIterator it = list.listIterator();
                        
                        while(it.hasNext()) {
                        	             
                        	sb.append(it.next()).append(CR_LF);
                        }
                        
                        ta.setText(sb.toString());
                       /*

                           다음의 코드를 완성하세요.

                          1. Scanner클래스와 반복문을 이용해서 curText를 라인단위로 읽어서 HashSet에 담는다.

                          2. HashSet의 내용을 ArrayList로 옮긴다음 정렬한다.(Collections의 sort()사용)

                          3. 정렬된 ArrayList의 내용을 sb에 저장한다.

                          4. sb에 저장된 내용을 TextArea에 보여준다.

                       */
                       
                  } 
            }); 
      }       // end of registerEventHandler() 

      public static void main(String[] args) { 
            TextToolEx8 win = new TextToolEx8("Text Tool"); 
            win.show(); 
      } 

      public TextToolEx8(String title) { 
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

