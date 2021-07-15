import java.util.Scanner;

public class BOJ_10844_쉬운_계단_수 {
	public static void main(String[] args) {
		int n = new Scanner(System.in).nextInt();
		int cnt[][] = new int[n+1][10];
		final int MOD = 1000000000;
		for (int i = 1; i <= 9; i++) {
			cnt[1][i] = 1;
		}
		for (int i = 2; i <= n; i++) {
			cnt[i][0] = cnt[i-1][1] % MOD;
			cnt[i][1] = (cnt[i-1][0] + cnt[i-1][2]) % MOD;
			cnt[i][2] = (cnt[i-1][1] + cnt[i-1][3]) % MOD;
			cnt[i][3] = (cnt[i-1][2] + cnt[i-1][4]) % MOD;
			cnt[i][4] = (cnt[i-1][3] + cnt[i-1][5]) % MOD;
			cnt[i][5] = (cnt[i-1][4] + cnt[i-1][6]) % MOD;
			cnt[i][6] = (cnt[i-1][5] + cnt[i-1][7]) % MOD;
			cnt[i][7] = (cnt[i-1][6] + cnt[i-1][8]) % MOD;
			cnt[i][8] = (cnt[i-1][7] + cnt[i-1][9]) % MOD;
			cnt[i][9] = cnt[i-1][8] % MOD;
		}
		int result = 0;
		for (int i = 0; i <= 9; i++) {
			result = (result + cnt[n][i]) % MOD;
		}
		System.out.println(result);
	}
}
