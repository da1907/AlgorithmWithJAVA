package BOJ;

import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_1747 {
	static boolean isPrime(int num) {
		if (num < 2) {
			return false;
		}
		for (int i = 2; i*i <= num; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	static boolean isPalin(int num) {
		String str = Integer.toString(num);
		for (int i = 0; i < str.length()/2; i++) {
			if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		while(true) {
			if (isPrime(num) && isPalin(num)) {
				System.out.println(num);
				return;
			}
			num++;
		}
	}

}
