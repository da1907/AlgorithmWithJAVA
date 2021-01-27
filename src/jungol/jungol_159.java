package jungol;
/**
 * 159 : 배열1 - 형성평가A
 * **/
import java.util.Arrays;
import java.util.Scanner;

public class jungol_159 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] score = new int[n];
		
		for(int i = 0; i < n; i++) {
			score[i] = sc.nextInt();
		}
		
		Arrays.sort(score);
		
		for(int i = score.length-1; i >= 0; i--) {
			System.out.println(score[i]);
		}
	}
}
