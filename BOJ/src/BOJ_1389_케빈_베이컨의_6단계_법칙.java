

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1389_케빈_베이컨의_6단계_법칙 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] friends = new ArrayList[N];
		for (int i = 0; i < N; i++)	friends[i] = new ArrayList<Integer>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			friends[start-1].add(end-1);
			friends[end-1].add(start-1);
		}
		
		int result = -1;
		int min_cavin = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			boolean[] visited = new boolean[N];
			Queue<Integer> queue = new LinkedList<Integer>();
			queue.offer(i);
			visited[i] = true;
			int cavin = 0;
			int depth = 0;
			while(!queue.isEmpty()) {
				int size = queue.size();
				cavin += size*depth;
				for (int j = 0; j < size; j++) {
					int cur = queue.poll();
					ArrayList<Integer> cur_list = friends[cur];
					for (int k = 0, list_size = cur_list.size(); k < list_size; k++) {
						int next = cur_list.get(k);
						if(!visited[next]) {
							visited[next] = true;
							queue.offer(next);
						}
					}
				}
				++depth;
			}
			if(min_cavin > cavin) {
				result = i;
				min_cavin = cavin;
			}
		}
		System.out.println(result+1);
	}
}
