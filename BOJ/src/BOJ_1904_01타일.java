

import java.util.Scanner;

public class BOJ_1904_01타일 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		if(N == 1) {
			System.out.println(1);
			return;
		}
		int prev_2 = 1, prev_1 = 1, result = 0;
		for (int i = 2; i <= N; i++) {
			result = (prev_2 + prev_1) % 15746;
			prev_2 = prev_1; prev_1 = result;
		}
		System.out.println(result);
	}
}
