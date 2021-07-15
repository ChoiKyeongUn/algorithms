

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1149_RGB거리 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] price = new int[N+1][3];
		int[][] d = new int[N+1][3];
		StringTokenizer st = null;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) price[i][j] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i <= N; i++) {
			d[i][0] = Math.min(d[i-1][1], d[i-1][2]) + price[i][0];
			d[i][1] = Math.min(d[i-1][0], d[i-1][2]) + price[i][1];
			d[i][2] = Math.min(d[i-1][0], d[i-1][1]) + price[i][2];
		}
		System.out.println(Math.min(Math.min(d[N][0], d[N][1]), d[N][2]));
	}
}
