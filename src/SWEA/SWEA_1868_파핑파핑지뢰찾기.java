package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SWEA_1868_파핑파핑지뢰찾기 {

	static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
	static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
	static Queue<int[]> queue;
	static int N, numberMap[][], answer = 0;
	static char[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			answer = 0;
			queue = new LinkedList<int[]>();
			
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			numberMap = new int[N][N];
			for (int i = 0; i < N; i++) {
				String input = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = input.charAt(j);
					if (map[i][j] == '*') {
						queue.offer(new int[] {i, j});
					}
				}
			}
			
			getMine();		// 주변 지뢰 개수 구하기
			bfs();			// 0인곳 중심으로 칸 열리기
			click();		// 열리지 않은 칸 마저 클릭하기
			
			sb.append("#").append(tc).append(" ").append(answer).append('\n');
		}
		
		System.out.println(sb);
	}

	private static void click() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (numberMap[i][j] != -1)
					answer++;
			}
		}
	}

	private static void bfs() {
		ArrayList<int[]> list = new ArrayList<int[]>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (numberMap[i][j] == 0) {
					list.add(new int[] {i, j});
				}
			}
		}
		
		for (int i = 0, size=list.size(); i < size; i++) {
			int curX = list.get(i)[0];
			int curY = list.get(i)[1];
			if (numberMap[curX][curY] == -1) continue;
			
			numberMap[curX][curY] = -1;
			queue.add(new int[] {curX, curY});
			
			while (!queue.isEmpty()) {
				int x = queue.peek()[0];
				int y = queue.poll()[1];
				
				for (int d = 0; d < 8; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					
					if (nx < 0 || nx >= N || ny < 0 || ny >= N || numberMap[nx][ny] == -1) continue;
					
					if (numberMap[nx][ny] == 0) {
						queue.offer(new int[] {nx, ny});
					}
					
					numberMap[nx][ny] = -1;
				}
			}
			answer++;
		}
	}

	private static void getMine() {
		while (!queue.isEmpty()) {
			int x = queue.peek()[0];
			int y = queue.poll()[1];
			numberMap[x][y] = -1;		// 지뢰
			
			for (int i = 0; i < 8; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= N || numberMap[nx][ny] == -1) continue;
				numberMap[nx][ny]++;
			}
		}
	}


}
