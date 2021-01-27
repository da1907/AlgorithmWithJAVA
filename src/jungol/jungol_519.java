package jungol;
import java.util.Scanner;

/**
 * 519 연산자 - 자가진단2
 * **/
public class jungol_519 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		num1 += 100;
		num2 %= 10;
		
		System.out.print(num1 + " " + num2);
	}
}
