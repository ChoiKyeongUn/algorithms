package JUNGOL;

import java.util.Scanner;

public class JUNGOL_1331_문자마름모 {
	static int n;
	
	public static void main(String[] args) {
		input();
		solve();
	}

	private static void solve() {
		int l = 2 * n - 1;
		int mid = l / 2;
		char c[][] = new char[l][l];
		char ch = 'A';
		
		for (int i = 0; i < n; i++) {
			int x = mid;
			for (int j = i; j <= mid; j++) {
				c[j][x--] = ch;
				ch += 1;
				if(ch > 'Z') ch = 'A';
			}
			
			x = i + 1;
			for (int j = mid + 1; j < l - i; j++) {
				c[j][x++] = ch;
				ch += 1;
				if(ch > 'Z') ch = 'A';
			}
			
			x = mid + 1;
			for (int j = l - 2 - i; j >= mid; j--) {
				c[j][x++] = ch;
				ch += 1;
				if(ch > 'Z') ch = 'A';
			}
			
			x = l - 2 - i;
			for (int j = mid - 1; j > i; j--) {
				c[j][x--] = ch;
				ch += 1;
				if(ch > 'Z') ch = 'A';
			}
		}
		
		for (int i = 0; i < l; i++) {
			for (int j = 0; j < l; j++) {
				if(c[i][j] == '\0') {
					System.out.print("  ");
				} else {
					System.out.print(c[i][j] + " ");
				}
			}
			System.out.println();
		}
	}

	private static void input() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
	}
}
