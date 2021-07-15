

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2003_수들의_합2 {
	
	static int N, M, num[], result = 0;
	
	public static void main(String[] args) throws Exception {
		input();
		System.out.println(Arrays.toString(num));
		solve();
		System.out.println(result);
	}

	private static void solve() {
		int start = 0, end = 0, sum = num[0];
		while(end < N) {
			
		}
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		st = new StringTokenizer(br.readLine());
		num = new int[N];
		for (int i = 0; i < N; i++) {
			num[i] = stoi(st.nextToken());
		}
	}

	private static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
