package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// 76ms
public class BOJ_11727_2xn타일링2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[N+2];
		dp[1] = 1;
		
		for (int i = 2; i < N+1; i++) {
			dp[i] = (dp[i - 1] + (dp[i-1] + 1)) % 10007;
			i++;
			dp[i] = (dp[i - 1] + (dp[i-1] - 1)) % 10007;
		}
		
		System.out.println(dp[N]);
	}

}
