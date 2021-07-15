package JUNGOL;

import java.util.Scanner;

public class JUNGOL_1889_NQueen {
	static int n, result = 0;
	static boolean width[], left[], right[];
	
	public static void main(String[] args) {
		input();
		solve(0);
		System.out.println(result);
	}
	
	private static void solve(int i) {
		if(i == n) {
			++result;
			return;
		}
		
		for (int j = 0; j < n; j++) {
			if(!width[j] && !left[i - j + n - 1] && !right[i + j]) {
				width[j] = true;
				left[i - j + n - 1] = true;
				right[i + j] = true;
				solve(i + 1);
				width[j] = false;
				left[i - j + n - 1] = false;
				right[i + j] = false;
			}
		}
	}

	private static void input() {
		n = new Scanner(System.in).nextInt();
		width = new boolean[n];
		left = new boolean[2 * n - 1];
		right = new boolean[2 * n - 1];
	}
}
