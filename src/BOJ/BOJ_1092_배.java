package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_1092_배 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		ArrayList<Integer> limit = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			limit.add(Integer.parseInt(st.nextToken()));
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		ArrayList<Integer> box = new ArrayList<Integer>();
		for (int i = 0; i < M; i++) {
			box.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(limit);
		Collections.sort(box);
		
		if (box.get(M-1) > limit.get(N-1)) {
			System.out.println(-1);
			return;
		}
		
		int answer = 0;
		while (!box.isEmpty()) {
			int idx = N-1;
			int val = box.size()-1;
			while (idx >= 0) {
				if (val == -1) break;
				if (box.get(val) <= limit.get(idx)) {
					box.remove(val);
					val--;
					idx--;
				} else if (box.get(val) > limit.get(idx)) {
					val--;
				}
			}
			answer++;
		}
		
		System.out.println(answer);
	}

}
