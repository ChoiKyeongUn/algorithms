

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_4485_녹색_옷_입은_애가_젤다지2 {
	static int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = 1;
		while(true) {
			int N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			sb.append("Problem ").append(tc).append(": ");
			
			// 
			int[][] rupee = new int[N][N];
			for (int i = 0; i < N; i++) {
				String temp = br.readLine();
				for (int j = 0, idx = 0; j < N; j++, idx+=2) rupee[i][j] = temp.charAt(idx) - '0';
			}
			
			int[] dy = {-1, 0, 1, 0}, dx = {0, 1, 0, -1};
			int[][] distance = new int[N][N];
			boolean[][] visited = new boolean[N][N];
			for (int i = 0; i < N; i++) Arrays.fill(distance[i], INF);
			distance[0][0] = rupee[0][0];
			
			for (int i = 0; i < N*N; i++) {
				int cur_y = N;
				int cur_x = N;
				int min = Integer.MAX_VALUE;
				
				for (int j = 0; j < N; j++) {
					for (int j2 = 0; j2 < N; j2++) {
						if(visited[j][j2]) continue;
						int temp = distance[j][j2];
						if(temp < min) {
							min = temp;
							cur_y = j;
							cur_x = j2;
						}
					}
				}
				visited[cur_y][cur_x] = true;
				
				for (int j = 0; j < 4; j++) {
					int ny = cur_y + dy[j];
					int nx = cur_x + dx[j];
					if(ny >= 0 && ny < N && nx >= 0 && nx < N && !visited[ny][nx]) {
						distance[ny][nx] = Math.min(distance[ny][nx], distance[cur_y][cur_x] + rupee[ny][nx]);
					}
				}
			}
			

			sb.append(distance[N-1][N-1]).append("\n");
			++tc;
		}
		System.out.println(sb);
	}
}
