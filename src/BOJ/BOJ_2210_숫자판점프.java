package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class BOJ_2210_숫자판점프 {

	private static int map[][], arr[];
	private static HashSet<String> result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new int[5][5];
		arr = new int[6];
		for (int i = 0; i < 5; i++) {
			String input = br.readLine();
			for (int j = 0, idx=0; j < 5; j++, idx+=2) {
				map[i][j] = input.charAt(idx) - '0';
			}
		}
		
		result = new HashSet<String>();
		for (int i = 0; i < 5; i++) {
			for (int k = 0; k < 5; k++) {
				dfs(i, k, 0);
			}
		}
		
		System.out.println(result.size());
	}

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	private static void dfs(int x, int y, int idx) {
		if (idx == 6) {
			String resultStr = "";
			for (int i = 0; i < 6; i++) {
				resultStr += arr[i];
			}
			
			result.add(resultStr);
			return;
		}
		
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
			
			arr[idx] = map[nx][ny];
			dfs(nx, ny, idx+1);
		}
	}

}
