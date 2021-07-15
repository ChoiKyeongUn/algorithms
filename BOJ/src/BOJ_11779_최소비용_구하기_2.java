

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_11779_최소비용_구하기_2 {
	static final int INF = 1000*100000+1;
	static int n, m, min_distance[], parent[], A, B;
	static Stack<Integer> stack = new Stack<Integer>();
	static List<int[]>[] graph;
	public static void main(String[] args) throws Exception {
		input();
		dijkstra();
		push();
		printResult();
	}

	private static void printResult() {
		System.out.println(min_distance[B]);
		System.out.println(stack.size());
		while(!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}

	private static void push() {
		int cur = B;
		while(true) {
			stack.push(cur);
			if(cur == A) break;
			cur = parent[cur];
		}
	}

	private static void dijkstra() {
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o1[1] - o2[1]));
		boolean[] visited = new boolean[n+1];
		pq.offer(new int[] {A, 0});
		
		while(!pq.isEmpty()) {
			if(visited[B]) break;
			
			int[] cur = pq.poll();
			int cur_node = cur[0];
			if(visited[cur_node]) continue;
			
			visited[cur_node] = true;
			int cur_dist = cur[1];
			
			
			for (int[] connectedNode : graph[cur_node]) {
				int n_node = connectedNode[0];
				if(visited[n_node]) continue;
				int n_dist = connectedNode[1];
				
				if(min_distance[n_node] > cur_dist + n_dist) {
					min_distance[n_node] = cur_dist + n_dist;
					pq.offer(new int[] {n_node,  cur_dist + n_dist});
					parent[n_node] = cur_node;
				}
			}
		}
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = stoi(br.readLine());
		m = stoi(br.readLine());
		min_distance = new int[n+1];
		Arrays.fill(min_distance, INF);
		graph = new ArrayList[n+1];
		for (int i = 1; i < n+1; i++) {
			graph[i] = new ArrayList<int[]>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = stoi(st.nextToken());
			int to = stoi(st.nextToken());
			int dist = stoi(st.nextToken());
			
			graph[from].add(new int[] {to, dist});
		}
		
		st = new StringTokenizer(br.readLine());
		A = stoi(st.nextToken());
		B = stoi(st.nextToken());
		
		min_distance[A] = 0;
		
		parent = new int[n+1];
	}
	
	private static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
