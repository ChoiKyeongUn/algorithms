package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JUNGOL_1848_극장_좌석 {
	static int N, M, result = 1;
	static int fibo[] = new int[41], fixed[];
	
	public static void main(String[] args) throws Exception {
		fibo();
		input();
		solve();
	}

	private static void solve() {
		for (int i = 0; i < M+1; i++) {
			result *= fibo[fixed[i+1] - fixed[i] - 1];
		}
		System.out.println(result);
	}

	private static void fibo() {
		fibo[0] = 1;
		fibo[1] = 1;
		for (int i = 2; i < 41; i++) {
			fibo[i] = fibo[i-1] + fibo[i-2];
		}
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = stoi(br.readLine());
		M = stoi(br.readLine());
		int left = 0;
		int right = 0;
		fixed = new int[M+2];
		fixed[0] = 0; fixed[M+1] = N+1;
		for (int i = 1; i <= M; i++) {
			fixed[i] = stoi(br.readLine());
		}
	}
	
	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
