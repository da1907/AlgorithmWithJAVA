package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_20500 {

	static final int MOD = 1000000007;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[N+1][3];
		
		if (N == 1) {
			System.out.println(0);
			return;
		}
		
		dp[1][1] = 1;
		dp[1][2] = 1;
		
		for (int i = 2; i <= N; i++) {
			dp[i][0] = (dp[i-1][1] + dp[i-1][2]) % MOD;
			dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % MOD;
			dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % MOD;
		}
		
		System.out.println(dp[N-1][1]);
		
	}

}
