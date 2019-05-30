package com.j_graphy.day05;

import java.util.Scanner;

public class DeckTest {

	public static void main(String[] args) {
//		Scanner scan = new Scanner(System.in);
//		// 플레이어 수 입력받으면 유저 인스턴스 생성
//		System.out.print("몇 명의 플레이어가 게임하십니까?");
//		int playerNum = Integer.parseInt(scan.nextLine());
//		
//		// 유저 이름 입력받기
//		System.out.print("유저 이름을 ,(콤마)로 구분지어 입력하십시오.");
//		String userName = scan.nextLine();
//		String[] userNameArr = userName.split(",");
//		
//		// 입력받은 유저 수와 유저 이름으로 유저 인스턴스 생성
//		User[] user = new User[playerNum];
//		for (int i = 0; i < playerNum; i++) {
//			user[i] = new User();
//			user[i].userName = userNameArr[i];
//		}
//		
//		Dealer dealer = new Dealer();
//		// 한 게임에서 반복되는건 카드 한장씩 다 받고,
//		// 한명씩 돌아가면서 배팅하기 혹은 죽기
//		// 이걸 5번 반복
//		
//		Deck d = new Deck();
//		Card c = d.pick(0);
//		System.out.println(c);
//		
//		d.shuffle();
//		c = d.pick(0);
//		System.out.println(c);
		
		Game game = new Game();
		game.runGame();
		
		
	}
	
}

class Game {
	Scanner scan = new Scanner(System.in);
	Dealer dealer = new Dealer();
	User[] users;
	int battingMoeny;
	int turn;
	
	Game() {
		// 플레이어 수 입력받으면 유저 인스턴스 생성
		System.out.print("몇 명의 플레이어가 게임하십니까?");
		int userNum = Integer.parseInt(scan.nextLine());
		this.users = new User[userNum];
				
		// 유저 이름 입력받기
		System.out.print("유저 이름을 ,(콤마)로 구분지어 입력하십시오.");
		String userName = scan.nextLine();
		String[] userNameArr = userName.split(",");
		
		// 입력받은 유저 수와 유저 이름으로 유저 인스턴스 생성
		for (int i = 0; i < users.length; i++) {
			this.users[i] = new User();
			this.users[i].userName = userNameArr[i];
		}
	}
	
	void giveCard() {
		for (int i = 0; i < users.length; i++) {
			if ( this.users[i].inGame == false )
				continue;
			this.users[i].getCard(dealer.pick());
		}
	}
	
	void die(User user) {
		user.die();
	}
	
	void batting(User user) {
		System.out.print(user.userName + "님 얼마를 배팅하시겠습니까?");
		user.batting(Integer.parseInt(scan.nextLine()));
		this.battingMoeny += Integer.parseInt(scan.nextLine());
	}
	
	void printCard(User user) {
		System.out.println(user.userName + "님의 카드는");
		for (int i = 0; i < user.myCard.length; i++) {
			System.out.println(user.myCard[i]);
		}
	}
	
	void selectAction(User user) {
		System.out.println("1. 배팅하기");
		System.out.println("2. 죽기");
		System.out.print(user.userName + "님 선택해주세요.");
		int selNum = Integer.parseInt(scan.nextLine());
		
		switch (selNum) {
		case 1:
			batting(user);
			break;
		case 2:
			die(user);
			break;		
		}
		
	}
	
	void runTurn() {
		this.giveCard();
		for (int i = 0; i < this.users.length; i++ ) {
			printCard(this.users[i]);
			System.out.println(this.users[i].userName + "님의 카드입니다.");
			if ( this.users[i].inGame == true && this.turn > 2 )
				this.selectAction(this.users[i]);
			System.out.println("다음 플레이어로 가시려면 엔터를 입력하세요.");
			scan.nextLine();
		}
	}
	
	void runGame() {
		while(this.turn < 5) {
			this.runTurn();
			System.out.println("다음 턴으로 가시려면 엔터를 입력하세요.");
			scan.nextLine();
			this.turn++;
		}
	}
	
}

class User {
	Card[] myCard = new Card[5];
	String userName;
	boolean inGame = true;
	int money = 1000000;
	int cardNum = 0;
	
	
	// 딜러로 부터 카드 받으면 내 카드에 추가
	void getCard(Card c) {
		myCard[cardNum] = c;
		cardNum++;
	}
	
	// 해당 게임을 포기하는메서드
	void die() {
		System.out.println(this.userName + "님 죽었습니다.");
		inGame = false;
	}
	
	// 딜러로 부터 카드 받은 후 배팅 금액 설정, 배팅 금액을 입력하면 내 돈과 비교하여 많으면 가능
	// 내 돈에서 차감 후 해당 판돈 만큼 돌려주어야 함
	int batting(int money) {
		if ( this.money >= money) {
			this.money -= money;
			return money;
		} 
		die();
		return 0;
	}

	void win(int money) {
		this.money += money;
	}
}

class Dealer {
	
	final int CARD_NUM = 52;
	Card cardArr[] = new Card[CARD_NUM];
	int index = 0;
	
	Dealer() {
		Deck deck = new Deck();
		deck.shuffle();
		this.cardArr = deck.cardArr;
	}
	
	// 섞은 상태에서 0에서 부터 한장씩 나눠줌
	Card pick() {
		if(index == CARD_NUM) {
			Deck deck = new Deck();
			deck.shuffle();
			this.cardArr = deck.cardArr;
			this.index = 0;
			return cardArr[this.index++];
		}
		return cardArr[index++];
	}
		
//	Card pick(int index) {
//		
//		return cardArr[index];
//	
//	}
//	
//	Card pick() {
//	
//		int index = (int) (Math.random() * CARD_NUM);
//		return pick(index);
//		
//	}
	
}


class Deck {
	
	final int CARD_NUM = 52;
	Card cardArr[] = new Card[CARD_NUM];
	
	Deck() {
		int i = 0;
		
		for (int k = Card.KIND_MAX; k > 0; k--) {
			for (int n = Card.NUM_MAX; n > 0; n--) {
				cardArr[i++] = new Card(k, n);
			}
		}
	}
	
	void shuffle () {
		
		for (int i = 0; i < cardArr.length; i++) {
			int r = (int) (Math.random() * CARD_NUM);
			
			Card tmp = cardArr[i];
			cardArr[i] = cardArr[r];
			cardArr[r] = tmp;
		}
		
	}
	
//	Card pick(int index) {
//			
//		return cardArr[index];
//	
//	}
//	
//	Card pick() {
//	
//		int index = (int) (Math.random() * CARD_NUM);
//		return pick(index);
//		
//	}
	
}

class Card {
	static final int KIND_MAX = 4;
	static final int NUM_MAX = 13;
	
	static final int SPADE = 4;
	static final int DIAMOND = 3;
	static final int HEART = 2;
	static final int CLOVER = 1;
	
	int kind;
	int number;
	
	Card () {
		this(SPADE, 1); 
	}
	
	Card(int kind, int number){
		this.kind = kind;
		this.number = number;
	}
	
	public String toString() {
		String[] kinds = {"", "CLOVER", "HEART", "DIAMOND", "SPADE"};
		String numbers = "0123456789XJQK";
		
		return "kind : " + kinds[this.kind] + ", " + "number : " + numbers.charAt(this.number);
		
	}
}