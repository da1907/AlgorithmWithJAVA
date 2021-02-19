package SWEA;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 요리사
public class SWEA_4012 {
	static int N;
	static int[][] board;
	static int answer;
	static int[] cookA, cookB;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int testCase = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= testCase; tc++) {
			answer = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			
			board = new int[N][N];
			cookA = new int[N/2];
			cookB = new int[N/2];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			combination(0, 0);
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
			
		}
		System.out.println(sb);
	}

	// N개의 재료 중 N/2개를 고르는 함수
	private static void combination(int cnt, int start) {
		if (cnt == N/2) {
			getMaterial();
			answer = Math.min(answer, Math.abs(compute(cookA)-compute(cookB)));
			return;
		}
		
		for (int i = start; i < N; i++) {
			cookA[cnt] = i;
			combination(cnt+1, i+1);
		}
	}
	
	// 각 요리의 재료로 간을 계산해주는 함수
	private static int compute(int[] arr) {
		int sum = 0;
		for (int i = 0; i < N/2-1; i++) {
			for (int j = i+1; j < N/2; j++) {
				sum += board[arr[i]][arr[j]];
			}
		}
		for (int i = 0; i < N/2-1; i++) {
			for (int j = i+1; j < N/2; j++) {
				sum += board[arr[j]][arr[i]];
			}
		}
		return sum;
	}
	
	// A 요리의 재료가 정해지면 B 요리의 재료를 정해주는 함수
	private static void getMaterial() {
		int index = 0;
		for (int i = 0; i < N; i++) {
			boolean flag = false;
			
			for (int j = 0; j < N/2; j++) {
				if (i == cookA[j]) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				cookB[index] = i;
				index++;
			}
		}
	}

}
