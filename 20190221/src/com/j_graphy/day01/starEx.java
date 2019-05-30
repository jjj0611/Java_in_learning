package com.j_graphy.day01;

public class starEx {

	public static void main(String[] args) {
		
		int height = 5;
		
		System.out.println("=============1번=============");

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < height; j++) {
				System.out.print("*");
			}
			System.out.println();
			
		}
		
		System.out.println();
		System.out.println();
		
		System.out.println("=============2번=============");

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < height; j++) {
				if(i == j)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
			
		}
		
		System.out.println();
		System.out.println();
		
		System.out.println("=============3번=============");

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < height; j++) {
				if(i + j == height - 1)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
			
		}
		
		System.out.println();
		System.out.println();
		
		System.out.println("=============4번=============");

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < height; j++) {
				if(i == j || i + j == height - 1)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
			
		}
		
		
		System.out.println();
		System.out.println();
		
		System.out.println("=============5번=============");

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < height; j++) {
				if(i == j || i + j == height - 1)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
			
		}
		
		System.out.println();
		System.out.println();
		
		System.out.println("=============5번=============");

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < height; j++) {
				if(i >= j)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
			
		}
		
		System.out.println();
		System.out.println();
		
		System.out.println("=============6번=============");

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < height; j++) {
				if(i + j <= height - 1)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
			
		}
		
		System.out.println();
		System.out.println();
		
		System.out.println("=============7번=============");

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < i + height; j++) {
				if(true)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
			
		}
		
		System.out.println();
		System.out.println();
		
		System.out.println("=============8번=============");

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < i + height; j++) {
				if(i + j >= height - 1)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
			
		}
		
		System.out.println();
		System.out.println();
		
		System.out.println("=============9번=============");

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < height; j++) {
				if( (i <= j && i + j <= height - 1) || (i >= j && i + j >= height - 1) )
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
			
		}
		
		System.out.println();
		System.out.println();
		
		System.out.println("=============10번=============");

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < height; j++) {
				if( (i >= j && i + j <= height - 1) || (i <= j && i + j >= height - 1) )
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
			
		}
		
		
	}
	
}
