/**
 * 516 : 입력 - 자가진단8
 * **/

package jungol;

import java.util.Scanner;

public class jungol_516 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double dnum1 = sc.nextDouble();
		double dnum2 = sc.nextDouble();
		char ch = sc.next().charAt(0);
		
		System.out.printf("%.2f\n%.2f\n%c", dnum1, dnum2, ch);
	}

}
