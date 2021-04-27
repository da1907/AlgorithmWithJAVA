package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1926_그림 {

	static int[][] map;
	private static int N, M, level = 0, count = 0, answerCnt = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					level++;
					count = 0;
					bfs(i, j);
					answerCnt = Math.max(answerCnt, count);
				}
			}
		}
		
		System.out.println(level + "\n" + answerCnt);
	}
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {x, y});
		map[x][y] = 0;
		count++;
		
		while (!queue.isEmpty()) {
			int curX = queue.peek()[0];
			int curY = queue.poll()[1];
			
			for (int i = 0; i < 4; i++) {
				int nx = curX + dx[i];
				int ny = curY + dy[i];
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] == 0) continue;
				
				map[nx][ny] = 0;
				count++;
				queue.add(new int[] {nx, ny});
			}
		}
	}

}
