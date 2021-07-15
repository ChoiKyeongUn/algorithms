package JUNGOL;

import java.util.Scanner;

public class JUNGOL_2567_싸이클 {
	
	static int n, p, cur;
	static int cnt[] = new int[1001];
	
	public static void main(String[] args) {
		input();
		solve();
		int result = 0;
		for (int i = 0; i < 1001; i++) {
			if(cnt[i] > 1) ++result;
		}
		System.out.println(result);
	}
	
	private static void solve() {
		cnt[n] = 1;
		cur = n;
		recursion();
	}

	private static void recursion() {
		cur *= n;
		cur %= p;
		++cnt[cur];
		if(cnt[cur] == 3) {
			return;
		}
		recursion();
	}

	private static void input() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		p = sc.nextInt();
	}
}
