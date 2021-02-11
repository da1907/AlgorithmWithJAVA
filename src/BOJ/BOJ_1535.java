package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1535 {
	static int[] L;
	static int[] J;
	static int N;
	static int answer;
	static boolean[] isSelected;
	static int life, joy;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		L = new int[N];
		J = new int[N];
		isSelected = new boolean[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			L[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			J[i] = Integer.parseInt(st.nextToken());
		}
		
		
		solve(0);
		
		System.out.println(answer);
	}
	
	static void solve(int cnt) {
		if 	(cnt == N) {
			life = 100;
			joy = 0;
			getResult();
			if (life > 0) {
				answer = Math.max(answer, joy);
			}
			return;
		}
		
			
		isSelected[cnt] = false;
		solve(cnt+1);
			
		isSelected[cnt] = true;
		solve(cnt+1);
		
	}
	
	static void getResult() {
		for (int i = 0; i < N; i++) {
			if (isSelected[i]) {
				life -= L[i];
				joy += J[i];
			}
		}
	}

}
