package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1141_접두사 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] str = new String[N];
		for (int i = 0; i < N; i++) {
			str[i] = br.readLine();
		}
		
		Arrays.sort(str);
		System.out.println(Arrays.toString(str));
		int answer = 0;
		for (int i = 0; i < N; i++) {
			String tmp = str[i];
			boolean flag = false;
			for (int j = i+1; j < N; j++) {
				if (str[j].indexOf(tmp) == 0) {
					flag = true;
					break;
				}
			}
			
			if (!flag) answer++;
		}
		
		System.out.println(answer);
	}

	

}
