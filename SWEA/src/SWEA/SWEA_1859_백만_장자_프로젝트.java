package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1859_백만_장자_프로젝트 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] price = new int[N];
			for (int i = 0; i < N; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			int start = 0;
			long total = 0;
			while(price[N-1] != 0 && start < N) {
				int max = Integer.MIN_VALUE;
				int max_idx = -1;
				for (int i = start; i < N; i++) {
					if (price[i] > max) {
						max = price[i];
						max_idx = i;
					}
				}
				for (int i = start; i < max_idx; i++) {
					total += (max - price[i]);
					price[i] = 0;
				}
				price[max_idx] = 0;
				start = max_idx + 1;
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ").append(total);
			System.out.println(sb);
		}
	}
}
