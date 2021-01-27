package jungol;
import java.util.Scanner;

public class jungol_1341 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1;
		int num2;
		
		while (true) {
			num1 = sc.nextInt();
			num2 = sc.nextInt();
			
			// 주어진 범위 벗어남
			if (num1 < 2 || num1 > 9 || num2 < 2 || num2 > 9) {
				System.out.println("INPUT ERROR!");
			} else {
				break;
			}
		}
		
		if (num1 < num2) {
			for(int i = num1; i <= num2; i++) {
				for(int j = 1; j < 10; j++) {
					System.out.printf("%d * %d = %2d   ", i, j, i*j);
					if (j%3 == 0) {
						System.out.println();
					}
				}
				System.out.println();
			}
		} else {
			for(int i = num1; i >= num2; i--) {
				for(int j = 1; j < 10; j++) {
					System.out.printf("%d * %d = %2d   ", i, j, i*j);
					if (j%3 == 0) {
						System.out.println();
					}
				}
				System.out.println();
			}
		}
	}

}
