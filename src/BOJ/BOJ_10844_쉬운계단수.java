package BOJ;

// 76ms
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_10844_쉬운계단수 {
	static long mod = 1000000000L;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		long [][] dp = new long[N+1][10];
		Arrays.fill(dp[1], 1);

		for (int i = 2; i <= N; i++) {
			for (int j = 0; j <= 9; j++) {
				if (j == 0) {				// 0이면 뒤에 1만 올 수 있음
					dp[i][j] = dp[i-1][1];
				} else if (j == 9) {		// 9이면 뒤에 8만 올 수 있음
					dp[i][j] = dp[i-1][8];
				} else {					// 나머지는 +1, -1 와야함
					dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % mod;
				}
			}
		}
		
		long answer = 0;
		for (int i = 1; i <= 9; i++) {
			answer += dp[N][i];
		}
		System.out.println(answer%mod);
	}

}
