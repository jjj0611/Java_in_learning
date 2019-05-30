package com.j_graphy.day05;

public class test2 {

public static void main(String[] args) {
		
		int[] kindCount = new int[4];
		int[] numberCount = new int[13];
		
		Card[] cards = { new Card(1, 5), new Card(3, 7), new Card(4, 6), new Card(1, 4), new Card(2, 8) };
		
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
		
		for (int i = 0; i < cards.length; i++) {
			
			kindCount[cards[i].kind - 1]++;
			numberCount[cards[i].number - 1]++;
			
		}
		
		// flush 체크
		boolean isFlush = false;
		for (int i = 0; i < kindCount.length; i++) {
			if ( kindCount[i] == 5) {
				isFlush = true;
				break;
			}
		}
		
		// 작은 수 정렬이 되어 있기 때문에 isStraight 체크 가능
		// straight를 셀 때 가장 중요한 13 -> 1 기능
		
		boolean isStraight = true;
		// 아예 가장 작은 수로 1, 가장 큰수로 13이 있는 경우와 그렇지 않은 경우로 나눔
		// 너무 백스트레이트같은거만 생각했음
		// 이것에 대한 대비가 필요
		// 1, 10, 11, 12, 13	47		=> 10, 11, 12
		if ( cards[0].number == 1 && cards[4].number == 13 ) {
				
			for (int i = 1; i < cards.length -1; i++) {
				
				//얘는 cards[1] 부터 검사를 해야해. 왜? 1과 13이 이미 확정 되어 있기 때문에
				// cards[1]부터 cards[4]까지 연속적인지 판단하면 됨
				if ( cards[i].number + 1 != cards[i+1].number)
					isStraight = false;
				
			}
						
		} else {														// 1과 13의 연속 가능성이 없는 경우
				
			for (int i = 0; i < cards.length - 1; i++) {
				
				if ( cards[i].number + 1 != cards[i+1].number) {
					
					isStraight = false;
				}

			}
		}
		
		// flush와 straight가 아닌 경우 판단하기 위해서 numCount가 2개 이상인 것의 개수를 구함
		int fourNumCount = 0;
		int threeNumCount = 0;
		int twoNumCount = 0;
		int oneNumCount = 0;
		
		for (int i = 0; i < numberCount.length; i++) {
			if ( numberCount[i] == 4 )
				fourNumCount++;
			else if( numberCount[i] == 3 )
				threeNumCount++;
			else if ( numberCount[i] == 2 )
				twoNumCount++;
			else if ( numberCount[i] == 1 )
				oneNumCount++;
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
		
		} else {								// flush도 straight도 아닌 경우 number가 같은 개수로 검사
												
			if ( fourNumCount == 1 && oneNumCount == 1)				// fourNumCount, threeNumCount, twoNumCount, oneNumCount의 경우의 수는
				result = "four card";								// 1, 0, 0, 1
			else if ( threeNumCount == 1 && twoNumCount == 1 )		// 0, 1, 1, 0
				result = "full house";
			else if ( threeNumCount == 1 && oneNumCount == 2)		// 0, 1, 0, 2
				result = "triple";
			else if ( twoNumCount == 2 && oneNumCount == 1)			// 0, 0, 2, 1
				result = "two pair";
			else if ( twoNumCount == 1 && oneNumCount == 3)			// 0, 0, 1, 3
				result = "one pair";
			else
				result = "no rank";
			
		}
		
		System.out.println(isFlush);
		System.out.println(isStraight);
		System.out.println(fourNumCount);
		System.out.println(threeNumCount);
		System.out.println(twoNumCount);
		System.out.println(oneNumCount);
		
		
		
		
		
//		for(int i = 0; i < cArr.length - 1; i++) {
//			for (int j = 0; j < cArr.length - 1 - i; j++) {
//				if ( cArr[j].number > cArr[j+1].number) {
//					Card tmp = cArr[j];
//					cArr[j] = cArr[j+1];
//					cArr[j+1] = tmp;
//				}
//			}
//		}
//		
//		for (int i = 0; i < cArr.length; i++) {
//			
//			kindCount[cArr[i].kind - 1]++;
//			numberCount[cArr[i].number - 1]++;
//			
//		}
//		
//		for (int i = 0; i < cArr.length; i++) {
//			System.out.println(cArr[i]);
//		}
//		
//		boolean isFlush = false;
//		boolean isStraight = false;
//		
//		//flush 체크 kind의 카운트가 5이면 flush true해주고 바로 break
//		for (int i = 0; i < kindCount.length; i++) {
//			if ( kindCount[i] == 5) {
//				isFlush = true;
//				break;
//			}
//		}
//		
//		
//		// straight 체크 numberCount의 값이 1인 지점에서부터 반복하며 1인지 확인하고,
//		// 1이 아닐 경우 스트레이트 false하고, 반복문 break
//		
//		for (int i = 0; i < numberCount.length; i++)
//			System.out.print(numberCount[i]);
//		
//		if ( numberCount[0] == 1 && numberCount[12] == 1) {
//			
//			for (int i = 9; i < numberCount.length - 1; i++) {
//				if ( numberCount[i] == numberCount[i + 1])
//					isStraight = true;
//				else {
//					isStraight = false;
//					break;
//				}
//			
//			}
//			
//		} else {
//			
//			outer:
//			for (int i = 0; i < numberCount.length - 4; i++) {
//				if ( numberCount[i] == 1 ) {
//					for (int j = i; j < i + 4; j++) {
//						if ( numberCount[j] == numberCount[j+1]) {				// 이 조건이 실행되지 않았다 (break outer가 실행되지 않았다)는 것은
//							isStraight = true;
//						} else {
//							isStraight = false;
//							break outer;						// 처음 1을 만난 지점부터 5개가 연속 1이라는 의미
//						}
//					}
//					
//					break;										// 즉, Straight라는 것이기 때문에 반복문을 빠져 나옴
//				}
//			}
//		
//		}
//		int fourCount = 0;
//		int threeCount = 0;
//		int twoCount = 0;
//		for (int i = 0; i < numberCount.length; i++) {
//			if ( numberCount[i] == 4)
//				fourCount++;
//			else if (numberCount[i] == 3)
//				threeCount++;
//			else if (numberCount[i] == 2)
//				twoCount++;
//		}
//		
//		System.out.println(isFlush);
//		System.out.println(isStraight);
//		System.out.println(fourCount);
//		System.out.println(threeCount);
//		System.out.println(twoCount);
//		
//		String result = "no";
//		if (isFlush && isStraight) {
//			
//			if (cArr[4].number == 13 )
//				result = "royal straight flush";
//			else if (cArr[0].number == 1 )
//				result = "back straight flush";
//			else
//				result = "straight flush";
//		
//		} else if (isStraight) {
//			
//			if (cArr[4].number == 13 )
//				result = "mountain";
//			else if (cArr[0].number == 1 )
//				result = "back straight";
//			else
//				result = "straight";
//		
//		} else if (isFlush) {
//			
//			result = "flush";
//		
//		} else {									// flush도 straight도 아닌 경우에
//			
//			if ( fourCount == 1) {
//				
//				result = "four card";
//				
//			} else if ( threeCount == 1) {
//				
//				if (twoCount == 1)
//					result = "full house";
//				else
//					result = "triple";
//				
//			} else if ( twoCount == 2) {
//				
//				result = "two pair";
//			
//			} else if ( twoCount == 1) {
//			
//				result = "one pair";
//			
//			} else {
//				
//				result = "no rank";
//			}
//		}
		
		
		
		
		
		
//		outer2:
//		for (int i = 0; i < numberCount.length; i++) {
//			
//			if ( numberCount[i] == 4) {
//			
//				result = "four card";
//				break outer2;
//			
//			} else if ( numberCount[i] == 3) {
//				
//				for ( int j = i+1; j < numberCount.length; j++) {
//				
//					if ( numberCount[j] == 2) {
//						
//						result = "full house";
//						break outer2;
//						
//					} else {
//						
//						result = "triple";
//						break outer2;
//						
//					}
//				}
//				
//			} else if ( numberCount[i] == 2) {
//				
//				for ( int j = i+1; j < numberCount.length; j++) {
//					
//					if ( numberCount[j] == 3) {
//					
//						result = "full house";
//						break outer2;
//						
//					} else if ( numberCount[j] == 2) {
//						
//						result = "two pair";
//						break outer2;
//						
//					} else {
//						result = "one pair";
//						break outer2;
//					}
//				}
//			}
//		}
		
		System.out.println(result);

	}
	
	static String rankCheck(Card[] cards) {
		
		String result = "None";
		
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
					boolean isStraight = true;
					
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
						
						for (int i = 9; i < numberCount.length; i++) {
							if ( numberCount[i] != 1)
								isStraight = false;
						}
						
					} else {
						
						outer:
						for (int i = 0; i < numberCount.length; i++) {
							if ( numberCount[i] == 1 ) {
								for (int j = i; j < i + 5; j++) {
									if ( numberCount[j] != 1) {
										isStraight = false;
										break outer;
									}
								}
							}
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
					
					// numberCount로 one, two pair, full house, triple, four card알아보기
					for (int i = 0; i < numberCount.length; i++) {
						
						if ( numberCount[i] == 4) {
						
							result = "four card";
							break;
						
						} else if ( numberCount[i] == 3) {
							
							for ( int j = i+1; j < numberCount.length; j++) {
							
								if ( numberCount[j] == 2) {
									
									result = "full house";
									break;
									
								} else
									
									result = "triple";
								
							}
							
						} else if ( numberCount[i] == 2) {
							
							for ( int j = i+1; j < numberCount.length; j++) {
								
								if ( numberCount[j] == 3) {
								
									result = "full house";
									break;
									
								} else if ( numberCount[j] == 2) {
									
									result = "two pair";
									break;
									
								} else
									result = "one pair";
							}
						}
					}
		
		return result;
	}
	
}
