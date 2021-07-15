package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1249_보급로_D4 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		final int INF = 1000000;
		
		for (int tc = 1; tc <= T; tc++) { // test case 시작
			sb.append("#").append(tc).append(" ");
			
			int N = Integer.parseInt(br.readLine()); // 땅 길이
			int numNode = N*N; 
			int[][] map = new int[N][N];
			int[][] min_distance = new int[N][N]; // 다익스트라에서 사용할 땅 크기와 같은 최단 길이 배열
			boolean[][] visited = new boolean[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					min_distance[i][j] = INF;
				}
			}
			min_distance[0][0] = 0; // 시작점부터 끝점으로의 최단길이를 구헤야 하므로 시작점만 0으로, 나머지는 무한대로 초기화
			
			for (int i = 0; i < N; i++) {
				String temp = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = temp.charAt(j) - '0';
				}
			}
			
			int[] dy = {1, -1, 0, 0}, dx = {0, 0, 1, -1};
			
			for (int i = 0; i < numNode; i++) { // 다익스트라
				int min = INF;
				int cur_y = -1, cur_x = -1;
				
				for (int j = 0; j < N; j++) {
					for (int j2 = 0; j2 < N; j2++) {
						if(!visited[j][j2] && min > min_distance[j][j2]) {
							min = min_distance[j][j2];
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
						min_distance[ny][nx] = Math.min(min_distance[ny][nx], min_distance[cur_y][cur_x] + map[ny][nx]);
					}
				}
			}
			
			sb.append(min_distance[N-1][N-1]).append("\n");
		}
		System.out.println(sb);
		
		
	}
}
