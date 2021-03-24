package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1463 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[N+1];
		Arrays.fill(dp, -1);
		
		for (int i = 1; i <= N; i++) {
			dp[i] = dp[i-1] + 1;
			if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i/2] + 1);
			if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i/3] + 1);
		}
		
		System.out.println(Arrays.toString(dp));
		System.out.println(dp[N]);
	}

}
