package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_2239_스도쿠 {
	static int[][] map;
	static ArrayList<int[]> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new int[9][9];
		list = new ArrayList<int[]>();
		for (int i = 0; i < 9; i++) {
			String input = br.readLine();
			for (int j = 0; j < 9; j++) {
				map[i][j] = input.charAt(j) - '0';
				
				if (map[i][j] == 0) list.add(new int[] {i, j});
			}
		}
		
		go(0);
	}

	private static void go(int level) {
		if (list.size() == level) {
			print();
			System.exit(0);
		}
		
		int x =  list.get(level)[0];
		int y =  list.get(level)[1];
		boolean[] check = new boolean[10];
		for (int i = 0; i < 9; i++) {			// 가로
			if (map[x][i] != 0) {
				check[map[x][i]] = true;
			}
		}
		for (int i = 0; i < 9; i++) {			// 세로
			if (map[i][y] != 0) {
				check[map[i][y]] = true;
			}
		}
		int startX = (x/3) * 3;
		int startY = (y/3) * 3;
		for (int i = startX; i < startX + 3; i++) {			// 네모
			for (int j = startY; j < startY + 3; j++) {
				if (map[i][j] != 0) {
					check[map[i][j]] = true;
				}
			}
		}
		
		for (int i = 1; i < 10; i++) {
			if (!check[i]) {
				map[x][y] = i;
				go(level+1);
				map[x][y] = 0;
			}
		}
	}

	private static void print() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

}
