package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JUNGOL_1740_소수 {
	static int M, N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		M = stoi(br.readLine());
		N = stoi(br.readLine());
		int sum = 0;
		int cnt = 0;
		int min = 0;
		
		for (int i = M; i <= N; i++) {
			if(isPrime(i)) {
				++cnt;
				sum += i;
				if(min == 0) {
					min = i;
				}
			}
		}
		
		if(cnt == 0) {
			System.out.println(-1);
		} else {
			System.out.println(sum);
			System.out.println(min);
		}
	}

	private static boolean isPrime(int num) {
		if(num == 1) {
			return false;
		}
		for (int i = 2; i <= num / i; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
