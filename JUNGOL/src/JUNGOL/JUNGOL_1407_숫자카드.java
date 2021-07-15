package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JUNGOL_1407_숫자카드 {
	static String input;
	static int fibo[] = new int[41], result = 1;
	
	public static void main(String[] args) throws Exception {
		input();
		fibo();
		solve();
		System.out.println(result);
	}

	private static void solve() {
		int len = input.length();
		int add = 0;
		for (int i = 0; i < len - 2; i++) {
			char cur = input.charAt(i);
			char next = input.charAt(i+1);
			if(possible(cur, next)) {
				++add;
			} else {
				result *= fibo[add];
				add = 0;
			}
		}
		if(possible(input.charAt(len - 2), input.charAt(len - 1))) {
			++add;
		}
		result *= fibo[add];
	}

	private static void fibo() {
		fibo[0] = 1; fibo[1] = 2;
		for (int i = 2; i <= 40; i++) {
			fibo[i] = fibo[i-1] + fibo[i-2];
		}
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine();
	}

	private static boolean possible(char cur, char next) {
		if(cur > '3' && next == '0') {
			result = 0;
			return false;
		}
		if(cur == '0' || cur > '3' || next == '0' || (cur == '3' && next > '4')) {
			return false;
		}
		return true;
	}
}
