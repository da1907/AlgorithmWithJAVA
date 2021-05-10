package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_11650 {
	static class Node implements Comparable<Node>{
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Node o) {
			if (this.x == o.x)
				return this.y - o.y;
			return this.x - o.x;
		}

		@Override
		public String toString() {
			return x + " " + y;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			pq.add(new Node(a, b));
		}
		
		while(!pq.isEmpty()) {
			System.out.println(pq.poll().toString());
		}
	}

}
