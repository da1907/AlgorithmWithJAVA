package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13116_30번 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			int sizeA = power(A);
			int[] arrA = new int[sizeA];
			int sizeB = power(B);
			int[] arrB = new int[sizeB];
			
			for (int i = 0; i < sizeA; i++) {
				arrA[sizeA - i - 1] = A;
				A /= 2;
			}
			for (int i = 0; i < sizeB; i++) {
				arrB[sizeB - i - 1] = B;
				B /= 2;
			}
			
			int answer = 0;
			for (int i = 0; i < sizeA; i++) {
				for (int j = 0; j < sizeB; j++) {
					if (arrA[i] == arrB[j]) {
						answer = Math.max(answer, arrA[i]);
					}
				}
			}
			
			if (answer == 0) {
				System.out.println(10);
			} else {
				System.out.println(answer*10);
			}
		}
	}

	private static int power(int x) {
		if (x == 1) return 1;
		
		int cnt = 0;
		while (x > 1) {
			x /= 2;
			cnt++;
		}
		
		return cnt;
	}

}
