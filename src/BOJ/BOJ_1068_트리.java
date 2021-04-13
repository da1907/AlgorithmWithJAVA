package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


// 80ms
public class BOJ_1068_트리 {

	private static int N, answer = 0;
	private static ArrayList<Integer>[] child;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		int root = 0;
		child = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			child[i] = new ArrayList<Integer>();
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(st.nextToken());
			if (input == -1) {
				root = i;
				continue;
			}
			
			child[input].add(i);
		}
		
		int target = Integer.parseInt(br.readLine());
		
		if (target == root) {
			System.out.println(0);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			int size=child[i].size();
			for (int j = size - 1; j >= 0; j--) {
				if (child[i].get(j) == target) {
					child[i].remove(j);
				}
			}
		}
		
		bfs(root);
		System.out.println(answer);
	}

	private static void bfs(int root) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(root);
		
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			if (cur == root && child[cur].size() == 0) answer++;
			
			for (int i = 0, size=child[cur].size(); i < size; i++) {
				int next = child[cur].get(i);
				if (child[next].size() == 0) answer++;
				else {
					queue.add(next);
				}
			}
		}
	}

}
