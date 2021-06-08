package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2174_로봇시뮬레이션 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());		// 가로
		int B = Integer.parseInt(st.nextToken());		// 세로
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());		// 로봇 수
		int M = Integer.parseInt(st.nextToken());		// 명령 수
		
		int[][] map = new int[B][A];
		int[][] dirMap = new int[B][A];
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		
		int dirNum = 0, x = 0, y = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			y = Integer.parseInt(st.nextToken()) - 1;
			x = B - Integer.parseInt(st.nextToken());
			map[x][y] = i+1;
			
			char dir = st.nextToken().charAt(0);
			if (dir == 'N') dirNum = 0;
			else if (dir == 'E') dirNum = 1;
			else if (dir == 'S') dirNum = 2;
			else if (dir == 'W') dirNum = 3;
			
			dirMap[x][y] = dirNum;
		}
		
		for (int c = 0; c < M; c++) {
			st = new StringTokenizer(br.readLine());
			int robot = Integer.parseInt(st.nextToken());		// 명령 내릴 로봇
			char comm = st.nextToken().charAt(0);			// 명령 종류
			int cnt = Integer.parseInt(st.nextToken());		// 명령 반복 횟수
			
			int curX = 0, curY = 0, curDir = 0;
			for (int i = 0; i < B; i++) {
				for (int j = 0; j < A; j++) {
					if (map[i][j] == robot) {
						curX = i;
						curY = j;
						curDir = dirMap[curX][curY];
					}
				}
			}
			
			if (comm == 'F') {
				for (int j = 0; j < cnt; j++) {
					int nx = curX + dx[curDir];
					int ny = curY + dy[curDir];
					
					if (nx < 0 || nx >= B || ny < 0 || ny >= A) {
						System.out.println("Robot " + robot + " crashes into the wall");
						return;
					}
					if (map[nx][ny] != 0) {
						System.out.println("Robot " + robot + " crashes into robot " + map[nx][ny]);
						return;
					}
					map[nx][ny] = map[curX][curY];
					dirMap[nx][ny] = dirMap[curX][curY];
					map[curX][curY] = 0;
					dirMap[curX][curY] = 0;
					curX = nx; curY = ny;
				}
			} else if (comm == 'R') {
				curDir += 1*cnt;
				curDir %= 4;
				dirMap[curX][curY] = curDir;
			} else if (comm == 'L') {
				curDir += 3*cnt;
				curDir %= 4;
				dirMap[curX][curY] = curDir;
			}
		}
		System.out.println("OK");
	}

}
