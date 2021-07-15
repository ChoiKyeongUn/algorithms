package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5607_조합_D3 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static final int MOD = 1234567891;
	static long fact[] = new long[1000001];
	static int N, R;
	static long result;
	public static void main(String[] args) throws Exception {
		preprocess();
		int T = stoi(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			input();
			System.out.println(N+" "+R);
			solve();
			saveResult(tc);
		}
		System.out.println(sb);
	}

	private static void solve() {
		long top = fact[N] % MOD;
		long bottom = ((fact[R] % MOD) * (fact[N-R]%MOD)) % MOD;
		result = (top*pow(bottom, MOD-2)) % MOD;
	}

	private static void preprocess() {
		fact[0] = 1L;
		for (int i = 1; i < 1000001; i++) {
			fact[i] = fact[i-1] * i % MOD;
		}
	}

	private static long pow(long num, long exp) {
		if(exp == 0) {
			return 1;
		}
		if(exp == 1) {
			return num;
		}
		long temp = pow(num, exp/2);
		if(exp%2 == 0) {
			return ((temp%MOD)*(temp%MOD))%MOD;
		}
		return ((temp*num)%MOD*(temp%MOD))%MOD;
	}

	private static void saveResult(int tc) {
		sb.append("#").append(tc).append(" ").append(result).append("\n");
	}

	private static int stoi(String str) {
		return Integer.parseInt(str);
	}
	
	private static void input() throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		R = stoi(st.nextToken());
	}
}