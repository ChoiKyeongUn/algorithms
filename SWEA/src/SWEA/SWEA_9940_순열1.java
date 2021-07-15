package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_9940_순열1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()), N, temp;
		StringBuilder sb;
		boolean[] count;
		StringTokenizer st;
		for (int tc = 1; tc <= T; tc++) {
			sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			N = Integer.parseInt(br.readLine());
			count = new boolean[100001];
			boolean flag = true;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				temp = Integer.parseInt(st.nextToken());
				if(count[temp]) {
					flag = false;
					break;
				}
				count[temp] = true;
			}
			if (flag) sb.append("Yes");
			else sb.append("No");
			System.out.println(sb);
		}
	}
}
