package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1051_숫자정사각형 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		char[][] tmp = new char[N][M];
		for (int i = 0; i < N; i++) {
			tmp[i] = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = tmp[i][j] - '0';
			}
		}
		
		int answer = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				for (int t = 0; t < ((N < M) ? N : M); t++) {
					if (r + t >= N || c + t >= M) break;
					if (t == 0) continue;
					if (map[r][c] == map[r+t][c] && map[r+t][c] == map[r][c+t] && map[r][c+t] == map[r+t][c+t]) {
						answer = Math.max(answer, t);
					}
				}
			}
		}
		
		System.out.println((int)Math.pow(answer+1, 2));
	}
}
