package com.j_graphy.day12;

import java.awt.*; 
import java.awt.event.*; 
import java.util.*;
import java.util.Map.Entry;
import java.util.regex.*;        // Pattern, Matcher클래스를 사용하기 위해 추가
import java.awt.datatransfer.*;
import java.awt.Toolkit;

import java.text.*; 

public class TextToolEx12 extends Frame implements WindowListener { 
	
	TextArea ta; 
	TextField tfParam1, tfParam2; 
	Panel pNorth, pSouth; 
	Label lb1, lb2; 
	Checkbox option;
	Button copy;
	MenuBar mb;
	Menu mFile;
	MenuItem miOpen;
	MenuItem miSave;
	
	String[] btnName = { 
	"Undo",          // 작업이전 상태로 되돌림 
	"짝수줄삭제",  // 짝수줄을 삭제하는 기능 
	"문자삭제",     // Param1에 지정된 문자들을 삭제하는 기능 
	"trim",            // 라인의 앞뒤 공백을 제거 
	"빈줄삭제",     // 빈 줄 삭제 
	"접두사추가",  // Param1과 Param2의 문자열을 각 라인의 앞뒤에 붙이는 기능 
	"substring",    // Param1과 Param2에 지정된 문자열을 각 라인에서 제거하는 기능 
	"substring2",  // Param1과 Param2에 지정된 문자열로 둘러싸인 부분을 남기고 제거하는 기능 
	"distinct",      // 중복값제거한 후 정렬해서 보여주기 
	"distinct2",    // 중복값제거한 후 정렬해서 보여주기 - 중복카운트 포함 
	"패턴적용",    // 데이터에 지정된 패턴 적용하기 
	"패턴제거",    // 데이터에 적용된 패턴 제거하기 
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
			prevText = curText;
		   
			if ( option.getState() ) {
				
				try {
					// 1. TextArea ta의 텍스트를 가져온다.
					// 2. 작업의 결과를 저장할 StringBuffer sb 를 생성한다.
					Scanner sc = new Scanner(curText);			  			  
					StringBuffer sb = new StringBuffer();
					
					// 숫자가 아닐 때 어떻게 처리할 것인가?
					// 아무일도 안일어나게 하자
					int lineNum = Integer.valueOf(tfParam1.getText());
					
					for ( int i = 1; sc.hasNextLine(); i++) {
						// 짝수줄이면 건너 뛰기
						if ( i == lineNum) {
						// 저장하지 않고 부르기만, 이 작업을 안하면 그냥 안부름
							sb.append(sc.nextLine() + "\n");
						} else {
						// 짝수줄 아닐 때 저장
							sc.nextLine();
						}
						  
					}
		  
					ta.setText(sb.toString());
				} catch (Exception e) {}
				
				  
				
				
			} else {
				
				// 1. TextArea ta의 텍스트를 가져온다.
				Scanner sc = new Scanner(curText);
				  
				// 2. 작업의 결과를 저장할 StringBuffer sb 를 생성한다.
				  
				StringBuffer sb = new StringBuffer();
				  
				for ( int i = 1; sc.hasNextLine(); i++) {
					// 짝수줄이면 건너 뛰기
					if ( i % 2 == 0) {
					// 저장하지 않고 부르기만, 이 작업을 안하면 그냥 안부름
						sc.nextLine();
					} else {
					// 짝수줄 아닐 때 저장
						sb.append(sc.nextLine() + "\n");
					}
					  
				}
	  
				ta.setText(sb.toString()); 
				
			}
	
	     } 
	}); 
	
	btn[n++].addActionListener(new ActionListener() { // 문자삭제 - Param1에 지정된 문자를 삭제하는 기능 
	     
		public void actionPerformed(ActionEvent ae) { 
	    	
			String curText = ta.getText(); 
            StringBuffer sb = new StringBuffer(curText.length()); 

            prevText = curText;
            
        	// 1. TextField Param1의 값을 가져온다
            String p1 = tfParam1.getText();
			
			if ( option.getState() ) {
				
				for (int i = 0; i < curText.length(); i++) {
	            	 char ch = curText.charAt(i);
	            	 
	            	 // p1.indexOf(ch) != -1이 아니면 추가하면 되지?
	            	 if ( p1.indexOf(ch) != -1)
	            		 sb.append(ch);
	             }
				
			} else {

	             // 반복문을 이용해서 curText를 한글자씩 읽어서 Param1에서 가져온 문자열에 포함되어 있는지 확인
	             // 포함되어 있으면 sb에 저장하지 않고, 포함되어 있지 않으면 sb에 저장
	             // 작업이 끝난 후 sb에 남긴 내용을 ta에 보여준다.
	             
//	             for (int i = 0; i < curText.length(); i++) {
//	            	 // curText에 있는 한 문자 마다 존재 하는지 안하는지 파악
//	            	 boolean notExisting = true;
//	            	 // p1에 담긴 문자열을 하나씩 돌면서
//	            	 // 하나라도 같을게 나오면 false로 바꿔준 후 반복문을 빠져나가서
//	            	 for (int j = 0; j < p1.length(); j++) {
//	            		 if ( p1.charAt(j) == curText.charAt(i)) {
//	            			 notExisting = false;
//	            			 break;
//	            		 } 
//	            	 }
//	            	 // j 반복문이  모두 끝나고도 여전히 notExisting이 true이면 해당 문자는 Param1에서 가져온 문자열에 없는 문자이므로
//	            	 // sb에 추가해주어서 삭제한다.
//	            	 if (notExisting)
//	        			 sb.append(curText.charAt(i));
//	            	 
//	             }
	             
	             for (int i = 0; i < curText.length(); i++) {
	            	 char ch = curText.charAt(i);
	            	 
	            	 if ( p1.indexOf(ch) == -1)
	            		 sb.append(ch);
	             }
	                
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
//          String tmp = sc.nextLine();
//          tmp = tmp.trim();
//          sb.append(tmp);
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
	
	btn[n++].addActionListener(new ActionListener() { // 접두사 - 각 라인에 접두사, 접미사 붙이기 
		
		public void actionPerformed(ActionEvent ae) { 
			String curText = ta.getText(); 
	        StringBuffer sb = new StringBuffer(curText.length()); 

	        prevText = curText; 
	            
	        // param1과 param2의 값을 가져온다.
	        String textFromParam1 = tfParam1.getText();
	        String textFromParam2 = tfParam2.getText();
	            
	        // Scanner 클래스와 반복문으로 curText를 라인 단위로 읽음
	        Scanner sc = new Scanner(curText);
	            
	        while (sc.hasNextLine() ) {
	            	
	        	// 읽어온 라인의 앞 뒤에 param1과 param2의 값을 붙여서 sb에 담는다
//	        	String tmp = sc.nextLine();
//	        	sb.append(textFromParam1 + tmp + textFromParam2).append(CR_LF);
	        	sb.append(textFromParam1 + sc.nextLine() + textFromParam2).append(CR_LF);
	        	//sb.append(textFromParam1).append(sc.nextLine()).append(textFromParam2).append(CR_LF);
	            	
	        }
	            
	        ta.setText(sb.toString());
	
	     } 
	}); 
	
	btn[n++].addActionListener(new ActionListener() { // substring - 문자열 자르기 
	     
		public void actionPerformed(ActionEvent ae) { 
	    	 
			String curText = ta.getText(); 
	        StringBuffer sb = new StringBuffer(curText.length()); 

	        prevText = curText;
	            
	        // param1과 param2의 값을 가져온다
	        String textFromParam1 = tfParam1.getText();
	        String textFromParam2 = tfParam2.getText();
	            
	        // Scanner 활용 라인 단위로 읽음
	        Scanner sc = new Scanner(curText);
	        int from = textFromParam1.length();
	        int to = textFromParam2.length();
	            
	        while ( sc.hasNextLine() ) {
	            	
	        	String tmp = sc.nextLine();
	            // textFromParam1과 textFromParam2의 길이의 합이 tmp.length보다 크면 그냥 지워져야 되지?
	            if ( from + to >= tmp.length() )
	            	tmp = "";
	            else {
	            	// 시작 인덱스를 textFromParam1의 길이만큼으로 하면 거기까지 생략된뒤 tmp에서 substring 시작
	            	// 끝 인덱스를 tmp의 전체 길이 - textFromParam2의 전체 길이를 하면 접미사 제외
	            	tmp = tmp.substring(from, tmp.length() - to);
	            }
	            	
	            sb.append(tmp).append(CR_LF);
	            	
	        }
	            
	        ta.setText(sb.toString());
	
	     } 
	}); 
	
	btn[n++].addActionListener(new ActionListener() { // substring2 - 지정된 문자를 찾아서 그 위치까지 잘라내기 
		
		public void actionPerformed(ActionEvent ae) { 
			
			String curText = ta.getText(); 
             StringBuffer sb = new StringBuffer(curText.length()); 

             prevText = curText; 
	    	 String textFromParam1 = tfParam1.getText();
             String textFromParam2 = tfParam2.getText();
             
             Scanner sc = new Scanner(curText);
             
             if ( option.getState() ) {
            	  
            	 while(sc.hasNextLine() ) {
	            	 
	            	 // 한줄씩 뽑아낸 문자열마다 from과 to를 체크해야 함
	            	 int from, to;
	            	 String tmp = sc.nextLine();
	            	 // 시작 인덱스 찾기
	            	 // param1에 들어있던 문자열이 tmp에 포함 안되어 있으면 from은 0(처음부터 섭스트링)
	            	 if (tmp.indexOf(textFromParam1) == -1)
	            		 from = 0;
	            	 else
	            		 from = tmp.indexOf(textFromParam1);
	            	 
	            	 // 끝 인덱스를 tmp의 뒤에서부터 찾기
	            	 // param2에 들어 있던 문자열이 tmp에 포함 안되어 있으면 마지막지점(tmp의 길이)까지 섭스트링
	            	 if (tmp.lastIndexOf(textFromParam2) == -1)
	            		 to = tmp.length();
	            	 else
	            		 to = tmp.lastIndexOf(textFromParam2);
	            	 
	            	 if (tmp.length() < to - from) return;
	
	            	 // from으로 찾은 인덱스는 textFromParam1의 문자열이 시작하는 인덱스
	            	 // 즉 거기부터 시작하게 되면 textFromParam1을 포함하게 된다.
	            	 // 그렇기 떄문에 그 길이만큼 더해주어야 해당 텍스트를 포함하지 않고 잘림
	            	 // to도 textFromParam2가 포함된 문자의 시작점을 나타내기 떄문에
	            	 // 그냥 to 그대로 지정해주어도 해당 인덱스는 제외하고 프린트하게 됨
	            	 sb.append(tmp.substring(from, from + textFromParam1.length())).append(tmp.substring(to, to + textFromParam2.length())).append(CR_LF);
            	 
	             }
            	 
             } else {
            	
	             while(sc.hasNextLine() ) {
	            	 
	            	 // 한줄씩 뽑아낸 문자열마다 from과 to를 체크해야 함
	            	 int from, to;
	            	 String tmp = sc.nextLine();
	            	 // 시작 인덱스 찾기
	            	 // param1에 들어있던 문자열이 tmp에 포함 안되어 있으면 from은 0(처음부터 섭스트링)
	            	 if (tmp.indexOf(textFromParam1) == -1)
	            		 from = 0;
	            	 else
	            		 from = tmp.indexOf(textFromParam1) + textFromParam1.length();
	            	 
	            	 // 끝 인덱스를 tmp의 뒤에서부터 찾기
	            	 // param2에 들어 있던 문자열이 tmp에 포함 안되어 있으면 마지막지점(tmp의 길이)까지 섭스트링
	            	 if (tmp.lastIndexOf(textFromParam2) == -1)
	            		 to = tmp.length();
	            	 else
	            		 to = tmp.lastIndexOf(textFromParam2);
	            	 
	            	 
	            	 if (tmp.length() < to - from) return;
	            	 // from으로 찾은 인덱스는 textFromParam1의 문자열이 시작하는 인덱스
	            	 // 즉 거기부터 시작하게 되면 textFromParam1을 포함하게 된다.
	            	 // 그렇기 떄문에 그 길이만큼 더해주어야 해당 텍스트를 포함하지 않고 잘림
	            	 // to도 textFromParam2가 포함된 문자의 시작점을 나타내기 떄문에
	            	 // 그냥 to 그대로 지정해주어도 해당 인덱스는 제외하고 프린트하게 됨
	            	 sb.append(tmp.substring(from, to)).append(CR_LF);
	             }
             
             }
             
             ta.setText(sb.toString());
	
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
	        
			if ( option.getState() ) {
				
				Collections.sort(list, new Comparator() {
					@Override
					public int compare(Object o1, Object o2) {
						if ( !(o1 instanceof String && o2 instanceof String) ) return -1;
						
						String s1 = (String) o1;
						String s2 = (String) o2;
						
						return s1.compareTo(s2) * -1;
					}
					
				});
				
			} else {
				Collections.sort(list); 
			}
			
			int size = list.size(); 
				
	        for(int i=0; i < size;i++){ 
	        	sb.append(list.get(i)).append(CR_LF); 
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
            
            
            // 저장할 트리맵 만들어주기
            TreeMap treeMap = new TreeMap();
            
            // option에 따라 정렬 방식 다르게
            if ( option.getState() ) {
            	treeMap = new TreeMap(treeMap.comparator().reversed()); 
            } 
            
            
           
            
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
            Iterator it = treeMap.entrySet().iterator();
            
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
	
	     } 
	}); 
	
	btn[n++].addActionListener(new ActionListener() { // 패턴적용 
	     public void actionPerformed(ActionEvent ae) { 
	           String curText = ta.getText(); 
	           StringBuffer sb = new StringBuffer(curText.length()); 
	
	           prevText = curText; 
	
	           String pattern = tfParam1.getText(); 
	           String delimiter = tfParam2.getText(); 
	
	           if(delimiter.length()==0) delimiter = ","; 
	
	           Scanner s = new Scanner(curText); 
	
	           for(int i=0;s.hasNextLine();i++) { 
	                 String line = s.nextLine(); 
	                 
	                 String[] tokens = line.split(delimiter); 
	
	                 sb.append(MessageFormat.format(pattern,tokens)); 
	                 sb.append(CR_LF); 
	           } 
	
	           ta.setText(sb.toString()); 
	     } 
	}); 
	
	btn[n++].addActionListener(new ActionListener() { // 패턴제거 
	     public void actionPerformed(ActionEvent ae) { 
	           String curText = ta.getText(); 
	           StringBuffer sb = new StringBuffer(curText.length()); 
	
	           prevText = curText; 
	
	           String pattern = tfParam1.getText(); 
	           String delimiter = tfParam2.getText(); 
	
	           Pattern p = Pattern.compile(pattern); 
	
	           if(delimiter.length()==0) delimiter = ","; 
	           
	           // 1. 라인 단위로 읽기
	           Scanner sc = new Scanner(curText);
	           
	           while ( sc.hasNextLine() ) {
	        	   
	        	   // 한줄씩 뽑아내서
	        	   String tmp = sc.nextLine(); 
	        	   // 2. 패턴과 일치하는지 확인
	        	   // 일치하는 데이터를 뽑아내야 하는데, 어떤 메서드로 뽑아낼것이냐?
	        	   // 3. m의 그룹을 하나씩 돌려가면서 그룹마다 delimiter와 함께 추가하기
	        	   Matcher m = p.matcher(tmp);
	        	   if ( m.find() ) {
	        		   for ( int i = 1; i <= m.groupCount(); i++) {
	        			   String tmp2 = m.group(i);
	        			   sb.append(tmp2).append(delimiter);
	        		   }
	        	   } else {
	        		   sb.append(tmp);
	        	   }
	        	   
	        	   sb.append(CR_LF);
	           }
	           
	           // sb의 내용을 TextArea에 보여준다
	           ta.setText(sb.toString());
	
	         
	     } 
	});
	
	copy.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String curText = ta.getText();
			StringSelection stringSelection = new StringSelection(curText);
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(stringSelection, null);
	
		}
		
	});
	
//	miOpen.addActionListener(new ActionListener() {
//		
//		
//		
//	});
//	
//	miSave.addActionListener(new ActionListener() {
//		
//	});
	
	}       // end of registerEventHandler() 
	
	public static void main(String[] args) { 
		
		TextToolEx12 win = new TextToolEx12("Text Tool"); 
		win.show(); 
	} 
	
	public TextToolEx12(String title) { 
		
		super(title); 
		
		option = new Checkbox("option");
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
		copy = new Button("copy");
		
		pNorth.setLayout(new FlowLayout()); 
		pNorth.add(option);
		pNorth.add(lb1); 
		pNorth.add(tfParam1); 
		pNorth.add(lb2); 
		pNorth.add(tfParam2); 
		pNorth.add(copy);
		
		pSouth.setLayout(new GridLayout(2,10)); 
		
		for(int i=0;i < btn.length;i++) {             // 버튼배열을 하단 Panel에 넣는다. 
		     pSouth.add(btn[i]); 
		} 
		
		add(pNorth,"North"); 
		add(ta,"Center"); 
		add(pSouth,"South"); 
		
		setBounds(100, 100, 600, 300); 
		ta.requestFocus(); 
		registerEventHandler(); 
		
		mb = new MenuBar();
		mFile = new Menu("File");
		miOpen = new MenuItem("Open");
		miSave = new MenuItem("Save");
		
		mFile.add(miOpen);
		mFile.add(miSave);
		mb.add(mFile);
		setMenuBar(mb);
		
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

/*
1. '짝수줄삭제'버튼 - param1에 숫자 n을 입력받아서  n번째 줄을 삭제할 수 있도록 개선

옵션이 체크되어 있으면 n번째 줄만 남기고 모두 삭제



2. '문자삭제'버튼 -  옵션이 체크되어 있으면, 특정문자만 남기고 삭제



3. 'substring2'버튼 -옵션이 체크되어 있으면, param1과 param2에 지정된 문자를 제외하고 삭제



4. 'distinct'버튼 - 옵션이 체크되어 있으면, 내림차순정렬



5. 'distinct2'버튼 - 옵션이 체크되어 있으면, 내림차순정렬



6. '클립보드복사'버튼 - TextArea의 내용을 클립보드로 복사하는 기능



7. 메뉴를 달아서 파일을 열고 저장하는 기능

*/

// option 기능을 어떻게 구현할 것인가?
// option 추가해서 옵션의 상태가 체크드인지 아닌지 확인하고
// 체크드일 때와 아닐떄의 버튼의 기능을 분기

