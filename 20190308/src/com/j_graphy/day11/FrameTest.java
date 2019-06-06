package com.j_graphy.day11;

import java.awt.*;

class FrameTest { 
	
	public static void main(String args[]) { 
	
		Frame f = new Frame("Login"); // Frame객체를 생성한다.
		f.setSize(300, 200); // Frame의 크기를 설정한다
		f.setLayout(null);
		Button b = new Button("확인");
		b.setSize(100, 50);
		b.setLocation(100, 75);
		f.add(b);
		f.setVisible(true); // 생성한 Frame을 화면에 보이도록 한다. } }
	}
}