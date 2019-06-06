package com.j_graphy.day11;

import java.awt.*; 
import java.awt.event.*;

class FrameTest3 {

	public static void main(String args[]) { 
		
		Frame f = new Frame("Login"); // Frame객체를 생성한다. 
		f.setSize(300, 200); // Frame의 크기를 설정한다.
	
		// EventHandler클래스의 객체를 생성해서 Frame의 WindowListener로 등록한다. 
		f.addWindowListener(new EventHandler()); 
		f.addKeyListener(new KeyEventHandler());
		
		//이벤트 처리기를 생성해서 이벤트 소스와 연결
		f.addMouseListener(new MouseEventHandler());
		
	
		Button b = new Button("OK");
		f.add(b);
		b.addActionListener((ActionListener) new ActionEventListener());
		f.setVisible(true); // 생성한 Frame을 화면에 보이도록 한다.
	
	}
	
}

class ActionEventListener implements ActionListenr {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}


class KeyEventHandler implements KeyListener {

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("keyPressed");
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}

class MouseEventHandler implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("mouse button clicked!!!");
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

class EventHandler implements WindowListener { 
	
	public void windowOpened(WindowEvent e) {} 
	public void windowClosing(WindowEvent e) { // Frame의 닫기 버튼을 눌렀을 때 호출된다. 
		e.getWindow().setVisible(false); // Frame을 화면에서 보이지 않도록 하고 
		e.getWindow().dispose(); // 메모리에서 제거한다.}
		System.exit(0); // 프로그램을 종료한다. 
		} 
	
	public void windowClosed(WindowEvent e) {} // 아무내용도 없는 메서드 구현 
	public void windowIconified(WindowEvent e) {} 
	public void windowDeiconified(WindowEvent e) {} 
	public void windowActivated(WindowEvent e) {} 
	public void windowDeactivated(WindowEvent e) {}

}