package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

// 148ms
public class BOJ_1759 {
	static int L;
	static int C;
	static char[] alpha;
	static Stack<Character> result;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		alpha = new char[C];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			alpha[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(alpha);			// 입력받은 알파벳 정렬
		
		result = new Stack<>();		// 알파벳 조합 저장할 스택
		
		solve(0, 0);
	}

	private static void solve(int level, int index) {
		if (level == L) {			// 길이 만족하면
			check(result);			// 암호 조건 만족하는지 검사
		}
		
		for (int i = index; i < C; i++) {		// 재귀로 암호 만들기
			result.add(alpha[i]);
			solve(level+1, i+1);
			result.pop();
		}
	}

	private static void check(Stack<Character> list) {
		int cons = 0;			// 자음 갯수
		int vow =0;				// 모음 갯수
		for(char c : list) {
			String vowel = "aeiou";
			if (vowel.indexOf(c) != -1) vow += 1;		// a,e,i,o,u 중에 있으면 모음갯수 1증가
			else cons += 1;			// 아니면 자음 갯수 1증가
		}
		
		if (cons >= 2 && vow >= 1) {		// 암호 조건 만족하면
			for (int i = 0, size=list.size(); i < size; i++) {		// 출력
				System.out.print(list.get(i));
			}
			System.out.println();
		}
	}
}
