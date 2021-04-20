package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3184_양 {

	static int R, C, oCnt, vCnt, oAnswer = 0, vAnswer = 0;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	private static char[][] map;
	private static Queue<int[]> queue;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		queue = new LinkedList<int[]>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'o' || map[i][j] == 'v') {
					oCnt = 0;
					vCnt = 0;

					if (map[i][j] == 'o') oCnt++;
					else if (map[i][j] == 'v') vCnt++;
					
					map[i][j] = '#';
					queue.add(new int[] {i, j});
					bfs();
					
					if (oCnt > vCnt) {
						oAnswer += oCnt;
					} else {
						vAnswer += vCnt;
					}
					
				}
			}
		}
		
		System.out.println(oAnswer + " " + vAnswer);
	}

	private static void bfs() {
		while (!queue.isEmpty()) {
			int x = queue.peek()[0];
			int y = queue.poll()[1];
			
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if (nx < 0 || nx >= R || ny < 0 || ny >= C || map[nx][ny] == '#') continue;
				
				if (map[nx][ny] == '.') {
					map[nx][ny] = '#';
					queue.add(new int[] {nx, ny});
				} else if (map[nx][ny] == 'o') {
					oCnt++;
					map[nx][ny] = '#';
					queue.add(new int[] {nx, ny});
				} else if (map[nx][ny] == 'v') {
					vCnt++;
					map[nx][ny] = '#';
					queue.add(new int[] {nx, ny});
				}
				
			}
		}
	}

}
