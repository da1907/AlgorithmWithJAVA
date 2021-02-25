package codingTest_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2470 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int left = 0, right = arr.length-1;
		
		int sum, tmp;
		int result = Integer.MAX_VALUE;
		int answer1 = 0, answer2 = 0;
		
		while(left < right) {
			sum = arr[left] + arr[right];
			tmp = Math.abs(sum);
			
			if (tmp < result) {
				result = tmp;
				answer1 = arr[left];
				answer2 = arr[right];
			}
			if (sum > 0) right--;
			else left++;
		}
		
		System.out.println(answer1 + " " +answer2);
		
	}
	
	

}
