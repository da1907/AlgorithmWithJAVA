package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2941 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		int answer = 0;
		
		for (int i = 0, size = input.length(); i < size; i++) {
			if (input.charAt(i) == 'l' && i+1 < size && input.charAt(i+1) == 'j') {
				i++;
				answer++;
			}
			else if (input.charAt(i) == 'n' && i+1 < size && input.charAt(i+1) == 'j') {
				i++;
				answer++;
			}
			else if (input.charAt(i) == 'd' && i+2 < size && input.charAt(i+1) == 'z' && input.charAt(i+2) == '=') {
				i += 2;
				answer++;
			}
			else if (input.charAt(i) == '=' || input.charAt(i) == '-') {
				continue;
			}
			else {
				answer++;
			}
		}
		
		System.out.println(answer);
	}

}
