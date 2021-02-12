package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1969 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		char[] answer = new char[m];
		
		// DNA 입력받기
		String[] dna = new String[n];
		for (int i = 0; i < n; i++) {
			dna[i] = br.readLine();
		}
		
		
		for (int i = 0; i < m; i++) {
			// 뉴클레오티드 빈도수 저장할 배열 (순서대로 A, C, G, T)
			int[] nuc = {0, 0, 0, 0};
			// DNA의 길이만큼 반복문 실행
			for (int j = 0; j < n; j++) {
				char c = dna[j].charAt(i);
				
				switch(c) {
				case 'A':
					nuc[0]++;
					break;
				case 'C':
					nuc[1]++;
					break;
				case 'G':
					nuc[2]++;
					break;
				case 'T':
					nuc[3]++;
					break;
				}
			}
			
			// 가장 많이 등장하는 알파벳 정답 배열에 추가
			int max = nuc[0];
			int result = 0;
			for (int j = 1; j < nuc.length; j++) {
				if (max < nuc[j]) {
					max = nuc[j];
					result = j;
				}
			}
			
			switch(result) {
			case 0:
				answer[i] = 'A';
				break;
			case 1:
				answer[i] = 'C';
				break;
			case 2:
				answer[i] = 'G';
				break;
			case 3:
				answer[i] = 'T';
				break;
			}
		}
		
		int count = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (dna[i].charAt(j) != answer[j]) {
					count++;
				}
			}
		}
		System.out.println(answer);
		System.out.println(count);
	}

}
