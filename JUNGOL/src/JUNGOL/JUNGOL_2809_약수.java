package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class JUNGOL_2809_약수 {
	static int n, yaks[], cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = stoi(br.readLine());
		yaks = new int[100000];
		cnt = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i * i <= n; i++) {
			if (n % i == 0) {
				yaks[cnt++] = i;
				if (n / i != i) {
					yaks[cnt++] = n / i;
				}
			}
		}
		Arrays.sort(yaks);
		for (int i = 100000 - cnt; i < 100000; i++) {
			sb.append(yaks[i] + " ");
		}
		System.out.println(sb);
	}

	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
