package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 724ms
public class BOJ_2805_나무자르기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] trees = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(trees);
		
		int low = 0;
		int high = trees[N-1];
		int mid = 0;
		long val = Long.MAX_VALUE;
		int answer = 0;
		while (low <= high) {
			mid = (low + high) / 2;
			
			long sum = 0;
			for (int i = 0; i < N; i++) {
				if (trees[i] - mid < 0) continue;
				sum += trees[i] - mid;
			}
			
			if (sum > M && sum < val) {
				val = sum;
				answer = mid;
				
			}
			
			if (sum > M) {
				low = mid + 1;
			} else if (sum < M) {
				high = mid - 1;
			} else {
				System.out.println(mid);
				return;
			}
		}
		System.out.println(answer);
		
	}

}
