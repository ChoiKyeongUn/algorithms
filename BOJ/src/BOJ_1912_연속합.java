import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1912_연속합 {
	
	static int n, nums[], dp[];
	
	public static void main(String[] args) throws Exception {
		input();
		solve();
	}

	private static void solve() {
		int max = nums[1];
		dp[1] = nums[1];
		for (int i = 2; i <= n; i++) {
			dp[i] = Math.max(0, dp[i-1]) + nums[i];
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = stoi(br.readLine());
		nums = new int[n+1];
		dp = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			nums[i] = stoi(st.nextToken());
		}
	}
	
	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
