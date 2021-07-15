

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11315 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()), N;
		char[][] omok;
		String temp;
		int cnt;
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			omok = new char[N][N];
			for (int i = 0; i < N; i++) {
				temp = br.readLine();
				for (int j = 0; j < N; j++)
					omok[i][j] = temp.charAt(j);
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					cnt = 1;
					for (int j2 = 0; j2 < omok.length; j2++) {
						
					}
				}
			}
		}
	}

}
