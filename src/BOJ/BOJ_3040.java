package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_3040 {

	static int[] man = new int[9];
	static int[] candidate = new int[2];
	static int target;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = 0;
		
		for (int i = 0; i < 9; i++) {
			man[i] = Integer.parseInt(br.readLine());
			sum += man[i];
		}
		
		target = sum - 100;
		combination(0, 0, 0);
	}
	
	static void combination(int cnt, int start, int total) {
		if (cnt == 2) {
			if (total == target) {
				for (int i = 0; i < 9; i++) {
					if (man[i] == candidate[0] || man[i] == candidate[1]) {
						continue;
					}
					System.out.println(man[i]);
				};
			}
			return;
		}
		
		for (int i = start; i < 9; i++) {
			candidate[cnt] = man[i];
			combination(cnt+1, i+1, total+man[i]);
			
		}
	}

}
