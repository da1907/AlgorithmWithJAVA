package baekjoon;

import java.util.Scanner;

public class BOJ_4344 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		for (int i = 0; i < num; i++) {
			int students = sc.nextInt();
			int[] scores = new int[students];
			int sum = 0;
			int cnt = 0;
			
			for (int j = 0; j < students; j++) {
				int score = sc.nextInt();
				scores[j] = score;
				sum += score;
			}
			double avg = sum / students;
			
			for (int j = 0; j < students; j++) {
				if (scores[j] > avg) {
					cnt++;
				}
			}
			
			double result = ((double)cnt / (double)students) * 100;
			System.out.printf("%.3f", result);
			System.out.println("%");
		}
		sc.close();
	}

}
