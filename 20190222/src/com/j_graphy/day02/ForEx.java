package com.j_graphy.day02;

public class ForEx {

	public static void main(String[] args) {

		System.out.println("================1번================");
		// 1
		for (int i = 1; i <= 10; i++) {
			System.out.printf("%2d    %2d\n", i, (11 - i));
		}

		System.out.println();
		System.out.println("================2번================");
		// 2 & 3
		for (int i = 1; i < 10; i++) {
			System.out.printf("%2d    %2d\n", i, i * 2);
		}

		System.out.println();
		System.out.println("================3번================");
		// 2 & 3
		for (int i = 1; i < 10; i++) {
			System.out.printf("%2d    %2d\n", i, i * 2 - 1);
		}

		System.out.println();
		System.out.println("================4번================");
		// 4
		for (int i = 1; i < 10; i++) {
			// System.out.printf("%d %d\n", i, i % 3 == 0 ? 3 : i % 3);
			if (i % 3 == 0)
				System.out.printf("%d  %d\n", i, 3);
			else
				System.out.printf("%d  %d\n", i, i % 3);
		}

		System.out.println();
		System.out.println("================5번================");
		// 5
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j);
			}
			System.out.println();
		}

		System.out.println();
		System.out.println("================6번================");
		// 6
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(i);
			}
			System.out.println();
		}

		System.out.println();
		System.out.println("================7번================");
		// 7
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 5; j++) {
				System.out.printf("%3d", j + 5 * (i - 1));
			}
			System.out.println();
		}

		System.out.println();
		System.out.println("================8번================");
		// 8
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 5; j++) {
				System.out.printf("%3d", i + 5 * (j - 1));
			}
			System.out.println();
		}

		System.out.println();
		System.out.println("================9번================");
		// 9
		for (int i = 0; i < 9; i++) {
			System.out.printf("%d  %d\n", i + 1, i / 3 + 1);
		}

	}

}
