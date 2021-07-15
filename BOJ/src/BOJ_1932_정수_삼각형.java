

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1932_정수_삼각형 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] triangle = new int[N][N];
		StringTokenizer st = null;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < i+1; j++) triangle[i][j] = Integer.parseInt(st.nextToken());
		}
		
		
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < i+1; j++) {
				int max = Integer.MIN_VALUE;
				if(j > 0 && max < triangle[i-1][j-1]) max = triangle[i-1][j-1];
				if(j < i && max < triangle[i-1][j]) max = triangle[i-1][j];
				triangle[i][j] += max;
			}
		}

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) if(triangle[N-1][i] > max) max = triangle[N-1][i];
		System.out.println(max);
	}
}
