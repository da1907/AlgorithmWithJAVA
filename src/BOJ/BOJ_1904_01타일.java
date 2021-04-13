package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 104ms
public class BOJ_1904_01타일 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] sum = new int[N+2];
		
		sum[1] = 1;
		sum[2] = 2;
		for (int i = 3; i < N+1; i++) {
			sum[i] = (sum[i-2] + sum[i-1]) % 15746;
		}
		
		System.out.println(sum[N]);
	}

}
