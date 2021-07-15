package JUNGOL;

import java.util.Scanner;

public class JUNGOL_1337_달팽이삼각형 {
	static int n;
	
	public static void main(String[] args) {
		input();
		solve();
	}
	
	private static void solve() {
		int iter = (n - 1) / 3 + 1, num = 0;
		int nums[][] = new int[n][n];
		
		for (int i = 0; i < iter; i++) {
			int x = i;
			for (int j = 2 * i; j < n - i; j++) {
				nums[j][x++] = num++;
				if(num == 10) {
					num = 0;
				}
			}
			
			for (int j = n - 2 * (i + 1); j >= i; j--) {
				nums[n - 1 - i][j] = num++;
				if(num == 10) {
					num = 0;
				}
			}
			
			for (int j = n - 2 - i; j >= 2 * i + 1; j--) {
				nums[j][i] = num++;
				if(num == 10) {
					num = 0;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
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
