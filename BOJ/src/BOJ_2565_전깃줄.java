import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2565_전깃줄 {
	
	static int n, nums[][], dp[];
	
	public static void main(String[] args) throws Exception {
		input();
		solve();
	}

	private static void solve() {
		int max = 0;
		for(int i = 2; i <= n; i++) {
			for (int j = 1; j < i; j++) {
				if(nums[i][1] > nums[j][1]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}

			}
			max = Math.max(max, dp[i]);

		}
		System.out.println(n - max);
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = stoi(br.readLine());
		StringTokenizer st;
		nums = new int[n+1][2];
		dp = new int[n+1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			nums[i][0] = stoi(st.nextToken());
			nums[i][1] = stoi(st.nextToken());
			dp[i] = 1;
		}
		Arrays.sort(nums, (o1, o2) -> (o1[0] - o2[0]));
	}
	
	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
