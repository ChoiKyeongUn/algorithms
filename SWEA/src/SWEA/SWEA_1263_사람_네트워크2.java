package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1263_사람_네트워크2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		final int INF = 10000;
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[][] adjMatrix = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					adjMatrix[i][j] = Integer.parseInt(st.nextToken());
					if(adjMatrix[i][j] == 0) adjMatrix[i][j] = INF;
				}
			}
			for (int i = 0; i < N; i++) adjMatrix[i][i] = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(i==j) continue;
					for (int j2 = 0; j2 < N; j2++) {
						if(i==j2 || j==j2) continue;
						adjMatrix[j][j2] = Math.min(adjMatrix[j][j2], adjMatrix[j][i]+adjMatrix[i][j2]);
					}
				}
			}
			
//			for (int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(adjMatrix[i]));
//			}
			
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				int sum = 0;
				for (int j = 0; j < N; j++)	sum += adjMatrix[i][j];
				if(min > sum) min = sum;
			}
			sb.append(min).append("\n");
		}
		System.out.println(sb);
	}
}
