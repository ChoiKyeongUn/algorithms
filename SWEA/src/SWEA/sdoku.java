package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sdoku {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int[][] sdoku = new int[9][9];
			for (int i = 0; i < sdoku.length; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < sdoku[0].length; j++)
					sdoku[i][j] = Integer.parseInt(st.nextToken());
			}

			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			if (check(sdoku))
				sb.append("1");
			else
				sb.append("0");
			System.out.println(sb);

		}
	}

	static boolean check(int[][] sdoku) {
		boolean check1[];
		boolean check2[];
		for (int i = 0; i < 9; i++) {
			check1 = new boolean[9];
			check2 = new boolean[9];
			for (int j = 0; j < 9; j++) {
				if (check1[sdoku[i][j] - 1])
					return false;
				check1[sdoku[i][j] - 1] = true;
				if (check2[sdoku[j][i] - 1])
					return false;
				check2[sdoku[j][i] - 1] = true;
			}
		}

		for (int i = 0; i < 7; i += 3)
			for (int j = 0; j < 7; j += 3) {
				check1 = new boolean[9];
				for (int k = 0; k < 3; k++)
					for (int k2 = 0; k2 < 3; k2++) {
						if (check1[sdoku[i + k][j + k2] - 1])
							return false;
						check1[sdoku[i + k][j + k2] - 1] = true;
					}
			}
		return true;
	}
}
