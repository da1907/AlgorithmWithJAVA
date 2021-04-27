package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_1205_등수구하기 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int newScore = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		Stack<Integer> scores = new Stack<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			scores.add(Integer.parseInt(st.nextToken()));
		}
		
		if (scores.size() == P && scores.peek() >= newScore) {
			System.out.println(-1);
			return;
		}
		
		while (!scores.isEmpty() && scores.peek() <= newScore) {
			scores.pop();
		}
		scores.add(newScore);
		
		System.out.println(scores.size());
	}
}
