package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1913_달팽이 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		
		int x = N / 2, y = N / 2;
		int level = 1;
		int number = 1;
		
		while (true) {
			for (int i = 0; i < level; i++) {
				arr[x][y] = number++;
				x--;
			}
			
			if ((number-1) == N*N) break;
			
			for (int i = 0; i < level; i++) {
				arr[x][y] = number++;
				y++;
			}
			level++;
			for (int i = 0; i < level; i++) {
				arr[x][y] = number++;
				x++;
			}
			for (int i = 0; i < level; i++) {
				arr[x][y] = number++;
				y--;
			}
			level++;
		}
		
		int[] answer = new int[2];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(arr[i][j] + " ");
				if (M == arr[i][j]) {
					answer[0] = i;
					answer[1] = j;
				}
			}
			System.out.println();
		}
		
		System.out.println(answer[0]+1 + " " + (answer[1]+1));
		
	}

}
