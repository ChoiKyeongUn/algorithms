package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_10200_구독자_전쟁_D3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()), N, A, B;
		StringTokenizer st;
		StringBuilder sb;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			sb.append(A > B ? B : A).append(" ");
			sb.append(N > A+B ? 0 : A+B-N);
			System.out.println(sb);
		}
	}
}