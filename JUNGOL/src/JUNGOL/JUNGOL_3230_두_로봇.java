package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class JUNGOL_3230_두_로봇 {
	
	static int n, s1, s2, prev[][];
	static List<int[]> adjList[];
	static boolean visited[];
	
	public static void main(String[] args) throws Exception {
		input();
		bfs();
	}

	private static void bfs() {
		if(s1 == s2) {
			System.out.println(0);
			return;
		}
		
		Queue<Integer> q = new LinkedList<>();
		int max = 0, total = 0;
		q.offer(s1);
		visited[s1] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			if(cur == s2) {
				break;
			}
			for(int[] next: adjList[cur]) {
				int n = next[0];
				if(!visited[n]) {
					prev[n][0] = cur;
					prev[n][1] = next[1];
					visited[n] = true;
					q.offer(n);
				}
			}
		}
		
		int cursur = s2;
		while(cursur != s1) {
			int n = prev[cursur][1];
			total += n;
			if(max < n) {
				max = n;
			}
			cursur = prev[cursur][0];
		}
		System.out.println(total - max);
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = stoi(st.nextToken());
		s1 = stoi(st.nextToken());
		s2 = stoi(st.nextToken());
		adjList = new ArrayList[n+1];
		visited = new boolean[n+1];
		prev = new int[n+1][2];
		for (int i = 1; i <= n; i++) {
			adjList[i] = new ArrayList<>();
		}
		int n1, n2, d;
		for (int i = 0; i < n-1; i++) {
			st = new StringTokenizer(br.readLine());
			n1 = stoi(st.nextToken());
			n2 = stoi(st.nextToken());
			d = stoi(st.nextToken());

			adjList[n1].add(new int[] {n2, d});
			adjList[n2].add(new int[] {n1, d});
		}
	}
	
	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}