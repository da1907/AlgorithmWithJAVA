package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11060_점프점프 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		int[] dp = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			dp[i] = 1001;
		}
		dp[0] = 0;
		
		for (int i = 0; i < N; i++) {
			if (A[i] == 0 && i+1 < N && dp[i+1] == 1001) {
				System.out.println(-1);
				System.exit(0);
			}
			
			for (int j = 0; j < A[i]; j++) {
				if (i+j+1 >= N) break;
				dp[i+j+1] = Math.min(dp[i+j+1], dp[i] +1);
			}
		}
		
		System.out.println(dp[N-1]);
	}

}
