package JUNGOL;

import java.util.Arrays;
import java.util.Scanner;

public class JUNGOL_2813_소수의_개수 {
	static int M, N;
	static boolean checked[];
	public static void main(String[] args) {
		input();
		check();
		System.out.println(result());
	}

	private static int result() {
		int sum = 0;
		for (int i = M; i <= N; i++) {
			if(checked[i]) ++sum;
		}
		return sum;
	}

	private static void check() {
		for (int i = 2; i * i <= N; i++) {
			if(!checked[i]) continue;
			for (int j = 2; i * j <= N; j++) {
				checked[i*j] = false;
			}
		}
	}

	private static void input() {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		checked = new boolean[N+1];
		Arrays.fill(checked, true);
		checked[0] = false;
		checked[1] = false;
	}
}
