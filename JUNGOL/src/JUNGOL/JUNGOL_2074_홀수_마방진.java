package JUNGOL;

import java.util.Scanner;

public class JUNGOL_2074_홀수_마방진 {
	static int n;
	
	public static void main(String[] args) {
		input();
		solve();
	}

	private static void solve() {
		int nums[][] = new int[n][n];
		int y = 0, x = n / 2, num = 1;
		
		for (int i = 0; i < n * n; i++) {
			nums[y][x] = num;
			if(num % n == 0) {
				y++;
			} else {
				y--;
				x--;
			}
			if(y >= n) {
				y = 0;
			}
			if(y < 0) {
				y = n - 1;
			}
			if(x >= n) {
				x = 0;
			}
			if(x < 0) {
				x = n - 1;
			}
			
			++num;
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
