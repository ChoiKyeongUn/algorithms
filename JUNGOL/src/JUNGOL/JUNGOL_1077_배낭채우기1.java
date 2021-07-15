package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JUNGOL_1077_배낭채우기1 {
	
	static int n, w, weights[][], dp[][];
	
	public static void main(String[] args) throws Exception {
		input();
		solve();
	}

	private static void solve() {
		for (int i = 1; i <= w; i++) {
			dp[1][i] = weights[1][1] * (i / weights[1][0]);
		}
		
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= w; j++) {
				dp[i][j] = dp[i-1][j];
				if(j >= weights[i][0]) {
					dp[i][j] = Math.max(Math.max(dp[i][j], dp[i-1][j-weights[i][0]] + weights[i][1]), dp[i][j-weights[i][0]] + weights[i][1]);
				} 				
			}
		}
		
		System.out.println(dp[n][w]);
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = stoi(st.nextToken());
		w = stoi(st.nextToken());
		weights = new int[n+1][2];
		dp = new int[n+1][w+1];
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			weights[i][0] = stoi(st.nextToken());
			weights[i][1] = stoi(st.nextToken());
		}
	}
	
	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
