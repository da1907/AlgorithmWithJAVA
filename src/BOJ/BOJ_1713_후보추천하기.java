package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;


// 104ms
public class BOJ_1713_후보추천하기 {
	static class Candidate {
		int student, count, order;

		public Candidate(int student, int count, int order) {
			this.student = student;
			this.count = count;
			this.order = order;
		}
	}
	
	static class Sort implements Comparator<Candidate> {		// 득표수 기준 정렬
		@Override
		public int compare(Candidate o1, Candidate o2) {
			return o1.count - o2.count;
		}
	}
	
	static class Sort2 implements Comparator<Candidate> {		// 학생 번호 기준 정렬
		@Override
		public int compare(Candidate o1, Candidate o2) {
			return o1.student - o2.student;
		}
	}
	
	static class Sort3 implements Comparator<Candidate> {		// 들어온 순서 기준 정렬
		@Override
		public int compare(Candidate o1, Candidate o2) {
			return o1.order - o2.order;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());			// 사진틀 갯수
		int M = Integer.parseInt(br.readLine());			// 추천 횟수
		
		List<Candidate> list = new ArrayList<Candidate>();		// 사진틀
		boolean[] check = new boolean[101];				// 사진틀에 들어와있는 학생인지 구분하기 위해
		int order = 0;			// 들어온 순서
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int data = Integer.parseInt(st.nextToken());
			
			if (check[data]) {			// 이미 사진틀에 있는 학생이면
				for (int j = 0, size=list.size(); j < size; j++) {
					if (list.get(j).student == data) {			// 학생 찾아서 득표수 1 증가
						list.get(j).count++;
					}
				}
			} else {					// 사진틀에 없는 학생
				check[data] = true;		// 사진틀에 넣었다고 표시해주기
				if (list.size() >= N) {				// 비어있는 사진틀 없으면
					Collections.sort(list, new Sort3());			// 들어온 순서대로 정렬하고
					Collections.sort(list, new Sort());				// 득표수대로 정렬
					
					check[list.get(0).student] = false;				// 제일 앞에 있는 사진 삭제 표시
					list.remove(list.get(0));						// 삭제
				}
				list.add(new Candidate(data, 0, order++));			// 새로운 학생 넣어주기
			}
		}
		
		Collections.sort(list, new Sort2());				// 출력은 학생번호기준 오름차순
		for (Candidate can : list) {
			System.out.print(can.student + " ");
		}
		
	}

}
