package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class BOJ_5397 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < testCase; tc++) {
			char[] L = br.readLine().toCharArray();
			Stack<Character> stack = new Stack<Character>();
			Stack<Character> temp = new Stack<Character>();
			
			for (int i = 0, size = L.length; i < size; i++) {
				//System.out.println(Arrays.toString(stack.toArray()));
				if (L[i] == '-') {					// 백스페이스
					if (!stack.isEmpty()) {			// 스택 비어있지 않으면
						stack.pop();
					}
				} else if (L[i] == '<') {
					if (!stack.isEmpty()) {
						temp.add(stack.pop());
					}
				} else if (L[i] == '>') {
					if (!temp.isEmpty()) {
						stack.add(temp.pop());
					}
				} else {
					stack.add(L[i]);
				}
			}
			
			while(!temp.isEmpty()) {
				stack.add(temp.pop());
			}
			
			for (int i = 0, size = stack.size(); i < size; i++) {
				sb.append(stack.get(i));
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
