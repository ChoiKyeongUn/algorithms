import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2579_계단_오르기 {
	
	static int n, steps[], dp[][];
	
	public static void main(String[] args) throws Exception {
		input();
		solve();
	}

	private static void solve() {
		dp[1][1] = steps[1];
		for (int i = 2; i <= n; i++) {
			dp[i][1] = Math.max(dp[i-2][1], dp[i-2][2]) + steps[i];
			dp[i][2] = dp[i-1][1] + steps[i];
		}
		
		System.out.println(Math.max(dp[n][1], dp[n][2]));
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = stoi(br.readLine());
		steps = new int[n+1];
		for (int i = 1; i <= n; i++) {
			steps[i] = stoi(br.readLine());
		}
		dp = new int[n+1][3];
	}
	
	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
