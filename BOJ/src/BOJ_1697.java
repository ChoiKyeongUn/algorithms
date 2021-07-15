

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1697 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		boolean[] visited = new boolean[100001];
		Queue<Integer> que = new LinkedList<>();
		que.add(N);
		visited[N] = true;
		int cnt = 0;
		while(!que.isEmpty()) {
			int size = que.size();
			for (int i = 0; i < size; i++) {
				int cur = que.poll();
				if (cur == K) {
					System.out.println(cnt);
					return;
				}
				if (cur - 1 >= 0 && !visited[cur-1]) {
					que.add(cur-1);
					visited[cur-1] = true;
				}
				if (cur + 1 <= 100000 && !visited[cur+1]) {
					que.add(cur+1);
					visited[cur+1] = true;
				}
				if (cur*2 <= 100000 && !visited[cur*2]) {
					que.add(cur*2);
					visited[cur*2] = true;
				}
			}
			cnt++;
		}
	}
}
