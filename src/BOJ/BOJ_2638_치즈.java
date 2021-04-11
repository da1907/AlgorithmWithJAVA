package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2638_치즈 {

	private static int N;
	private static int M;
	private static int[][] map;
	private static LinkedList<int[]> melt;
	private static LinkedList<int[]> air;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0, idx=0; j < M; j++) {
				map[i][j] = input.charAt(idx) - '0';
				idx += 2;
			}
		}
		
		melt = new LinkedList<int[]>();
		air = new LinkedList<int[]>();
		
		map[0][0] = 9;		// 공기
		air.add(new int[] {0, 0});
		airBfs();
		
		int answer = 0;
		while (!melt.isEmpty()) {
			answer++;
			meltBfs();
			airBfs();
		}
		
		System.out.println(answer);
	}
	
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	private static void airBfs() {
		while (!air.isEmpty()) {
			int x = air.peek()[0], y = air.poll()[1];
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				if (map[nx][ny] == 0) {
					map[nx][ny] = 9;			// 치즈 외부는 공기 처리
					air.add(new int[] {nx, ny});
				}
				else if (map[nx][ny] == 1) {
					if (checkSide(nx, ny)) {
						melt.add(new int[] {nx, ny});
						map[nx][ny] = -1;						// 녹을 치즈 (방문 체크 겸)
						
					}
				}
			}
		}
	}
	
	private static void meltBfs() {
		for (int s = 0, size=melt.size(); s < size; s++) {
			int x = melt.peek()[0], y = melt.poll()[1];
			map[x][y] = 9;
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				if (map[nx][ny] == 0) {
					map[nx][ny] = 9;			// 치즈 외부는 공기 처리
					air.add(new int[] {nx, ny});
				}
				else if (map[nx][ny] == 1) {
					if (checkSide(nx, ny)) {
						melt.add(new int[] {nx, ny});
						map[nx][ny] = -1;						// 녹을 치즈 (방문 체크 겸)
						
					}
				}
			}
		}
	}
	
	private static boolean checkSide(int x, int y) {
		int cnt = 0;
		for (int i = 0; i < 4; i++) {
			if (map[x + dx[i]][y + dy[i]] == 9) cnt++;
		}
		
		if (cnt >= 2) return true;
		else return false;
	}

}

