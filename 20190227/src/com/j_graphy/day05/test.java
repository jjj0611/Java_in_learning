package com.j_graphy.day05;

public class test {

	public static void main(String[] args) {
		
		Card[] cArr = { new Card(4, 1), new Card(4, 2)
		           ,new Card(3, 3), new Card(2, 4)
		           ,new Card(4, 5)};
		for(int i = 0; i < cArr.length - 1; i++) {
			for (int j = 0; j < cArr.length - 1 - i; j++) {
				if ( cArr[j].number > cArr[j+1].number) {
					Card tmp = cArr[j];
					cArr[j] = cArr[j+1];
					cArr[j+1] = tmp;
				}
			}
		}
		
		for (int i = 0; i < cArr.length; i++) {
			System.out.println(cArr[i]);
		}
		
		boolean isFlush = true;
		boolean isStraight = true;
		int sameNum = 0;
		for (int i = 0; i < cArr.length - 1; i++) {
			
			if ( cArr[i].kind != cArr[i + 1].kind ) {
				isFlush = false;
			}
			
			if ( cArr[i].number + 1 != cArr[i+1].number) {
				isStraight = false;
			}
			
			if ( cArr[i].number == cArr[i+1].number)
				sameNum++;
			
		}
		
		System.out.println(isFlush);
		System.out.println(isStraight);
		System.out.println(sameNum);
		
		String result;
		for (int i = 0; i < cArr.length - 3; i++) {
			if ( cArr[i].number == cArr[i+1].number && cArr[i+1].number == cArr[i+2].number && cArr[i+2].number == cArr[i+3].number )
				result = "four card";
			else
				result = "full house";
		}

	}
	
	static String rankCheck(Card[] cards) {
		
		String result = "None";
		
		// straight을 검사하기 위해 먼저 num을 기준으로 카드 정렬
		for(int i = 0; i < cards.length - 1; i++) {
			for (int j = 0; j < cards.length - 1 - i; j++) {
				if ( cards[i].number > cards[i+1].number) {
					Card tmp = cards[i];
					cards[i] = cards[i+1];
					cards[i+1] = tmp;
				}
			}
		}
		
		// 작은 수 정렬이 되어 있기 때문에 isflush와 isStraight 한번에 체크 가능
		// samenum을 세는 것도 추가
		boolean isFlush = true;
		boolean isStraight = true;
		int sameNum = 0;
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
		
		if (isFlush || isStraight)
			
			if (cards[0].number == 'X')
				result = "royal straight flush";
			else if (cards[0].number == '1')
				result = "back straight flush";
			else
				result = "straight flush";
		
		else if (isStraight)
			
			if (cards[0].number == 'X')
				result = "mountain";
			else if (cards[0].number == '1')
				result = "back straight flush";
			else
				result = "straight";
		
		else if (isFlush)
			
			result = "flush";
		
		return result;
	}
}

