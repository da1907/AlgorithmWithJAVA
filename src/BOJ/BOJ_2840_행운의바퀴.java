package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2840_행운의바퀴 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int index = 0;
		char[] board = new char[N];
		boolean[] visited = new boolean[26];
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int number = Integer.parseInt(st.nextToken());
			char alpha = st.nextToken().charAt(0);
			
			number = number % N;
			index -= number;
			if (index < 0) index += N;
			
			if (board[index] != '\0' && board[index] != alpha) {
				System.out.println('!');
				return;
			}
			
			if (visited[alpha-'A'] && board[index] != alpha) {
				System.out.println('!');
				return;
			}
			
			visited[alpha-'A'] = true;
			board[index] = alpha;
			
		}
		
		for (int i = index; i < N; i++) {
			if (board[i] == '\0') {
				System.out.print('?');
				continue;
			}
			System.out.print(board[i]);
		}
		
		for (int i = 0; i < index; i++) {
			if (board[i] == '\0') {
				System.out.print('?');
				continue;
			}
			System.out.print(board[i]);
		}
	}

}
