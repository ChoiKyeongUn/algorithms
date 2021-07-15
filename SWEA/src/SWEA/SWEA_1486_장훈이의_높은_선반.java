package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1486_장훈이의_높은_선반 {
	static int N, B;
	static int[] heights;
	static int subset;
	static int result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			heights = new int[N];
			int sum = 0;
			for (int i = 0; i < N; i++) {
				heights[i] = Integer.parseInt(st.nextToken());
				sum += heights[i]; 
			}
			subset = 0;
			result = sum;
			func();
			sb.append(result - B);
			System.out.println(sb);
		}
	}
	private static void func() {
		for (int i = 0; i < 1<<N; i++) {
			int height = 0;
			for (int j = 0; j < N; j++) {
				if ((subset & 1<<j) != 0) height += heights[j];
			}
			if (height >= B && height < result) result = height;
			subset += 1;
		}
	}
	
	
}
