

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2156_포도주_시식 {
	static int n, grape[], dp[], result = 0;
	public static void main(String[] args) throws Exception {
		input();
		solve();
		System.out.println(result);
	}
	
	private static void solve() {
		if(n == 1) result = grape[0];
		else if(n == 2) result = grape[0] + grape[1];
		else if(n == 3) result = Math.max(grape[0] + grape[1], grape[1] + grape[2]);
		else {
			dp = new int[n];
			dp[0] = grape[0];
			dp[1] = grape[0] + grape[1];
			dp[2] = Math.max(grape[0] + grape[1], Math.max(grape[0] + grape[2], grape[1] + grape[2]));
			for (int i = 3; i < n; i++) {
				dp[i] = Math.max(dp[i-3] + grape[i-1] + grape[i], dp[i-2] + grape[i]);
				dp[i] = Math.max(dp[i-1], dp[i]);
			}
			result = dp[n-1];
		}
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = stoi(br.readLine());
		grape = new int[n];
		for (int i = 0; i < n; i++) grape[i] = stoi(br.readLine());
	}

	private static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
