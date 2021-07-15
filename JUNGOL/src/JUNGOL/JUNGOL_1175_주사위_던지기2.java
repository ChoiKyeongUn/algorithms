package JUNGOL;

import java.util.Scanner;

public class JUNGOL_1175_주사위_던지기2 {
	static int N, M;
	static int selected[];
	static boolean checked[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		selected = new int[N];
		
		dice(0);
	}
	
	private static void dice(int idx) {
		if(idx == N) {
			int sum = sumDice();
			if(sum == M) {
				print();
			}
			return;
		}
		
		for (int i = 1; i <= 6; i++) {
			selected[idx] = i;
			dice(idx + 1);
		}
	}

	private static void print() {
		for (int s: selected) {
			System.out.print(s + " ");
		}
		System.out.println();
	}

	private static int sumDice() {
		int result = 0;
		for (int s: selected) {
			result += s;
		}
		return result;
	}
}
