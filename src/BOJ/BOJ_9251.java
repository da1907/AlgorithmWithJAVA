package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// LCS
// 116ms
public class BOJ_9251 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		String str2 = br.readLine();
		
		int len1 = str1.length();
		int len2 = str2.length();
		int[][] LCS = new int[len1+1][len2+1];
		for (int i = 1; i <= len1; i++) {
			for (int j = 1; j <= len2; j++) {
				if (str1.charAt(i-1) == str2.charAt(j-1)) {		// 같으면 대각선 +1
					LCS[i][j] = LCS[i-1][j-1] + 1;
				} else {		// 다르면 왼쪽, 위 중 큰 값 가져오기
					LCS[i][j] = Math.max(LCS[i-1][j], LCS[i][j-1]);
				}
			}
		}
		
		System.out.println(LCS[len1][len2]);
	}

}
