package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Jungol_1828 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 입력받기
		int N = Integer.parseInt(br.readLine());
		int[][] materials = new int[N][2]; 
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			materials[i][0] = Integer.parseInt(st.nextToken());
			materials[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// 정렬
		Arrays.sort(materials, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0] == 0? o1[1]-o2[1] : o1[0]-o2[0];
			}
		});
		
		int cnt = 1;	// 냉장고 대수
		int limit = materials[0][1];		// 기준이 될 온도
		for (int i = 1; i < N; i++) {
			if (materials[i][0] <= limit) {		// 기 재료와 최저온도 범위가 겹치고
				if (materials[i][1] < limit) {	// 최고온도가 기준 재료의 최고온도보다 작으면
					limit = materials[i][1];	// 기준 온도 바뀜
				}
			} else {		// 최저온도가 기준 재료의 최고온도를 넘어서면 겹치는 범위가 없는 것
				limit = materials[i][1];	// 기준 바꾸고
				++cnt;		// 냉장고 대수 늘리기
			}
		}
		System.out.println(cnt);

	}
}
