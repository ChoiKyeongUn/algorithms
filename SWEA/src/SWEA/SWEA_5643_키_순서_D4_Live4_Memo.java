package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_5643_키_순서_D4_Live4_Memo {

	static int N, M, adj[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			adj = new int[N+1][N+1];
			
			for (int i = 0; i <= N; i++) adj[i][0] = -1;
			
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
				if(adj[k][0] == -1) dfs(k);
			}
			
			for (int k = 1; k <= N; k++) {
				for (int k2 = 1; k2 <= N; k2++) {
					adj[0][k2] += adj[k][k2];
				}
			}
			
			for (int k = 1; k <= N; k++) {
				if(adj[k][0] + adj[0][k] == N-1) ++ans;
			}
			
			System.out.println("#" + t + " " + ans);
		}
	}

	private static void dfs(int cur) {

		for (int i = 1; i <= N; i++) {
			if(adj[cur][i] == 1) {
				if(adj[i][0] == -1)	dfs(i);
				
				if(adj[i][0] > 0) {
					for (int j = 1; j <= N; j++) {
						if(adj[i][j] == 1) adj[cur][j] = 1;
					}
				}
			}
		}
		
		int cnt = 0;
		for (int i = 1; i <= N; i++) cnt += adj[cur][i];
		
		adj[cur][0] = cnt;
	}
}