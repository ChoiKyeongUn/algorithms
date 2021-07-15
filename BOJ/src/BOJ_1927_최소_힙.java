

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ_1927_최소_힙 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});
		
		for (int i = 0; i < N; i++) {
			int oper = Integer.parseInt(br.readLine());
			if (oper == 0) {
				if(pq.size() == 0) System.out.println(0);
				else System.out.println(pq.poll());
			} else {
				pq.add(oper);
			}
		}
	}
}
