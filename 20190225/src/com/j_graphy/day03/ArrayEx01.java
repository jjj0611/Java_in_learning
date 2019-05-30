package com.j_graphy.day03;

import java.util.Arrays;

public class ArrayEx01 {

	public static void main(String[] args) {
		
		int[] score = new int[5];
		int k = 1;
		
		score[0] = 50;
		score[1] = 60;
		score[k+1] = 70;
		score[3] = 80;
		score[4] = 90;
		
		int tmp = score[k+2] + score[4];
		
		for (int i = 0; i < 5; i ++) {
			System.out.printf("score[%d] : %d%n", i, score[i]);
		}
		
		System.out.printf("tmp : %d%n", tmp);
		
		int[] t = new int[0];
		System.out.println(Arrays.toString(t));
		
		System.out.printf("score[%d] : %d%n", 7, score[7]);
		
	}
	
	
}
