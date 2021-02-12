package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class BOJ_1302 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		SortedMap<String, Integer> map = new TreeMap<String, Integer>();
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			
			// putIfAbsent(), computeIfPresent()를 써보았지만 속도가 훨씬 느렸다.
			if (map.containsKey(tmp)) {
				Integer value = map.get(tmp);
				map.put(tmp, ++value);
			} else {
                map.put(tmp, 0);
            }
		}
		
		List<String> keyList = new ArrayList<String>(map.keySet());
		System.out.println(keyList.toString());
		Collections.sort(keyList, new Comparator<String>() {
			public int compare(String s1, String s2) {
				return map.get(s2).compareTo(map.get(s1));
			}
		});
		
		// 이렇게 람다식으로 써주어도 되지만 속도가 훨씬 더 느리다.
		//Collections.sort(keyList, (s1, s2) -> map.get(s2) - map.get(s1));
		
		System.out.println(keyList.get(0));
	}

}
