package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1543 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		char[] search = br.readLine().toCharArray();
		
		int size1 = input.length;
		int size2 = search.length;
		int answer = 0;
		
		for (int i = 0; i < size1 - size2 + 1; i++) {
			boolean flag = true;
			for (int j = 0; j < size2; j++) {
				if (input[i+j] != search[j]) {
					flag = false;
					break;
				}
			}
			if (flag) {
				answer++;
				for (int j = 0; j < size2; j++) {
					input[i+j] = 'X';
				}
			}
		}
		System.out.println(answer);
	}

}
