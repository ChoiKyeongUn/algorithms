package JUNGOL;

import java.util.Scanner;

public class JUNGOL_3427_볼_모으기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int idx = 0;
		int cnt[] = new int[n];
		String in = sc.next();

		char prev = in.charAt(0);
		cnt[0] = 1;
		
		for (int i = 1; i < n; i++) {
			char cur = in.charAt(i);
			if(cur != prev) {
				prev = cur;
				cnt[++idx] = 1;
			} else {
				++cnt[idx];
			}
		}
		int a = 0, b = 0, c = 0;
		for (int i = 0; i < idx; i += 2) {
			a += cnt[i];
		}
		for (int i = 1; i < idx; i += 2) {
			b += cnt[i];
		}
		for (int i = 2; i <= idx; i += 2) {
			c += cnt[i];
		}
		System.out.println(Math.min(Math.min(a, b), c));
	}
}
