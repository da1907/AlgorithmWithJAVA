package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 80ms
public class BOJ_10164_격자상의경로 {

	private static int N;
	private static int M;
	private static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());		// 정수1
		M = Integer.parseInt(st.nextToken());		// 정수2
		int K = Integer.parseInt(st.nextToken());		// 동그라미 친 곳
		
		int answer = 1;
		
		dp = new int[N][M];
		for (int i = 0; i < N; i++) {			// 0열 전부 1로 채우기
			dp[i][0] = 1;
		}
		for (int i = 0; i < M; i++) {			// 0행 전부 1로 채우기
			dp[0][i] = 1;
		}
		
		if (K == 0 || K == N*M || K == 1) {		// 경유해야하는 칸이 없으면(경유칸이 출발 칸이거나 도착칸인 경우도 경유해야하는 곳 없는 것)
			getDistance(1, 1, N-1, M-1);		// 경로 구하기
			answer = dp[N-1][M-1];
		} else {			// 경유해야하는 칸 있으면
			K--;
			int r = K / M;			// 경유해야하는 칸이 몇행 몇열인지 구해주기
			int c = K % M;
			
			if (c == -1) c = M-1;
			
			// 출발~경유칸, 경유칸~도착 두 묶음으로 나누어서 구한 다음 두 값을 곱한다
			getDistance(1, 1, r, c);			// 출발~경유칸까지 경로 찾기
			answer *= dp[r][c];
			for (int i = r; i < N; i++) {		// 0행 모두와 0열 모두를 1로 채웠듯 해당 부분을 1로 채우는 작업
				dp[i][c] = 1;
			}
			for (int i = c; i < M; i++) {
				dp[r][i] = 1;
			}
			getDistance(r+1, c+1, N-1, M-1);	// 경유칸~도착까지 경로 찾기
			answer *= dp[N-1][M-1];				// 두 값 곱하기
		}
		
		System.out.println(answer);
	}

	private static void getDistance(int startX, int startY, int destX, int destY) {
		for (int i = startX; i < destX+1; i++) {
			for (int j = startY; j < destY+1; j++) {
				dp[i][j] = dp[i-1][j] + dp[i][j-1];			// 윗칸 + 왼쪽칸
			}
		}
	}
	
	

}
