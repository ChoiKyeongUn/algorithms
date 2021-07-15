package JUNGOL;

import java.util.Scanner;

public class JUNGOL_1495_대각선_지그재그 {
	static int n;

	public static void main(String[] args) {
		input();
		solve();
	}

	private static void solve() {
		int nums[][] = new int[n][n];
		int num = 1;
		for (int i = 0; i < 2 * n - 1; i++) {
			if (i >= n) {
				if (i % 2 == 0) {
					int y = i - n + 1;
					for (int j = n - 1; j >= i - n + 1; j--) {
						nums[y++][j] = num++;
					}
				} else {
					int y = n - 1;
					for (int j = i - n + 1; j < n; j++) {
						nums[y--][j] = num++;
					}
				}
			} else {
				if (i % 2 == 0) {
					int y = 0;
					for (int j = i; j >= 0; j--) {
						nums[y++][j] = num++;
					}
				} else {
					int y = i;
					for (int j = 0; j <= i; j++) {
						nums[y--][j] = num++;
					}
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(nums[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void input() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
	}
}
