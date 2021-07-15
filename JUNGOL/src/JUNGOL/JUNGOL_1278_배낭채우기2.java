package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUNGOL_1278_배낭채우기2 {
	
	static int n, w, things[][], dp[][];
	
	public static void main(String[] args) throws Exception {
		input();
		solve();
		System.out.println(dp[n][w]);
	}

	private static void solve() {
		for (int i = 1; i <= w; i++) {
			if(i >= things[1][0]) {
				dp[1][i] = things[1][1];
			}
		}
		
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= w; j++) {
				dp[i][j] = dp[i-1][j];
				if(j - things[i][0] >= 0) {
					dp[i][j] = Math.max(dp[i][j], dp[i-1][j-things[i][0]] + things[i][1]);
				}
			}
		}
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = stoi(st.nextToken());
		w = stoi(st.nextToken());
		things = new int[n+1][2];
		dp = new int[n+1][w+1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			things[i][0] = stoi(st.nextToken());
			things[i][1] = stoi(st.nextToken());
		}
	}
	
	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
