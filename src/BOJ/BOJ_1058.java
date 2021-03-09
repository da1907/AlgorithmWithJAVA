package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_1058 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		char[][] arr = new char[N][N];
		
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = input.charAt(j);
			}
		}
		
		HashSet<Integer>[] friends = new HashSet[N];
		for (int i = 0; i < N; i++) {
			friends[i] = new HashSet<Integer>();
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 'Y') {
					friends[i].add(j);
					for (int k = 0; k < N; k++) {
						if (arr[j][k] == 'Y' && k != i) {
							friends[i].add(k);
						}
					}
				}
			}
		}
		
		int answer = 0;
		for (int i = 0; i < N; i++) {
			answer = Math.max(friends[i].size(), answer);
		}
		
		System.out.println(answer);
	}

}
