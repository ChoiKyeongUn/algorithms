

import java.util.Scanner;

public class BOJ_16134_조합 {
	
	static long fact[];
	static int N, R;
	static final int MOD = 1000000007;
	
	public static void main(String[] args) {
		preprocessing();
		input();
		solve();
	}

	private static void solve() {
		long top = fact[N] % MOD;
		long bottom = ((fact[R] % MOD) * (fact[N-R] % MOD)) % MOD;
		long result = (top * pow(bottom, MOD-2)) % MOD;
		System.out.println(result);
	}

	private static long pow(long num, int exp) {
		if(exp == 0) {
			return 1;
		}
		long temp = pow(num, exp/2);
		if(exp % 2 == 0) {
			return ( (temp % MOD) * (temp % MOD) ) % MOD;
		}
		return ( ( (temp * num) % MOD ) * (temp % MOD) ) % MOD;
	}

	private static void input() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
	}

	private static void preprocessing() {
		fact = new long[1000001];
		fact[0] = 1;
		for (int i = 1; i < 1000001; i++) {
			fact[i] = (fact[i-1] * i) % MOD;
		}
	}
}
