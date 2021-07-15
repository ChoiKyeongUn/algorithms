package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2117_홈_방범_서비스 {
	static int T, N, M, cost, cnt_home;
	static int[][] map;
	static String temp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			cnt_home = 0;
			for (int i = 0; i < N; i++) {
				temp = br.readLine();
				for (int j = 0, idx = 0; j < N; j++, idx += 2) {
					map[i][j] = temp.charAt(idx) - '0';
					if (map[i][j] == 1)
						++cnt_home;
				}
			}
			int result_home_cnt = 0;
			int result_size = 0;
			int result_cost = -1;
			outer: 
			for (int current_size = 1; current_size <= N+1; current_size++) {
				cost = -current_size * current_size - (current_size - 1) * (current_size - 1);
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						
						int cnt = 0;
						
						for (int j2 = -(current_size - 1); j2 <= current_size - 1; j2++) {
							for (int k = -(current_size - 1); k <= current_size - 1; k++) {
								int cur_y = i + j2;
								int cur_x = j + k;
								if (cur_y >= 0 && cur_y < N && cur_x >= 0 && cur_x < N
										&& Math.abs(j2) + Math.abs(k) < current_size && map[cur_y][cur_x] == 1) {
									++cnt;
								}
							}
	
						}
						
						int temp = cost + cnt * M;

						if (temp >= 0 && result_home_cnt < cnt)
							result_home_cnt = cnt;

						if (cnt == cnt_home)
							break outer;
					}
				}
			}
			sb.append(result_home_cnt).append("\n");
		}
		System.out.println(sb);
	}
}
