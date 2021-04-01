package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16439_치킨치킨치킨 {

	private static int N;
	private static int M;
	private static int[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		permu(0, 0);
		System.out.println(answer);
	}

	static int[] nums = new int[3];
	static int answer;
	private static void permu(int start, int idx) {
		if (idx == 3) {
			answer = Math.max(answer, getScore());
			
			return;
		}
		
		for (int i = start; i < M; i++) {
			nums[idx] = i;
			permu(i+1, idx+1);
		}
	}
	
	private static int getScore() {
		int sum = 0;
		int result = 0;
		
		for (int i = 0; i < N; i++) {
			result = 0;
			for (int j = 0; j < 3; j++) {
				result = Math.max(result, arr[i][nums[j]]);
			}
			sum += result;
		}
		
		return sum;
	}

}
