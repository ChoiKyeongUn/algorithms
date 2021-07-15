

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11724_연결_요소의_개수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<Integer>[] graph = new ArrayList[N+1];
		boolean[] checked = new boolean[N+1];
		for (int i = 1; i <= N; i++) graph[i] = new ArrayList<Integer>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			graph[first].add(second);
			graph[second].add(first);
		}
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			if (!checked[i]) {
				cnt++;
				checked[i] = true;
				Queue<Integer> queue = new LinkedList<>();
				queue.add(i);
				while(!queue.isEmpty()) {
					int cur = queue.poll();
					int size = graph[cur].size();
					for (int j = 0; j < size; j++) {
						int next = graph[cur].get(j);
						if (!checked[next]) {
							checked[next] = true;
							queue.add(next);
						}
					}
				}
			}
		}
		System.out.println(cnt);
	}
}
