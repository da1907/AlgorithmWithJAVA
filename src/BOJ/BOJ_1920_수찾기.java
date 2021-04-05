package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1920_수찾기 {

	private static int[] A;
	private static int N;
	private static int input;

	public static void main(String[] args) throws Exception {
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);
		
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			input = Integer.parseInt(st.nextToken());
			
			if (binarySearch()) sb.append(1).append("\n");
			else sb.append(0).append("\n");
		}
		
		System.out.println(sb);
	}

	private static boolean binarySearch() {
		int left = 0;
		int right = N-1;
		
		while (left <= right) {
			int mid  = (left+right) / 2;
			
			if (input == A[mid]) return true;
			else if (input < A[mid]) right = mid - 1;
			else left = mid + 1;
		}
		
		return false;
	}
}
