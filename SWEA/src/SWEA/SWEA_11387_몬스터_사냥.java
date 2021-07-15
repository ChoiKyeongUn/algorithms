package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_11387_몬스터_사냥 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int D, L, N;
		StringBuilder sb;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			double result = 0;
			for (int i = 0; i < N; i++)
				result += (double)D*(1.0+(double)(i*L)/100.0);;
			sb = new StringBuilder();
			sb.append("#").append(tc).append(" ").append((int)result);
			System.out.println(sb);
		}
	}
}
