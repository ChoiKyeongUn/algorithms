package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class JUNGOL_1733_오목 {
	static int[][] omok;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		omok = new int[19+2][19+2];
		String temp;
		int color;
		for (int i = 1; i <= 19; i++) {
			temp = br.readLine();
			for (int j = 1, idx = 0; j <= 19; j++, idx += 2)
				omok[i][j] = temp.charAt(idx) - '0';
		}
		
		for (int i = 1; i <= 19; i++) {
			for (int j = 1; j <= 19; j++) {
				if (omok[i][j] != 0) {
					if (is_omok(i, j)) {
						System.out.println(omok[i][j]);
						System.out.println(i + " " + j);
						return;
					}
				}
			}
		}
		System.out.println(0);
	}
	static int[] dy = {-1, 0, 1, 1};
	static int[] dx = {1, 1, 1, 0};
	private static boolean is_omok(int i, int j) {
		int color = omok[i][j];
		int ny, nx;
dir:	for (int k = 0; k < 4; k++) {
			if (omok[i - dy[k]][j - dx[k]] == color) continue;
			
			for (int k2 = 1; k2 <= 4; k2++) {
				ny = i + dy[k] * k2;
				nx = j + dx[k] * k2;
				if (ny < 1 || ny > 19 || nx < 1 || nx > 19 || omok[ny][nx] != color) continue dir;
			}
			
			if (omok[i + dy[k] * 5][j + dx[k] * 5] == color) continue;
			
			return true;
		}
		
		return false;
	}
}

