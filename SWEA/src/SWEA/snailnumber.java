package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class snailnumber {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append("\n");
			int N = Integer.parseInt(br.readLine());
			int[][] numbers = new int[N][N];
			int cnt = 1;
			for (int i = 0; i < N / 2; i++) {
				for (int j = i; j < numbers.length - i; j++)
					numbers[i][j] = cnt++;
				for (int j = i+1; j < numbers.length - i; j++)
					numbers[j][N - 1 - i] = cnt++;
				for (int j = N - 2 - i; j >= i; j--)
					numbers[N - 1 - i][j] = cnt++;
				for (int j = N - 2 - i; j > i; j--) {
					numbers[j][i] = cnt++;
				}
			}
			if (N % 2 == 1) {
				numbers[N/2][N/2] = cnt;
			}
			for (int i = 0; i < numbers.length; i++) {
				for (int j = 0; j < numbers.length; j++) {
					sb.append(numbers[i][j]).append(" ");
				}
				sb.append("\n");
			}
			System.out.print(sb);
		}
	}
}
