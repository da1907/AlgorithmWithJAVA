package BOJ;

import java.util.Scanner;

public class BOJ_1065 {

	static boolean isHansoo(int num) {
		int firstNum = num / 100;
		int secondNum = num / 10 % 10;
		int thirdNum = num % 10;

		if (firstNum - secondNum == secondNum - thirdNum) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int result = 0;
		
		if (n < 99) {
			System.out.println(n);
		} else if (n >= 99 && n <= 110) {
			System.out.println(99);
		} else {
			result += 99;

			for (int i = 111; i <= n; i++) {
				if (isHansoo(i) == true) {
					result++;
				}
			}
			System.out.print(result);
		}
		sc.close();
	}
}