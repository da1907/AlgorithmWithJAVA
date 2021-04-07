package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BOJ_4485_녹색옷입은애가젤다지 {

	static class Node implements Comparable<Node>{
		int x, y, cost;

		public Node(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc = 1;
		while (true) {
			int N = Integer.parseInt(br.readLine());
			if (N == 0) break;
			
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				String input = br.readLine();
				for (int j = 0, idx=0; j < N; j++) {
					map[i][j] = input.charAt(idx) - '0';
					idx += 2;
				}
			}
			
			boolean[][] visited = new boolean[N][N];
			int[][] dp = new int[N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(dp[i], Integer.MAX_VALUE);
			}
			
			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.add(new Node(0, 0, map[0][0]));
			visited[0][0] = true;
			
			int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
			
			while (!pq.isEmpty()) {
				int curX = pq.peek().x;
				int curY = pq.peek().y;
				int cost = pq.poll().cost;
				visited[curX][curY] = true;
				
				for (int i = 0; i < 4; i++) {
					int nx = curX + dx[i];
					int ny = curY + dy[i];
					
					if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) continue;
					
					if (dp[nx][ny] < map[nx][ny] + cost) continue;
					
					dp[nx][ny] = map[nx][ny] + cost;
					pq.add(new Node(nx, ny, dp[nx][ny]));
				}
			}
			
			sb.append("Problem ").append(tc).append(": ").append(dp[N-1][N-1]).append("\n");
			tc++;
		}
		
		System.out.println(sb);
	}

}
