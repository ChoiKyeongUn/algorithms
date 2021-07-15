

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16959_체스판_여행_1 {
	static int[][] chess;
	static int[] dy_knight = {};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		chess = new int[N][N];
		StringTokenizer st = null;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				chess[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
	}
}
