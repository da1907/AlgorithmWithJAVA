package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16935 {

	static int[][] arr;
	static int[][] answer;
	static int N;
	static int M;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] oper = new int[R];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; i++) {
			oper[i] = Integer.parseInt(st.nextToken());
		}
		
		
		// =========== 입력 받기 종료 ================
		for (int k = 0; k < R; k++) {
			switch(oper[k]) {
			case 1:
				arr = oper1(arr);
				break;
			case 2:
				arr = oper2(arr);
				break;
			case 3:
				arr = oper3(arr);
				break;
			case 4:
				arr = oper4(arr);
				break;
			case 5:
				arr = oper5(arr);
				break;
			case 6:
				arr = oper6(arr);
				break;
			}
		}
		
		// ================ 출력부 ===================
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	static int[][] oper1(int[][] array) {
		if (array.length == N) {
			answer = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					answer[i][j] = array[N-i-1][j];
				}
			}
		} else {
			answer = new int[M][N];
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					answer[i][j] = array[M-i-1][j];
				}
			}
		}
		
		return answer;
	}
	
	static int[][] oper2(int[][] array) {
		if (array.length == N) {
			answer = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					answer[i][j] = array[i][M-j-1];
				}
			}
		} else {
			answer = new int[M][N];
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					answer[i][j] = array[i][N-j-1];
				}
			}
		}
		
		return answer;
	}

	static int[][] oper3(int[][] array) {
		if (array.length == N) {
			answer = new int[M][N];
			for (int i = 0; i <	M; i++) {
				for (int j = 0; j < N; j++) {
					answer[i][j] = array[N-j-1][i];
					
				}
			}
			return answer;
		} else {
			answer = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					answer[i][j] = array[M-j-1][i];
				}
			}
			return answer;
		}
	}
	
	static int[][] oper4(int[][] array) {
		if(array.length == N) {
			answer = new int[M][N];
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					answer[i][j] = array[j][M-i-1];
				}
			}
		} else {
			
			answer = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					answer[i][j] = array[j][N-i-1];
				}
			}
		}
		return answer;
	}
	
	static int[][] oper5(int[][] array) {
		if (array.length == N) {
			answer = new int[N][M];
			for (int i = 0; i < N/2; i++) {
				for (int j = 0; j < M/2; j++) {
					answer[i][j] = array[i+N/2][j];
				}
			}
			for (int i = 0; i < N/2; i++) {
				for (int j = M/2; j < M; j++) {
					answer[i][j] = array[i][j-M/2];
				}
			}
			for (int i = N/2; i < N; i++) {
				for (int j = 0; j < M/2; j++) {
					answer[i][j] = array[i][j+M/2];
				}
			}
			for (int i = N/2; i < N; i++) {
				for (int j = M/2; j < M; j++) {
					answer[i][j] = array[i-N/2][j];
				}
			}
		} else {
			answer = new int[M][N];
			for (int i = 0; i < M/2; i++) {
				for (int j = 0; j < N/2; j++) {
					answer[i][j] = array[i+M/2][j];
				}
			}
			for (int i = 0; i < M/2; i++) {
				for (int j = N/2; j < N; j++) {
					answer[i][j] = array[i][j-N/2];
				}
			}
			for (int i = M/2; i < M; i++) {
				for (int j = 0; j < N/2; j++) {
					answer[i][j] = array[i][j+N/2];
				}
			}
			for (int i = M/2; i < M; i++) {
				for (int j = N/2; j < N; j++) {
					answer[i][j] = array[i-M/2][j];
				}
			}
		}
		
		return answer;
	}
	
	static int[][] oper6(int[][] array) {
		if (array.length == N) {
			answer = new int[N][M];
			for (int i = 0; i < N/2; i++) {
				for (int j = 0; j < M/2; j++) {
					answer[i][j] = array[i][j+M/2];
				}
			}
			for (int i = 0; i < N/2; i++) {
				for (int j = M/2; j < M; j++) {
					answer[i][j] = array[i+N/2][j];
				}
			}
			for (int i = N/2; i < N; i++) {
				for (int j = 0; j < M/2; j++) {
					answer[i][j] = array[i-N/2][j];
				}
			}
			for (int i = N/2; i < N; i++) {
				for (int j = M/2; j < M; j++) {
					answer[i][j] = array[i][j-M/2];
				}
			}
		} else {
			answer = new int[M][N];
			for (int i = 0; i < M/2; i++) {
				for (int j = 0; j < N/2; j++) {
					answer[i][j] = array[i][j+N/2];
				}
			}
			for (int i = 0; i < M/2; i++) {
				for (int j = N/2; j < N; j++) {
					answer[i][j] = array[i+M/2][j];
				}
			}
			for (int i = M/2; i < M; i++) {
				for (int j = 0; j < N/2; j++) {
					answer[i][j] = array[i-M/2][j];
				}
			}
			for (int i = M/2; i < M; i++) {
				for (int j = N/2; j < N; j++) {
					answer[i][j] = array[i][j-N/2];
				}
			}
		}
		
		return answer;
		
	}
}
