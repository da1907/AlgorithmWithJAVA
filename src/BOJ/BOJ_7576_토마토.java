package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 608ms
public class BOJ_7576_토마토 {

	static Queue<int[]> queue;
	static int[][] map;
	static int M, N, answer = 0;
	private static int unripeTomato;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		unripeTomato = 0;
		queue = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {			// 토마토이면
					queue.add(new int[] {i, j});		// 토마토 위치 queue에 저장
					map[i][j] = -1;				// 방문 처리
				} else if (map[i][j] == 0) {
					unripeTomato++;				// 안익은 토마토 갯수 저장

				}
			}
		}
		
		if (unripeTomato == 0) {			// 안익은 토마토 없으면 0 출력하고 종료
			System.out.println(0);
			return;
		} 
		
		bfs();
		
		if (unripeTomato != 0) {			// 다 돌았지만 아직 안익은 토마토 남아있다면 토마토 모두 익지 못하는 상황
			System.out.println(-1);
			return;
		}
		System.out.println(answer);
	}

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	private static void bfs() {
		while (!queue.isEmpty()) {
			if (unripeTomato == 0) break;		// 더 이상 안익은 토마토 없으면 종료
			
			for (int i = 0, size=queue.size(); i < size; i++) {
				int curX = queue.peek()[0];
				int curY = queue.poll()[1];
				
				for (int d = 0; d < 4; d++) {
					int nx = curX + dx[d];
					int ny = curY + dy[d];
					
					if (nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] == -1) continue;
					
					queue.add(new int[] {nx, ny});		// 퍼져나갈 토마토 큐에 저장
					map[nx][ny] = -1;			// 방문처리
					--unripeTomato;				// 안익은 토마토 하나 줄이기
				}
			}
			answer++;			// 하루 지남
		}
	}

}
