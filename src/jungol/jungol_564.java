/**
 * 564 : 배열2 - 자가진단1
 * **/

package jungol;

import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class jungol_564 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<Character, Integer> map = new HashMap<>();
		
		while(true) {
			char ch = sc.next().charAt(0);
			
			if (('A' > ch) || ('Z' < ch)) {
				break;
			}
			
			map.computeIfPresent(ch, (k, v) -> ++v);
			map.putIfAbsent(ch, 1);
		}
		
		TreeMap<Character, Integer> tm = new TreeMap<>(map);
		for(Character key : tm.keySet()) {
			System.out.println(key + " : " + map.get(key));
		}
		
	}

}
