package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUNGOL_1719_별삼각형2 {
	static int n, m;
	
	public static void main(String[] args) throws Exception {
		input();
		solve();
	}
	
	private static void solve() {
		if(n < 1 || n > 100 || n % 2 == 0 || m < 1 || m > 4) {
			System.out.println("INPUT ERROR!");
			return;
		}
		switch(m) {
		case 1:
			print1();
			break;
		case 2:
			print2();
			break;
		case 3:
			print3();
			break;
		default:
			print4();
		}
	}

	private static void print4() {
		int k = n / 2;
		for (int i = 0; i < n; i++) {
			if(i <= k) {
				for (int j = 0; j < i; j++) {
					System.out.print(" ");
				}
				for (int j = 0; j < k + 1 - i; j++) {
					System.out.print("*");
				}
			} else {
				for (int j = 0; j < k; j++) {
					System.out.print(" ");
				}
				for (int j = 0; j < i - (k - 1); j++) {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}

	private static void print3() {
		int k = n / 2;
		for (int i = -n / 2; i <= n / 2; i++) {
			int temp = Math.abs(i);
			for (int j = 0, p = k - temp; j < p; j++) {
				System.out.print(" ");
			}
			for (int j = 0, p = temp * 2 + 1; j < p; j++) {
				System.out.print("*");
			}
			for (int j = 0, p = k - temp; j < p; j++) {
				System.out.print(" ");
			}
			System.out.println();
		}
	}

	private static void print2() {
		int k = n / 2 + 1;
		for (int i = -n / 2; i <= n / 2; i++) {
			int temp = Math.abs(i);
			for (int j = 0; j < temp; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < k - temp; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private static void print1() {
		int k = n / 2 + 1;
		for (int i = -n / 2; i <= n / 2; i++) {
			for (int j = 0, temp = Math.abs(i); j < k - temp; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = stoi(st.nextToken());
		m = stoi(st.nextToken());
	}

	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
