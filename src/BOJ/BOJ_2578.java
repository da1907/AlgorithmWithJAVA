package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 빙고
// 84ms
public class BOJ_2578 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[][] board = new int[5][5];
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] row = new int[5];
		int[] col = new int[5];
		int[] down = new int[5];
		int[] up = new int[5];
		
		int bingo = 0;
		int cnt = 0;
		
		//int[][] call = new int[5][5];
		int call;
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				//call[i][j] = Integer.parseInt(st.nextToken());
				call = Integer.parseInt(st.nextToken());
				++cnt;
				
				loop:
				for (int r = 0; r < 5; r++) {
					for (int c = 0; c < 5; c++) {
						if (board[r][c] == call) {
							++row[r];
							++col[c];
							if (r == c) ++down[r];
							if (r+c == 4) ++up[r];
							break loop;
						}
						
					}
				}
				
				if (cnt > 5) {
					boolean flag1 = false;
					boolean flag2 = false;
					for (int k = 0; k < 5; k++) {
						if (row[k] == 5) {
							++bingo;
							row[k] = 0;
						}
						if (col[k] == 5) {
							++bingo;
							col[k] = 0;
						}
						if (up[k] == 0) {
							flag1 = true;
						}
						if (down[k] == 0) {
							flag2 = true;
						}
					}
					
					if (!flag1) {
						++bingo;
						up[0] = 0;
					}
					if (!flag2) {
						++bingo;
						down[0] = 0;
					}
				
					if (bingo >= 3) {
						System.out.println(cnt);
						return;
					}
				}
			}
		}
		
		
		
	}

}
