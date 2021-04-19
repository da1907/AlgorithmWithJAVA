package AlgoSpot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_picnic {
	private static int N, M;
	private static boolean[][] friend;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < TC; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			friend = new boolean[N][N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				friend[a][b] = true;
				friend[b][a] = true;
			}
			
			boolean[] visited = new boolean[N];
			
			sb.append(solve(visited)).append("\n");
		}
		System.out.println(sb);
	}

	private static int solve(boolean[] visited) {
		int num = -1;
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				num = i;
				break;
			}
		}
		
		if (num == -1) {			// 모두가 친구 정해졌다
			return 1;
		}
		int answer = 0;
		for (int i = num+1; i < N; i++) {
			if (!visited[i] && friend[num][i]) {
				visited[i] = visited[num] = true;
				answer += solve(visited);
				visited[i] = visited[num] = false;
			}
		}
		
		return answer;
	}

}

