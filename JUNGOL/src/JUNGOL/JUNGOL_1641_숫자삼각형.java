package JUNGOL;

import java.util.Scanner;

public class JUNGOL_1641_숫자삼각형 {
	static int n, m;
	
	public static void main(String[] args) {
		input();
		solve();
	}
	
	private static void solve() {
		if(n < 1 || n > 100 || n % 2 == 0 || m < 1 || m > 3) {
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
		default:
			print3();
		}
	}

	private static void print3() {
		int k = n / 2;
		for (int i = -k; i <= k; i++) {
			int num = 1;
			int temp = Math.abs(i);
			for (int j = 0, p = n - k - temp; j < p; j++) {
				System.out.print(num++ + " ");
			}
			System.out.println();
		}
	}

	private static void print2() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print("  ");
			}
			
			for (int j = 0, p = n * 2 - 1 - i * 2; j < p; j++) {
				System.out.print(i + " ");
			}
			
			for (int j = 0; j < i; j++) {
				System.out.print("  ");
			}
			System.out.println();
		}
	}

	private static void print1() {
		int[][] nums = new int[n][n];
		int num = 1;
		for (int i = 0; i < n; i++) {
			if(i % 2 == 0) {
				for (int j = 0; j < i + 1; j++) {
					nums[i][j] = num++;
				}
			} else {
				for (int j = i; j >= 0; j--) {
					nums[i][j] = num++;
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(nums[i][j] != 0) {
					System.out.print(nums[i][j] + " ");
				} else {
					break;
				}
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
