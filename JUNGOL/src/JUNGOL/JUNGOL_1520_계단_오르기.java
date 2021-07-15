package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JUNGOL_1520_계단_오르기 {
	
	static int N, steps[], dp[][];
	
	public static void main(String[] args) throws Exception {
		input();
		solve();
	}

	private static void solve() {
		dp[1][1] = steps[1];
		for (int i = 2; i <= N; i++) {
			dp[i][1] = Math.max(dp[i-2][1], dp[i-2][2]) + steps[i];
			dp[i][2] = dp[i-1][1] + steps[i];
		}
		System.out.println(Math.max(dp[N][1], dp[N][2]));
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = stoi(br.readLine());
		steps = new int[N+1];
		for (int i = 1; i <= N; i++) {
			steps[i] = stoi(br.readLine());
		}
		dp = new int[N+1][3];
	}
	
	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
