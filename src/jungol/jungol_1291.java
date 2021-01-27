package jungol;
import java.util.Scanner;

public class jungol_1291 {

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
			for (int i = 1; i < 10; i++) {
				for(int j = num1; j <= num2; j++) {
					if(i*j < 10) {
						System.out.print(j + " * " + i + " =  " + j*i + "   ");
					} else {
						System.out.print(j + " * " + i + " = " + j*i + "   ");
					}
				}
				System.out.println();
			}
		} else {
			for (int i = 1; i < 10; i++) {
				for(int j = num1; j >= num2; j--) {
					if(i*j < 10) {
						System.out.print(j + " * " + i + " =  " + j*i + "   ");
					} else {
						System.out.print(j + " * " + i + " = " + j*i + "   ");
					}
				}
				System.out.println();
			}
		}
	}
}
