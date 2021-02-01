package day01;

import java.util.Scanner;

public class BOJ_1212 {
	static int getLeng (char[] chArr) {
		int len = chArr.length * 3;
		if (len == 0) {
			return 0;
		}
		
		int first = chArr[0] - '0';
		if (first / 4 > 0) {
			return len;
		}
		if (first / 2 > 0) {
			return len - 1;
		}
		return len - 2;
	}
	
	static int getBinNum(char ch, int idx, char[] chArr) {
		int num = ch - '0';
		
		for (int i = 0; i < 3; i++) {
			chArr[idx--] = (char) ((num % 2) + '0');
			num /= 2;
			
			if(idx < 0) {
				break;
			}
		}
		return idx;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String eight = sc.next();
		char[] eightCharArr = eight.toCharArray();
		
		int binLen = getLeng(eightCharArr);
		char[] binCharArr = new char[binLen];
		
		int index = binLen - 1;
		
		for (int i = eight.length() - 1; i >= 0; i--) {
			char tmp = eightCharArr[i];
			index = getBinNum(tmp, index, binCharArr);
		}
		
		System.out.println(new String(binCharArr));
		
		sc.close();
	}
}

