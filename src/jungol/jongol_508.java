/**
 * 508 : 출력 - 자가진단8
 * **/

package jungol;

public class jongol_508 {

	public static void main(String[] args) {
		String item = "item";
		String count = "count";
		String price = "price";
		String pen = "pen";
		int penCnt = 20;
		int penPrice = 100;
		String note = "note";
		int noteCnt = 5;
		int notePrice = 95;
		String eraser = "eraser";
		int eraserCnt = 110;
		int eraserPrice = 97;
		
		System.out.printf("%10s%10s%10s\n", item, count, price);
		System.out.printf("%10s%10d%10d\n", pen, penCnt, penPrice);
		System.out.printf("%10s%10d%10d\n", note, noteCnt, notePrice);
		System.out.printf("%10s%10d%10d\n", eraser, eraserCnt, eraserPrice);
	}

}
