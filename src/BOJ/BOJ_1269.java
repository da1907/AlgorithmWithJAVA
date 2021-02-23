package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ_1269 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		TreeSet<Integer> set = new TreeSet<Integer>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if (!set.add(tmp)) {
				set.remove(tmp);
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if (!set.add(tmp)) {
				set.remove(tmp);
			}
		}
		
		System.out.println(set.size());
	}

}
