package com.j_graphy.day05;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PockerRankCheckTest {

	// Q 포커 게임의 순위(RANK)를 판별하는 메서드 작성
		// String rankCheck(Card[] cards)
		// 5장의 카드를 받아서, 순위를 문자열로 반환
		// 예)	카드 5장이 모두 같은 무늬 - "flush"
		// 		카드 5장이 연속하는 경우 - "straight"
		//		 카드 4장이 같은 숫자인 경우 - "fourcard"
		//		카드 3장의 숫자가 같고 2장의 숫자가 같음 - "full house"
		//		카드 2장의 숫자가 같은 것이 2장 - "two pair"
		//		카드 2장의 숫자가 같은 값이 1장 - "one pair"
		
		String rankCheck(Card[] cards) {
			String result = "";
			
			// 아예 카운팅을 해보자
			int[] kindCount = new int[4];
			int[] numberCount = new int[13];
			
			for(int i = 0; i < cards.length - 1; i++) {
				for (int j = 0; j < cards.length - 1 - i; j++) {
					if ( cards[j].number > cards[j+1].number) {
						Card tmp = cards[j];
						cards[j] = cards[j+1];
						cards[j+1] = tmp;
					}
				}
			}
			
			for (int i = 0; i < cards.length; i++) {
				
				kindCount[cards[i].kind - 1]++;
				numberCount[cards[i].number - 1]++;
				
			}
			
			boolean isFlush = false;
			boolean isStraight = false;
			
			//flush 체크 kind의 카운트가 5이면 flush true해주고 바로 break
			for (int i = 0; i < kindCount.length; i++) {
				if ( kindCount[i] == 5) {
					isFlush = true;
					break;
				}
			}
			
			
			// straight 체크 numberCount의 값이 1인 지점에서부터 반복하며 1인지 확인하고,
			// 1이 아닐 경우 스트레이트 false하고, 반복문 break
			if ( numberCount[0] == 1 && numberCount[12] == 1) {
				
				for (int i = 9; i < numberCount.length - 1; i++) {
					if ( numberCount[i] == numberCount[i+1])
						isStraight = true;
					else {
						isStraight = false;
						break;
					}
				}
				
			} else {
				
				outer:
				for (int i = 0; i < numberCount.length - 4; i++) {
					if ( numberCount[i] == 1 ) {
						
						for (int j = i; j < i + 4; j++) {				
							if ( numberCount[j] == numberCount[j+1] ) {				// 이 조건이 실행되지 않았다 (break outer가 실행되지 않았다)는 것은
								isStraight = true;					// 처음 1을 만난 지점부터 5개가 연속 1이라는 의미
							}
							
							else {
								isStraight = false;
								break outer;
							}
						}
						
						break;										// 즉, Straight라는 것이기 때문에 반복문을 빠져 나옴
					}
				}
			
			}
			
			// numberCount로 one, two pair, full house, triple, four card알아보기
			int fourCount = 0;
			int threeCount = 0;
			int twoCount = 0;
			for (int i = 0; i < numberCount.length; i++) {
				if ( numberCount[i] == 4)
					fourCount++;
				else if (numberCount[i] == 3)
					threeCount++;
				else if (numberCount[i] == 2)
					twoCount++;
			}
			
			// 먼저 flush와 straight의 가능성으로 판단
			if (isFlush && isStraight) {
				
				if (cards[4].number == 13 )
					result = "royal straight flush";
				else if (cards[0].number == 1 )
					result = "back straight flush";
				else
					result = "straight flush";
			
			} else if (isStraight) {
				
				if (cards[4].number == 13 )
					result = "mountain";
				else if (cards[0].number == 1 )
					result = "back straight";
				else
					result = "straight";
			
			} else if (isFlush) {
				
				result = "flush";
			
			} else {									// flush도 straight도 아닌 경우에
				
				if ( fourCount == 1) {
					
					result = "four card";
					
				} else if ( threeCount == 1) {
					
					if (twoCount == 1)
						result = "full house";
					else
						result = "triple";
					
				} else if ( twoCount == 2) {
					
					result = "two pair";
				
				} else if ( twoCount == 1) {
				
					result = "one pair";
				
				} else {
					
					result = "no rank";
				}
			}
			
			return result;					// 마지막 리턴값 반환
			
		}
		
		// 플러쉬 체크
		@Test
		void test01() {
			Card[] cArr = { new Card(1, 10), new Card(1, 2), new Card(1, 4), new Card(1, 6), new Card(1, 7) };
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
