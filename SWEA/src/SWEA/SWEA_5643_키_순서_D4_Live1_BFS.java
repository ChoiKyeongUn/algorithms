package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_5643_키_순서_D4_Live1_BFS {
	
	static int N, M, adj[][];
	static int gtCnt, ltCnt;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			adj = new int[N+1][N+1];
			
			StringTokenizer st = null;
			int i, j;
			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine());
				i = Integer.parseInt(st.nextToken());
				j = Integer.parseInt(st.nextToken());
				adj[i][j] = 1;
			}
			
			int ans = 0;
			for (int k = 1; k <= N; k++) {
				gtCnt = ltCnt = 0;
				gtBFS(k, new boolean[N+1]);
				ltBFS(k, new boolean[N+1]);
				if(gtCnt + ltCnt == N-1) ++ans;
			}
			System.out.println("#" + t + " " + ans);
		}
	}
	
	private static void gtBFS(int start, boolean[] visited) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int k = queue.poll();
			for (int i = 1; i <= N; i++) {
				if(!visited[i] && adj[k][i] == 1) {
					visited[i] = true;
					queue.offer(i);
					gtCnt++;
				}
			}
		}
	}
	
	private static void ltBFS(int start, boolean[] visited) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int k = queue.poll();
			for (int i = 1; i <= N; i++) {
				if(!visited[i] && adj[i][k] == 1) {
					visited[i] = true;
					queue.offer(i);
					ltCnt++;
				}
			}
		}
	}
}