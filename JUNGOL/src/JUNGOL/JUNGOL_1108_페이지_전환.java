package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JUNGOL_1108_페이지_전환 {
	
	static int n, lastPage = 0, adjMatrix[][];
	static final int INF = 500*500+1;
	static double result = 0.0;
	
	public static void main(String[] args) throws Exception {
		input();
		floyd();
		solve();
	}

	private static void solve() {
		for (int i = 1; i <= lastPage; i++) {
			for (int j = 1; j <= lastPage; j++) {
				if(i == j) {
					continue;
				}
				result += adjMatrix[i][j];
			}
		}
//		System.out.println(result / (double)(lastPage * (lastPage - 1)));
		System.out.printf("%.3f", result / (double)(lastPage * (lastPage - 1)));
	}

	private static void floyd() {
		for (int i = 1; i <= lastPage; i++) {
			for (int j = 1; j <= lastPage; j++) {
				if(i == j) {
					continue;
				}
				for (int k = 1; k <= lastPage; k++) {
					if(i == k || j == k) {
						continue;
					}
					adjMatrix[j][k] = Math.min(adjMatrix[j][k], adjMatrix[j][i] + adjMatrix[i][k]);
				}
			}
		}
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = stoi(br.readLine());
		adjMatrix = new int[n+1][n+1];
		
		for (int i = 1; i <= n; i++) {
			Arrays.fill(adjMatrix[i], INF);
			adjMatrix[i][i] = 0;
		}
		
		StringTokenizer st;
		int from, to;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			from = stoi(st.nextToken());
			to = stoi(st.nextToken());
			lastPage = Math.max(lastPage, Math.max(from, to));
			adjMatrix[from][to] = 1;
		}
	}
	
	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
