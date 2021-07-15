package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class JUNGOL_1912_미로_탐색 {
	static int n;
	static List<Integer>[] adjList;
	static PriorityQueue<Integer>[] adjList2;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		input();
		dfs();
		System.out.println(sb);
	}

	private static void dfs() {
		Stack<Integer> stack = new Stack<>();
		stack.add(1);
		
		while(!stack.isEmpty()) {
			int cur = stack.pop();
			if(visited[cur]) {
				continue;
			}
			visited[cur] = true;
			
			sb.append(cur).append(" ");
			
			while(!adjList2[cur].isEmpty()) {
				int next = adjList2[cur].poll();
				if(visited[next]) {
					continue;
				}
				stack.push(next);
			}
		}
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = stoi(st.nextToken());
		
		adjList = new ArrayList[n+1];
		adjList2 = new PriorityQueue[n+1];
		for (int i = 1; i <= n; i++) {
//			adjList[i] = new ArrayList<Integer>();
			adjList2[i] = new PriorityQueue<Integer>(new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return o2 - o1;
				}
			});
		}
		visited = new boolean[n+1];
		
		for (int i = 0, m = stoi(st.nextToken()); i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = stoi(st.nextToken());
			int b = stoi(st.nextToken());
			adjList2[a].offer(b);
			adjList2[b].offer(a);
		}
	}
	
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
