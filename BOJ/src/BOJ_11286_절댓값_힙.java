

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ_11286_절댓값_힙 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> (Math.abs(o1) == Math.abs(o2) ? o1 - o2 : Math.abs(o1) - Math.abs(o2)));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int oper = Integer.parseInt(br.readLine());
			if(oper == 0) {
				if(pq.isEmpty()) sb.append(0);
				else sb.append(pq.poll());
				sb.append("\n");
			} else {
				pq.add(oper);
			}
		}
		System.out.println(sb);
	}
}
