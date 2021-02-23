package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 자리 배정
// 96ms
public class BOJ_10157 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		
		boolean[][] visited = new boolean[R][C];
		
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		
		int cnt = 1;
		int x = R-1, y = 0;
		
		if (K > R*C) {
			System.out.println(0);
			return;
		}
		
		int i = 0;
		while(cnt != K) {			// 번호 써주다가 K 되면 종료
			visited[x][y] = true;
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			// 범위 벗어나면
			if (nx < 0 || nx >= R || ny < 0 || ny >= C || visited[nx][ny]) {
				i++; 				// 진행 방향 바꿔주기 위한 인덱스 증가
				if (i == 4) i = 0;
				nx = x + dx[i];		// 다음 칸
				ny = y + dy[i];
			}
			
			x = nx; y = ny;
			cnt++;
		}
		System.out.println((y+1) + " " + (R-x));
	}

}
