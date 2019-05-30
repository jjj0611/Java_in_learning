package com.j_graphy.day05;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PockerRankCheck {

	// Q 포커 게임의 순위(RANK)를 판별하는 메서드 작성
	// String rankCheck(Card[] cards)
	// 5장의 카드를 받아서, 순위를 문자열로 반환
	// 예)	카드 5장이 모두 같은 무늬 - "flush"
	// 		카드 5장이 연속하는 경우 - "straight"
	//		 카드 4장이 같은 숫자인 경우 - "four card"
	//		카드 3장의 숫자가 같고 2장의 숫자가 같음 - "full house"
	//		카드 2장의 숫자가 같은 것이 2장 - "two pair"
	//		카드 2장의 숫자가 같은 값이 1장 - "one pair"
	
	String rankCheck(Card[] cards) {
		String result = "no rank";
		
		// straight을 검사하기 위해 먼저 num을 기준으로 카드 정렬
		// 정렬하는데 number가 1이면 1 혹은 13 취급을 해주어야 함.
		// 즉 A는 1 또는 14의 역할을 할 수 있음.
		for(int i = 0; i < cards.length - 1; i++) {
			for (int j = 0; j < cards.length - 1 - i; j++) {
				if ( cards[j].number > cards[j+1].number) {
					Card tmp = cards[j];
					cards[j] = cards[j+1];
					cards[j+1] = tmp;
				}
			}
		}
		
		// 작은 수 정렬이 되어 있기 때문에 isflush와 isStraight 한번에 체크 가능
		// straight를 셀 때 가장 중요한 13 -> 1 기능
		
		// samenum을 세는 것도 추가
		boolean isFlush = true;
		boolean isStraight = true;
		int sameNum = 0;
		// 아예 가장 작은 수로 1, 가장 큰수로 13이 있는 경우와 그렇지 않은 경우로 나눔
		if ( cards[0].number == 1 && cards[4].number == 13 ) {
				
			for (int i = 0; i < cards.length -1; i++) {
				
				if ( cards[i].kind != cards[i + 1].kind )
					isFlush = false;

				if ( cards[i].number == cards[i+1].number)
					sameNum++;
				
				
				//얘는 cards[1] 부터 검사를 해야해. 왜? 1과 13이 이미 확정 되어 있기 때문에
				// cards[1]부터 cards[4]까지 연속적인지 판단하면 됨
				if ( i == 0 )
					continue;
				
				if ( cards[i].number + 1 != cards[i+1].number)
					isStraight = false;
				
			}
						
		} else {														// 1과 13의 연속 가능성이 없는 경우
				
			for (int i = 0; i < cards.length - 1; i++) {
				
				if ( cards[i].kind != cards[i + 1].kind ) {
					isFlush = false;
				}
				
				if ( cards[i].number + 1 != cards[i+1].number) {
					
					isStraight = false;
				}

				if ( cards[i].number == cards[i+1].number)
					sameNum++;
				
			}
		}
		
		// 먼저 flush와 straight의 가능성으로 판단
		if (isFlush && isStraight)
			
			if (cards[4].number == 13 )
				result = "royal straight flush";
			else if (cards[0].number == 1 )
				result = "back straight flush";
			else
				result = "straight flush";
		
		else if (isStraight)
			
			if (cards[4].number == 13 )
				result = "mountain";
			else if (cards[0].number == 1 )
				result = "back straight";
			else
				result = "straight";
		
		else if (isFlush)
			
			result = "flush";
		
		else {								// flush도 straight도 아닌 경우 number가 같은 개수로 검사
			
			switch(sameNum) {

			case 1:							// 1짝만 같다고 하면 무조건 원페어
				result = "one pair";
				break;
			case 2:							// 2짝이 같다고 할 때 투페어 또는 트리플 가능성
				for (int i = 0; i < cards.length - 2; i++) {
					if ( cards[i].number == cards[i+1].number && cards[i+1].number == cards[i+2].number ) {
						result = "triple";
						break;
					} else
						result = "two pair";
				}
				break;
			case 3:							// 3짝이 같다고 할 때 풀하우스 혹은 포카드 가능성
				for (int i = 0; i < cards.length - 3; i++) {
					if ( cards[i].number == cards[i+1].number && cards[i+1].number == cards[i+2].number && cards[i+2].number == cards[i+3].number ) {
						result = "four card";
						break;
					} else
						result = "full house";
				}

			}
		
		}
		
		return result;					// 마지막 리턴값 반환
		
	}
	
	// 플러쉬 체크
	@Test
	void test01() {
		Card[] cArr = { new Card(1, 10), new Card(1, 2), new Card(1, 4), new Card(1, 6), new Card(1, 6) };
		assertTrue(rankCheck(cArr).equals("flush"));
	}
	
	@Test
	void test02() {
		Card[] cArr = { new Card(2, 7), new Card(2, 6), new Card(2, 13), new Card(2, 12), new Card(2, 1) };
		assertTrue(rankCheck(cArr).equals("flush"));
	}
	
	@Test
	void test03() {
		Card[] cArr = { new Card(3, 1), new Card(3, 4), new Card(3, 12), new Card(3, 7), new Card(3, 2) };
		assertTrue(rankCheck(cArr).equals("flush"));
	}
	
	@Test
	void test04() {
		Card[] cArr = { new Card(4, 1), new Card(4, 3), new Card(4, 11), new Card(4, 8), new Card(4, 5) };
		assertTrue(rankCheck(cArr).equals("flush"));
	}
	
	//스트레이트 체크
	@Test
	void test05() {
		Card[] cArr = { new Card(1, 5), new Card(3, 7), new Card(4, 6), new Card(1, 4), new Card(2, 8) };
		assertTrue(rankCheck(cArr).equals("straight"));
	}
	
	@Test
	void test06() {
		Card[] cArr = { new Card(2, 8), new Card(1, 9), new Card(3, 12), new Card(2, 11), new Card(2, 10) };
		assertTrue(rankCheck(cArr).equals("straight"));
	}
	
	//백스트레이트
	@Test
	void test07() {
		Card[] cArr = { new Card(3, 3), new Card(1, 2), new Card(1, 4), new Card(3, 5), new Card(2, 1) };
		assertTrue(rankCheck(cArr).equals("back straight"));
	}
	
	//마운틴
	@Test
	void test08() {
		Card[] cArr = { new Card(2, 10), new Card(3, 13), new Card(2, 1), new Card(4, 12), new Card(2, 11) };
		assertTrue(rankCheck(cArr).equals("mountain"));
	}
	
	//스트레이트 플러쉬
	@Test
	void test09() {
		Card[] cArr = { new Card(1, 6), new Card(1, 10), new Card(1, 8), new Card(1, 7), new Card(1, 9) };
		assertTrue(rankCheck(cArr).equals("straight flush"));
	}
	
	//백 스트레이트 플러쉬
	@Test
	void test10() {
		Card[] cArr = { new Card(2, 5), new Card(2, 2), new Card(2, 4), new Card(2, 1), new Card(2, 3) };
		assertTrue(rankCheck(cArr).equals("back straight flush"));
	}
	
	// 로얄 스트레이트 플러쉬
	@Test
	void test11() {
		Card[] cArr = { new Card(3, 12), new Card(3, 10), new Card(3, 11), new Card(3, 13), new Card(3, 1) };
		assertTrue(rankCheck(cArr).equals("royal straight flush"));
	}
	
	// 원페어
	@Test
	void test12() {
		Card[] cArr = { new Card(1, 10), new Card(2, 10), new Card(3, 1), new Card(4, 3), new Card(2, 5) };
		assertTrue(rankCheck(cArr).equals("one pair"));
	}
	
	// 투페어
	@Test
	void test13() {
		Card[] cArr = { new Card(1, 10), new Card(3, 10), new Card(2, 7), new Card(3, 7), new Card(1, 5) };
		assertTrue(rankCheck(cArr).equals("two pair"));
	}
	
	// 트리플
	@Test
	void test14() {
		Card[] cArr = { new Card(1, 11), new Card(3, 11), new Card(2, 11), new Card(1, 7), new Card(1, 6) };
		assertTrue(rankCheck(cArr).equals("triple"));
	}
	
	// 풀하우스
	@Test
	void test15() {
		Card[] cArr = { new Card(1, 2), new Card(2, 2), new Card(4, 2), new Card(3, 7), new Card(2, 7) };
		assertTrue(rankCheck(cArr).equals("full house"));
	}
	
	// 포카드
	@Test
	void test16() {
		Card[] cArr = { new Card(1, 6), new Card(2, 6), new Card(4, 6), new Card(3, 6), new Card(2, 13) };
		assertTrue(rankCheck(cArr).equals("four card"));
	}
	
	
	//강사님 테스트 예제
	@Test
	 void test21() {  // 같은 숫자가 2개면, 1 pair
	  Card[] cArr = { new Card(4, 2), new Card(4, 2)
	           ,new Card(3, 3), new Card(2, 4)
	           ,new Card(4, 5)};
	  assertTrue(rankCheck(cArr).equals("one pair"));
	 }

	 @Test
	 void test22() {  // 같은 숫자가 2개인개 2개면, 2 pair
	  Card[] cArr = { new Card(4, 2), new Card(4, 2)
	           ,new Card(3, 4), new Card(2, 4)
	           ,new Card(4, 5)};
	  assertTrue(rankCheck(cArr).equals("two pair"));
	 }

	 @Test
	 void test23() {  // 같은 숫자가 3개이면, Three Card
	  Card[] cArr = { new Card(4, 2), new Card(4, 2)
	           ,new Card(3, 2), new Card(2, 4)
	           ,new Card(4, 5)};
	  assertTrue(rankCheck(cArr).equals("triple"));
	 }

	 @Test
	 void test24() {  // 같은 숫자가 4개이면, Four Card
	  Card[] cArr = { new Card(4, 2), new Card(4, 2)
	           ,new Card(3, 2), new Card(2, 2)
	           ,new Card(4, 5)};
	  assertTrue(rankCheck(cArr).equals("four card"));
	 }

	 @Test
	 void test25() {  // three card와 1 pair가 같이 있으면, full house
	  Card[] cArr = { new Card(4, 2), new Card(4, 2)
	           ,new Card(3, 2), new Card(2, 4)
	           ,new Card(4, 4) };
	  assertTrue(rankCheck(cArr).equals("full house"));
	 }

	 @Test
	 void test26() {  // 같은 무늬 5장이면 flush
	  Card[] cArr = { new Card(4, 5), new Card(4, 2)
	           ,new Card(4, 7), new Card(4, 4)
	           ,new Card(4, 4)};
	  assertTrue(rankCheck(cArr).equals("flush"));
	 }

	 @Test
	 void test27() {  // 숫자가 연속이면 straight. 3,4,5,6,7
	  Card[] cArr = { new Card(4, 1), new Card(4, 2)
	           ,new Card(3, 3), new Card(2, 4)
	           ,new Card(4, 5)};
	  assertTrue(rankCheck(cArr).equals("back straight"));
	 }

	 @Test
	 void test28() {  // straight이면서 flush이면 staight flush
	  Card[] cArr = { new Card(4, 1), new Card(4, 2)
	           ,new Card(4, 3), new Card(4, 4)
	           ,new Card(4, 5)};
	  assertTrue(rankCheck(cArr).equals("back straight flush"));
	 }
	 
	 @Test
	 void test29() {  // 아무것도 아니면 no rank
	  Card[] cArr = { new Card(4, 8), new Card(4, 2)
	           ,new Card(3, 3), new Card(4, 4)
	           ,new Card(4, 5)};
	  assertTrue(rankCheck(cArr).equals("no rank"));
	 }
	
	

}
