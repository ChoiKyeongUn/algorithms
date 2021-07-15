

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1915_가장_큰_정사각형 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int max = 0;
		int[][] square = new int[n][m];
		for (int i = 0; i < n; i++) {
			String temp = br.readLine();
			for (int j = 0; j < m; j++) {
				square[i][j] = temp.charAt(j) - '0';
			}
		}
		
		for (int i = 0; i < m; i++) {
			if(square[0][i] == 1) {
				max = 1;
				break;
			}
		}
		for (int i = 0; i < n; i++) {
			if(square[i][0] == 1) {
				max = 1;
				break;
			}
		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				if(square[i][j] == 1) {
					int lu = square[i-1][j-1];
					int u = square[i-1][j];
					int l = square[i][j-1];
					square[i][j] = Math.min(Math.min(lu, u), l)+1;
					if(square[i][j] > max) max = square[i][j];
				}
			}
		}
		System.out.println(max*max);
	}
}
