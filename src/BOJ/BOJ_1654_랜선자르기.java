package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 140ms
public class BOJ_1654_랜선자르기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int K  = Integer.parseInt(st.nextToken());
		long N = Integer.parseInt(st.nextToken());
		
		long[] arr = new long[K];
		for (int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		
		long left = 1;
		long right = arr[K-1];
		long mid = 0;
		
		while (left <= right) {
			mid = (left+right) / 2;
			
			long sum = 0;
			for (int i = 0; i < K; i++) {
				sum += arr[i] / mid;
			}
			
			if (sum >= N) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		
		System.out.println(right);
	}

}
