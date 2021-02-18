package BOJ;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1987 {
	static int R, C;
	static char[][] board;
	static int answer;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static boolean[] visited = new boolean[26];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new char[R][C];
		
		for (int i = 0; i < R; i++) {
			board[i] = br.readLine().toCharArray();
		}
		
		visited[board[0][0] - 65] = true;
		dfs(0, 0, 1);
		System.out.println(answer);
	}
	
	private static void dfs(int x, int y, int cnt) {
		for (int i = 0; i < 4; i++) {		// 사방탐색
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			// 범위를 벗어나거나 방문한적 있는 알파벳이면 실행하지 않음
			if (nx < 0 || nx >= R || ny < 0 || ny >= C || visited[board[nx][ny] - 65]) continue;
			
			visited[board[nx][ny] - 65] = true;		// 방문 체크
			dfs(nx, ny, cnt+1);
		}
		visited[board[x][y] - 65] = false;		
		answer = Math.max(cnt, answer);
	}
}
