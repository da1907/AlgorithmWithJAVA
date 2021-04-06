package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//88ms
public class BOJ_1789_수들의합 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long S = Long.valueOf(br.readLine());
		
		if (S == 1) {
			System.out.println(1);
			return;
		}
		
		long sum = 0;
		for (int i = 0; ; i++) {
			sum += i;
			
			if (sum > S) {
				System.out.println(--i);
				break;
			}
		}
	}

}
