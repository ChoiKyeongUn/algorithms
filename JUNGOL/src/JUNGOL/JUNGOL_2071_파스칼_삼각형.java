package JUNGOL;

import java.util.Scanner;

public class JUNGOL_2071_파스칼_삼각형 {
	static int n, m;
	
	public static void main(String[] args) {
		input();
		solve();
	}
	
	private static void solve() {
		switch(m) {
		case 1:
			print1();
			break;
		case 2:
			print2();
			break;
		default:
			print3();
		}
	}

	private static void print3() {
		int nums[][] = new int[n][n];
		for (int i = n - 1; i >= 0; i--) {
			for (int j = n - 1; j >= i; j--) {
				if(j == n - 1 || j == i) {
					nums[j][i] = 1;
				} else {
					nums[j][i] = nums[j][i+1] + nums[j+1][i+1];
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

	private static void print2() {
		int k = 2 * n - 1;
		int nums[][] = new int[n][k];
		
		for (int i = n - 1; i >= 0; i--) {
			for (int end = k - i - 1, j = i; j <= end; j += 2) {
				if(j == i || j == end) {
					nums[i][j] = 1;
				} else {
					nums[i][j] = nums[i+1][j-1] + nums[i+1][j+1];
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < k; j++) {
				if(nums[i][j] == 0) {
					System.out.print(" ");
				} else {
					System.out.print(nums[i][j]);
				}
			}
			System.out.println();
		}
	}

	private static void print1() {
		int nums[][] = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				if(j == 0 || j == i) {
					nums[i][j] = 1;
				} else {
					nums[i][j] = nums[i-1][j-1] + nums[i-1][j];
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
		m = sc.nextInt();
	}
}
