package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2512_예산 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] request = new int[N];
		
		long sum = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			request[i] = Integer.parseInt(st.nextToken());
			sum += request[i];
		}
		Arrays.sort(request);
		
		long M = Integer.parseInt(br.readLine());
		
		if (sum < M) {
			System.out.println(request[N-1]);
			return;
		}
		
		long answer = 0;
		int left = 0;
		int right = request[N-1];
		while (left <= right) {
			int mid = (left + right) / 2;
			
			long total = 0;
			for (int i = 0; i < N; i++) {
				if (mid >= request[i]) total += request[i];
				else total += mid;
			}
			
			if (total > M) {
				right = mid-1;
			} else {
				left = mid+1;
				answer = Math.max(answer, mid);
			}
		}
		
		System.out.println(answer);
	}
}
