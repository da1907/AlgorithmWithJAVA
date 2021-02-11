/**
 * 104 : 출력 - 형성평가4
 * **/

package jungol;

public class jungol_104 {

	public static void main(String[] args) {
		int korScore = 90;
		int matScore = 80;
		int engScore = 100;
		int sum = 0;
		int avg = 0;
		
		sum = korScore + matScore + engScore;
		avg = sum / 3;
		
		System.out.println("kor " + korScore);
		System.out.println("mat " + matScore);
		System.out.println("eng " + engScore);
		System.out.println("sum " + sum);
		System.out.println("avg " + avg);
	}

}
