

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2325_개코전쟁 {
	static final int INF = 1000 * 1000 + 1;
	static int N, M, min_distance[], parent[], route[], size;
	static List<int[]>[] adjList;
	public static void main(String[] args) throws Exception {
		input();
		dijkstra();
		pushAndMakeArr();
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < size-1; i++) {
			max = Math.max(max, dijkstra(route[i], route[i+1]));
		}

		System.out.println(max);
	}

	private static int dijkstra(int node1, int node2) {
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((o1, o2) -> (o1[1] - o2[1]));
		pq.offer(new int[] {1, 0});
		boolean[] visited = new boolean[N+1];
		Arrays.fill(min_distance, INF);
		min_distance[1] = 0;
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int cur_node = cur[0];
			if(visited[cur_node]) {
				continue;
			}
			
			visited[cur_node] = true;
			int cur_dist = cur[1];
			
			for(int[] adjNode: adjList[cur_node]) {
				int n_node = adjNode[0];
				if((cur_node == node1 && n_node == node2) ||
				   (cur_node == node2 && n_node == node1)) {
					continue;
				}
				int n_dist = adjNode[1];
				if(!visited[n_node] && min_distance[n_node] > cur_dist + n_dist) {
					parent[n_node] = cur_node;
					min_distance[n_node] = cur_dist + n_dist;
					pq.offer(new int[] {n_node, min_distance[n_node]});
				}
			}
		}
		return min_distance[N];
	}

	private static void pushAndMakeArr() {
		Stack<Integer> stack = new Stack<Integer>();
		int cur = N;
		while(true) {
			stack.add(cur);
			if(cur == 1) break;
			cur = parent[cur];
		}
		size = stack.size();
		route = new int[size];
		for (int i = 0; i < size; i++) {
			route[i] = stack.pop();
		}
	}

	private static void dijkstra() {
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((o1, o2) -> (o1[1] - o2[1]));
		pq.offer(new int[] {1, 0});
		boolean[] visited = new boolean[N+1];
		
		while(!pq.isEmpty()) {
			
			int[] cur = pq.poll();
			int cur_node = cur[0];
			if(visited[cur_node]) {
				continue;
			}
			
			visited[cur_node] = true;
			int cur_dist = cur[1];
			
			for(int[] adjNode: adjList[cur_node]) {
				int n_node = adjNode[0];
				int n_dist = adjNode[1];
				if(!visited[n_node] && min_distance[n_node] > cur_dist + n_dist) {
					parent[n_node] = cur_node;
					min_distance[n_node] = cur_dist + n_dist;
					pq.offer(new int[] {n_node, min_distance[n_node]});
				}
			}
		}
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		adjList = new ArrayList[N+1];
		for (int i = 1; i < N+1; i++) {
			adjList[i] = new ArrayList<int[]>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = stoi(st.nextToken());
			int n2 = stoi(st.nextToken());
			int dist = stoi(st.nextToken());
			adjList[n1].add(new int[] {n2, dist});
			adjList[n2].add(new int[] {n1, dist});
		}
		
		min_distance = new int[N+1];
		Arrays.fill(min_distance, INF);
		min_distance[1] = 0;
		
		parent = new int[N+1];
	}

	private static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
