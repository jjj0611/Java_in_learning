package com.j_graphy.day04;

class Tv {
	
	String color;
	boolean power;
	int channel;
	
	void power() { power = !power; }
	void channelUp() { ++channel;}
	void channelDown() {--channel;}
	
	Tv(String color, boolean power, int channel) {
		this.color = color;
		this.power = power;
		this.channel = channel;
	}
	
	Tv(){}

}
public class TvTest01 {

	public static void main(String[] args) {
		
		Tv t = new Tv();
		t.channel = 7;
		t.channelDown();
		System.out.println("현재 채널은 " + t.channel + "번 입니다.");
		
	}
	
}
