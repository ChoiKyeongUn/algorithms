

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11404_플로이드 {
	static final int INF = 100000 * 100 + 1;
	static int n, m, cost[][];
	public static void main(String[] args) throws Exception {
		input();
		floyd();
		printResult();
	}

	private static void printResult() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print((cost[i][j] == INF ? 0 : cost[i][j]) + " ");
			}
			System.out.println();
		}
	}

	private static void floyd() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(i == j) continue;
				for (int k = 0; k < n; k++) {
					if(i == k || j == k) continue;
					int temp = Math.min(INF, cost[j][i] + cost[i][k]);
					cost[j][k] = Math.min(cost[j][k], temp);
				}
			}
		}
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = stoi(br.readLine());
		m = stoi(br.readLine());
		cost = new int[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(cost[i], INF);
		}
		for (int i = 0; i < n; i++) {
			cost[i][i] = 0;
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = stoi(st.nextToken()) - 1;
			int to = stoi(st.nextToken()) - 1;
			int co = stoi(st.nextToken());
			
			cost[start][to] = Math.min(cost[start][to], co);
		}
	}

	private static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
