

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1238_파티 {
	static final int INF = 1000 * 100 + 1;
	static int N, M, X, min_distance[][], result = 0;
	static List<int[]>[] adjList;
	static PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o1[1] - o2[1]));
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		input();
		for (int i = 1; i < N+1; i++) {
			if(i == X) {
				dijkstra(i, false);
			} else {
				dijkstra(i, true);
			}
		}
		for (int i = 1; i < N+1; i++) {
			result = Math.max(result, min_distance[i][X] + min_distance[X][i]);
		}
		System.out.println(result);
	}

private static void dijkstra(int i, boolean flag) {
		pq.clear();
		Arrays.fill(visited, false);
		pq.offer(new int[] {i, 0});
		
		while(!pq.isEmpty()) {
			if(flag && visited[X]) break;
			
			int[] cur = pq.poll();
			int cur_node = cur[0];
			if(visited[cur_node]) continue;
			
			visited[cur_node] = true;
			int cur_dist = cur[1];
			
			for (int[] connectedNode : adjList[cur_node]) {
				int nNode = connectedNode[0];
				int nDist = connectedNode[1];
				
				if(!visited[nNode] && min_distance[i][nNode] > cur_dist + nDist) {
					min_distance[i][nNode] = cur_dist + nDist;
					pq.offer(new int[] {nNode, min_distance[i][nNode]});
				}
			}
		}
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		X = stoi(st.nextToken());
		
		adjList = new ArrayList[N+1];
		for (int i = 1; i < N+1; i++) {
			adjList[i] = new ArrayList<int[]>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = stoi(st.nextToken());
			int to = stoi(st.nextToken());
			int cost = stoi(st.nextToken());
			
			adjList[from].add(new int[] {to, cost});
		}
		
		min_distance = new int[N+1][N+1];
		for (int i = 1; i < N+1; i++) {
			Arrays.fill(min_distance[i], INF);
			min_distance[i][i] = 0;
		}
		
		visited = new boolean[N+1];
	}

	private static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
