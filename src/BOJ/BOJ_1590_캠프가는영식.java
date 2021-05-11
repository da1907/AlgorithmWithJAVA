package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_1590_캠프가는영식 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> bus = new ArrayList<Integer>();
		int total = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int space = Integer.parseInt(st.nextToken());
			int count = Integer.parseInt(st.nextToken());
			total += count;
			
			for (int j = 0; j < count; j++) {
				bus.add(start + space*j);
			}
		}
		
		Collections.sort(bus);
		
		if (bus.get(total-1) < T) {
			System.out.println(-1);
			return;
		}
		
		int result = 0;
		for (int i = 0, size=bus.size(); i < size; i++) {
			if (bus.get(i) >= T) {
				result = bus.get(i);
				break;
			}
		}
		
		System.out.println(result - T);
	}

}
