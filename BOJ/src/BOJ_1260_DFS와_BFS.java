

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260_DFS와_BFS {
	static boolean[] visited_dfs;
	static boolean[] visited_bfs;
	static int N, M, V;
	static List<Integer>[] graph;
	static StringBuilder sb_dfs;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		visited_bfs = new boolean[N+1];
		visited_dfs = new boolean[N+1];
		graph = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) graph[i] = new ArrayList<Integer>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			graph[f].add(s); graph[s].add(f);
		}
		for (int i = 1; i <= N; i++) graph[i].sort((o1, o2) -> (o1 - o2));
		
		Queue<Integer> queue = new LinkedList<Integer>();

		sb_dfs = new StringBuilder();
		StringBuilder sb_bfs = new StringBuilder();
		
		queue.add(V);
		visited_bfs[V] = true;
		sb_bfs.append(V).append(" ");
		
		dfs(V);
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			int size = graph[cur].size();
			for (int i = 0; i < size; i++) {
				int next  = graph[cur].get(i);
				if(!visited_bfs[next]) {
					visited_bfs[next] = true;
					sb_bfs.append(next).append(" ");
					queue.add(next);
				}
			}
		}
		
		System.out.println(sb_dfs);
		System.out.println(sb_bfs);
	}
	
	private static void dfs(int V) {
		if(visited_dfs[V]) {
			return;
		}
		
		visited_dfs[V] = true;
		sb_dfs.append(V).append(" ");
		for (int i = 0, size = graph[V].size(); i < size; i++) {
			int next = graph[V].get(i);
			dfs(next);
		}
	}
	
}
