package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 80ms
// 로봇 청소기
public class BOJ_14503 {
	static int N, M;
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {-1, 0, 1, 0};
	private static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		map[r][c] = -1;		// 청소 완료하면 -1
		int clean = 1;
		
		while (true) {
			int chance = 4;
			while (chance-- > 0) {			// 네방향에 대해 탐색
				int nr = r + dx[d];
				int nc = c + dy[d];
				
				if (map[nr][nc] == 0) {			// 빈칸이면 2-a번으로 가기
					r = nr; c = nc;
					d = d == 0 ? 3 : d-1;
					map[r][c] = -1;
					++clean;				// 1번으로 돌아가기
					chance = 4;
					continue;
				} else if (map[nr][nc] == 1 || map[nr][nc] == -1) {		// 2-b
					d = d == 0 ? 3 : d-1;
				}
			}
			
			int back = 0;		// 뒷 방향 지정해주기
			if (d == 0) back = 3;
			else if (d == 1) back = 0;
			else if (d == 2) back = 1;
			else if (d == 3) back = 2;
			
			int backX = r + dx[back];		// 뒷칸
			int backY = c + dy[back];
			
			if (map[backX][backY] == 1) {		// 사방 탐색 다했고, 뒤가 벽이면 종료
				System.out.println(clean);		
				return;
			} else {			// 뒤가 벽 아니면 한 칸 후진
				r = backX;
				c = backY;
			}
		}
	}
}
