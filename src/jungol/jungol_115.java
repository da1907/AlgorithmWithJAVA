/**
 * 115 : 연산자 - 형성평가5
 * **/

package jungol;

import java.util.Scanner;

public class jungol_115 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int height1 = sc.nextInt();
		int weight1 = sc.nextInt();
		int height2 = sc.nextInt();
		int weight2 = sc.nextInt();
		
		if(height1 > height2 && weight1 > weight2) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}

}
