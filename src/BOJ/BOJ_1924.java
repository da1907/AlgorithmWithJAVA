package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1924 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int month = Integer.parseInt(st.nextToken());
		int day = Integer.parseInt(st.nextToken());
		int total = 0;
		
		for (int i = 1; i < month; i++) {
			switch (i) {
			case 1: case 3: case 5: case 7: case 8: case 10: case 12:
				total += 31;
				break;
			case 2:
				total += 28;
				break;
			case 4: case 6: case 9: case 11:
				total += 30;
				break;
			}
		}
		
		total += day-1;
		
		switch (total % 7) {
		case 0:
			System.out.println("MON");
			break;
		case 1:
			System.out.println("TUE");
			break;
		case 2:
			System.out.println("WED");
			break;
		case 3:
			System.out.println("THU");
			break;
		case 4:
			System.out.println("FRI");
			break;
		case 5:
			System.out.println("SAT");
			break;
		case 6:
			System.out.println("SUN");
			break;
		}
		
	}

}

