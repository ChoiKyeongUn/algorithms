package JUNGOL;

import java.util.Scanner;

public class JUNGOL_1411_두_줄로_타일_깔기 {
	public static void main(String[] args) {
		int N = new Scanner(System.in).nextInt();
		int dp[] = new int[N+1];
		dp[1] = 1; dp[2] = 3;
		for (int i = 3; i <= N; i++) {
			dp[i] = (dp[i-1] + 2 * dp[i-2]) % 20100529;
		}
		System.out.println(dp[N]);
	}
}
