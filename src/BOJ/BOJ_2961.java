package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2961 {

	static int[][] materials;
	static int N;
	static int limit;
	static int answer = 1000000000;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		materials = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			materials[i][0] = Integer.parseInt(st.nextToken());
			materials[i][1] = Integer.parseInt(st.nextToken());
		}
		
		isSelected = new boolean[N];
		for (int i = 1; i <= N; i++) {
			limit = i;
			int sour = 1;
			int bitter = 0;
			permutation(0, 0, sour, bitter);
		}
		System.out.println(answer);
	}
	
	static void permutation(int cnt, int start, int sour, int bitter) {
		if (cnt == limit) {
			int result = Math.abs(sour-bitter);
			answer = Math.min(result, answer);
			return;
		}
		
		for (int i = start; i < N; i++) {
			if (!isSelected[i]) {
				isSelected[i] = true;
				permutation(cnt+1, i+1, sour*materials[i][0], bitter+materials[i][1]);
				isSelected[i] = false;
			}
		}
	}
	
}
