package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1254_팰린드롬만들기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] S = br.readLine().toCharArray();
		int size = S.length;
		
		char[] reverse = new char[size];
		for (int i = size-1; i >= 0; i--) {
			reverse[i] = S[size-i-1];
		}
		
		int answer = Integer.MAX_VALUE;
		for (int i = 0; i < size; i++) {
			int cnt = 0;
			boolean flag = true;
			
			for (int j = 0; j < size-i; j++) {
				if (S[i + j] == reverse[j]) cnt++;
				else {
					flag = false;
					break;
				}
			}
			
			if (flag) {
				cnt = size - cnt;
				answer = Math.min(answer, cnt);
			}
		}
		
		System.out.println(size + answer);
	}

}
