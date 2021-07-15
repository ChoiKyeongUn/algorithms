package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUNGOL_1037_오류교정 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] parity = new int[n+1][n+1];
		StringTokenizer st;
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++)
				parity[i][j] = Integer.parseInt(st.nextToken());
		}
		int sum_width, sum_height;
		int idx1 = -1, idx2 = -1;
		for (int i = 1; i <= n; i++) {
			sum_width = 0; sum_height = 0;
			for (int j = 1; j <= n; j++) {
				if (parity[i][j] == 1) sum_width++;
				if (parity[j][i] == 1) sum_height++;
			}
			if (sum_width % 2 == 1) {
				if (idx1 != -1) {
					System.out.println("Corrupt");
					return;
				}
				idx1 = i;
			}
			
			if (sum_height % 2 == 1) {
				if (idx2 != -1) {
					System.out.println("Corrupt");
					return;
				}
				idx2 = i;
			}
		}
		
		if(idx1 == -1 && idx2 == -1) System.out.println("OK");
		else System.out.println("Change bit (" + idx1 + "," + idx2 + ")");
	}
}
