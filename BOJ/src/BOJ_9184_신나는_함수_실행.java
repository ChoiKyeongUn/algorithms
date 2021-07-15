

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9184_신나는_함수_실행 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][][] D = new int[21][21][21];
		for (int i = 0; i < 21; i++)
			for (int j = 0; j < 21; j++) {
				D[0][i][j] = 1;
				D[i][0][j] = 1;
				D[i][j][0] = 1;
			}
		for (int k = 1; k < 21; k++) for (int k2 = 1; k2 < 21; k2++) for (int l = 1; l < 21; l++)
			if(k < k2 && k2 < l) D[k][k2][l] = D[k][k2][l-1] + D[k][k2-1][l-1] - D[k][k2-1][l];
			else D[k][k2][l] = D[k-1][k2][l] +
											D[k-1][k2-1][l] +
											D[k-1][k2][l-1] -
											D[k-1][k2-1][l-1];
				

		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		while(true) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int res = 0;
			if(a == -1 && b == -1 && c == -1) break;
			if(a <= 0 || b <= 0 || c <= 0) res = 1;
			else if(a > 20 || b > 20 || c > 20) res = D[20][20][20];
			else res = D[a][b][c];
			sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ").append(res).append("\n");
		}
		System.out.println(sb);

	}
}
