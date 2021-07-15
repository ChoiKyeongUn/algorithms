package JUNGOL;

import java.util.Scanner;

public class JUNGOL_1707_달팽이사각형 {
	static int n;
	
	public static void main(String[] args) {
		input();
		solve();
	}

	private static void solve() {
		int nums[][] = new int[n][n];
		int iter = n / 2 + 1, num = 1;
		for (int i = 0; i < iter; i++) {
			for (int j = i; j < n - i; j++) nums[i][j] = num++;
			for (int j = i + 1; j < n - i; j++) nums[j][n - i - 1] = num++;
			for (int j = n - 2 - i; j >= i; j--) nums[n - 1 - i][j] = num++;
			for (int j = n - 2 - i; j >= i + 1; j--) nums[j][i] = num++;
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
