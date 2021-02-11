package jungol;
/**
 * 556 : 배열1 - 자가진단2
 * **/
public class jungol_556 {

	public static void main(String[] args) {
		int[] arr = new int[10];
		
		for(int i = 1; i <= 10; i++) {
			arr[i-1] = i;
		}
		
		for(int i = 0; i < arr.length-1; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println(arr[9]);
	}

}
