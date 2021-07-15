package JUNGOL;

import java.util.Scanner;

public class JUNGOL_3522_Tutorial_동적계획법 {
	public static void main(String[] args) {
		int N = new Scanner(System.in).nextInt();
		int dp[] = new int[N+1];
		dp[0] = 0; dp[1] = 1;
		for (int i = 2; i <= N; i++) {
			dp[i] = (dp[i-1] + dp[i-2]) % 1000000007;
		}
		System.out.println(dp[N]);
	}
}
