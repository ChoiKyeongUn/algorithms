

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11403_경로_찾기 {
	public static void main(String[] args) throws Exception {
		final int INF = 100000;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] adjMatrix = new int[N][N];
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0, idx = 0; j < N; j++, idx+=2) {
				adjMatrix[i][j] = temp.charAt(idx) - '0';
				if(adjMatrix[i][j] == 0) adjMatrix[i][j] = INF;
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
//				if(i==j) continue;
				for (int j2 = 0; j2 < N; j2++) {
//					if(i==j2||j==j2) continue;
					adjMatrix[j][j2] = Math.min(adjMatrix[j][j2], adjMatrix[j][i] + adjMatrix[i][j2]);
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(adjMatrix[i][j] == INF) adjMatrix[i][j] = 0;
				else adjMatrix[i][j] = 1;
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(adjMatrix[i][j]+" ");
			}
			System.out.println();
		}
	}
}
