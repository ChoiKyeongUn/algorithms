package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_5643_키_순서_D4_Live3 {

	static int N, M;
	static int[] gtCnt, ltCnt, adj[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			adj = new int[N + 1][N + 1];
			gtCnt = new int[N+1];
			ltCnt = new int[N+1];
			
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
				dfs(k, k, new boolean[N + 1]);
			}
			for (int k = 1; k <= N; k++) {
				if (gtCnt[k] + ltCnt[k] == N - 1)
					++ans;				
			}
			
			System.out.println("#" + t + " " + ans);
		}
	}

	private static void dfs(int cur, int src, boolean[] visited) {
		visited[cur] = true;

		for (int i = 1; i <= N; i++) {
			if (!visited[i] && adj[cur][i] == 1) {
				dfs(i, src, visited);
				gtCnt[src]++;
				ltCnt[i]++;
			}
		}
	}
}