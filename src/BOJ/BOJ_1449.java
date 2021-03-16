package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 수리공 항승
public class BOJ_1449 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		int answer = 0;
		for (int i = 0; i < N; i++) {
			if (i == N-1) {
				++answer;
				continue;
			}
			
			int num = arr[i++];
			while (N > i) {
				if (L -1 - (arr[i] - num) >= 0) i++;
				else break;
			}
			
			++answer;
			i--;
		}
		System.out.println(answer);
	}

}
