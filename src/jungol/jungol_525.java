/**
 * 525 : 연산자 - 자가진단8
 * **/

package jungol;

import java.util.Scanner;

public class jungol_525 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int num3 = sc.nextInt();
		
		if (num1 > num2 && num1 > num3) {
			System.out.print(1 + " ");
		} else {
			System.out.print(0 + " ");
		}
		
		if(num1 == num2 && num2 == num3) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}

}
