package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JUNGOL_2000_동전교환 {
	
	static int n, w, coins[], dp[][];
	static final int INF = 64001;
	
	public static void main(String[] args) throws Exception {
		input();
		solve();
	}

	private static void solve() {
		for (int i = 1; i <= w; i++) {
			if(i % coins[1] == 0) {
				dp[1][i] = i / coins[1];
			}
		}
		
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= w; j++) {
				if(coins[i] > j) {
					dp[i][j] = dp[i-1][j];
				} else {
					if(j % coins[i] == 0) {
						dp[i][j] = j / coins[i];
					}
					dp[i][j] = Math.min(dp[i][j], dp[i-1][j]);
					dp[i][j] = Math.min(dp[i][j], dp[i][j-coins[i]]+1);
				}
			}
		}
		System.out.println(dp[n][w] == INF ? "impossible" : dp[n][w]);
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = stoi(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		coins = new int[n+1];
		for (int i = 1; i <= n; i++) {
			coins[i] = stoi(st.nextToken());
		}
		w = stoi(br.readLine());
		dp = new int[n+1][w+1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= w; j++) {
				dp[i][j] = INF;
			}
		}
	}
	
	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
