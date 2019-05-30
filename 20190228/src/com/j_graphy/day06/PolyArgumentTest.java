package com.j_graphy.day06;

import java.util.Scanner;

class Product {
	int price;
	int bonusPoint;
	
	Product(int price) {
		this(price, 10.0);
	}
	
	Product (int price, double percentage) {
//		if (0 <= percentage < 1) {
//			System.out.println("너무 많은 적립률입니다.");
//			return;
//		}
		
		this.price = price;
		bonusPoint = (int) (price * percentage);
	}
}

class Tv extends Product {							// 적립률을 제품마다 다르게 가져가고 싶을 때는 어떻게 할까?
	
	Tv() {
		super(100, 0.20); 
	}
	
	public String toString() {
		return "TV";
	}
}

class Computer extends Product {
	
	Computer() {
		super(200, 0.40);
	}
	
	public String toString() {
		return "Computer";
	}
}

class Audio extends Product {
	
	Audio() {
		super (50, 0.1);
	}
	
	public String toString() {
		return "Audio";
	}
}

class Buyer {
	int money = 1000;
	int bonusPoint = 0;
	Product[] item = new Product[10];
	int i = 0;
	
	void buy(Product p) {
		if( money < p.price) {
			System.out.println("잔액이 부족합니다.");
			return;
		}
		
		money -= p.price;
		bonusPoint += p.bonusPoint;
		item[i++] = p;
		System.out.println(p + "(을)/를 구매하셨습니다.");
	}
	
	void summary() {
		int sum = 0;
		String itemList = "";
		
		for (int i = 0; i < item.length; i++) {
			if (item[i] == null) break;
			sum += item[i].price;
			itemList += item[i] + ",";
		}
	}
}

public class PolyArgumentTest {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int selNum;
		Buyer b = new Buyer();
		
		System.out.println("저희 매장에 오신 것을 환영합니다.");
		
		do {

			System.out.println("구매하실 상품의 번호를 눌러주세요");
			System.out.println("1. Tv");
			System.out.println("2. Computer");
			System.out.println("3. Audio");
			System.out.print("입력> (4번을 누르시면 종료됩니다.)");
			selNum = scan.nextInt();
			
			switch(selNum) {
				case 1:
					b.buy(new Tv());
					break;
				case 2:
					b.buy(new Computer());
					break;
				case 3:
					b.buy(new Audio());
					break;
			}
			
			System.out.println("현재 남은 돈은 " + b.money + "만원 입니다.");
			System.out.println("현재 포인트는 " + b.bonusPoint + "점입니다.");
		} while (selNum != 4);
		
	}
	
}
