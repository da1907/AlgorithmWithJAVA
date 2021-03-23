package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 삼각 그래프
// 368ms

public class BOJ_4883 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
	
		int tc = 0;
		while (true) {
			tc++;
			int N = Integer.parseInt(br.readLine());
			if (N == 0) break;
			
			int[][] dp = new int[N][3];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 3; j++) {
					dp[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			dp[1][0] = dp[0][1] + dp[1][0];
			dp[1][1] = Math.min(dp[1][0], Math.min(dp[0][1], dp[0][1] + dp[0][2])) + dp[1][1];
			dp[1][2] = Math.min(dp[1][1], Math.min(dp[0][1], dp[0][1] + dp[0][2])) + dp[1][2];
					
			for (int i = 2; i < N; i++) {
				dp[i][0] = Math.min(dp[i-1][0], dp[i-1][1]) + dp[i][0];
				dp[i][1] = Math.min(Math.min(dp[i][0], dp[i-1][2]), Math.min(dp[i-1][1], dp[i-1][0])) + dp[i][1];
				dp[i][2] = Math.min(dp[i][1], Math.min(dp[i-1][1], dp[i-1][2])) + dp[i][2];
			}
			
			sb.append(tc).append(". ").append(dp[N-1][1]).append("\n");
		}
		System.out.println(sb);
	}

}
