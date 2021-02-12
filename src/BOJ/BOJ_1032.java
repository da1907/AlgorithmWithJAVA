package BOJ;
import java.util.Scanner;

public class BOJ_1032 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();			// 파일 개수
		String[] arr = new String[num];	// 파일명 담을 배열
				
		// 파일명 입력받기
		for (int i = 0; i < num; i++) {
			arr[i] = sc.next();
		}
		
		
		for (int i = 0; i < arr[0].length(); i++) {
			boolean flag = false;
			for (int j = 0; j < num-1; j++) {
				if (arr[j].charAt(i) != arr[j+1].charAt(i)) {
					flag = true;
					break;
				}
			}
			
			if (flag) {
				System.out.print("?");
			} else {
				System.out.print(arr[0].charAt(i));
			}
		}
	}

}
