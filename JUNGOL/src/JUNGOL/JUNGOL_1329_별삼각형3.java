package JUNGOL;

import java.util.Scanner;

public class JUNGOL_1329_별삼각형3 {
	static int N;
	
	public static void main(String[] args) {
		input();
		print();
	}
	
	private static void print() {
		if(N < 1 || N > 100 || N % 2 == 0) {
			System.out.println("INPUT ERROR!");
			return;
		}
		
		int k = N / 2;
		
		for (int i = -k; i <= k; i++) {
			for (int j = 0, p = k - Math.abs(i); j < p; j++) {
				System.out.print(" ");
			}
			for (int j = 0, p = (k - Math.abs(i)) * 2 + 1; j < p; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private static void input() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
	}
}
