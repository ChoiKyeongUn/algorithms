

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_18223_민준이와_마산_그리고_건우 {
	static final int INF = 5000 * 10000 + 1;
	static int V, E, P;
	static List<int[]>[] graph;
	public static void main(String[] args) throws Exception {
		input();
		System.out.println(dijkstra(1, V) == dijkstra(1, P) + dijkstra(P, V) ? "SAVE HIM" : "GOOD BYE");
	}

	private static int dijkstra(int start, int end) {
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((o1, o2) -> (o1[1] - o2[1]));
		int[] min_distance = new int[V+1];
		boolean[] visited = new boolean[V+1];
		Arrays.fill(min_distance, INF);
		min_distance[start] = 0;
		pq.offer(new int[] {start, 0});
		
		while(!pq.isEmpty()) {
			
			int[] cur = pq.poll();
			int cur_node = cur[0];
			if(visited[cur_node]) continue;
			
			visited[cur_node] = true;
			if(visited[end]) break;
			int cur_dist = cur[1];
			
			for (int[] connectedNode : graph[cur_node]) {
				int n_node = connectedNode[0];
				if(visited[n_node]) continue;
				int n_dist = connectedNode[1];
				if(min_distance[n_node] > cur_dist + n_dist) {
					min_distance[n_node] = cur_dist + n_dist;
					pq.offer(new int[] {n_node, min_distance[n_node]});
				}
			}
		}
		
		return min_distance[end];
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = stoi(st.nextToken());
		E = stoi(st.nextToken());
		P = stoi(st.nextToken());
		
		graph = new ArrayList[V+1];
		for (int i = 1; i < V+1; i++) {
			graph[i] = new ArrayList<int[]>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = stoi(st.nextToken());
			int to = stoi(st.nextToken());
			int dist = stoi(st.nextToken());
			
			graph[from].add(new int[] {to, dist});
			graph[to].add(new int[] {from, dist});
		}
	}

	private static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
