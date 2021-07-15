

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2573_빙산 {
	static class Co {
		int y, x;
		public Co(int y, int x) { this.y = y; this.x = x; }
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
//		int N = 5;
		int M = Integer.parseInt(st.nextToken());
//		int M = 7;
		int[][] ices = new int[N][M];
//		int[][] ices = {{0, 0, 0, 0, 0, 0, 0},
//						{0, 2, 4, 5, 3, 0, 0},
//						{0, 3, 0, 2, 5, 2, 0},
//						{0, 7, 6, 2, 4, 0, 0},
//						{0, 0, 0, 0, 0, 0, 0}};
		boolean[][] visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) 
				ices[i][j] = Integer.parseInt(st.nextToken());
		}
		Queue<Co> que = new LinkedList<>();
		int days = 0;
		boolean flag = false;
		int[] dy = {1, -1, 0, 0};
		int[] dx = {0, 0, 1, -1};

		while(true) {
			int part = 0;
			visited = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(ices[i][j] > 0 && !visited[i][j]) {
						que.add(new Co(i, j));
						visited[i][j] = true;
						while(!que.isEmpty()) {
							Co cur = que.poll();
							int cur_y = cur.y;
							int cur_x = cur.x;
							for (int k = 0; k < 4; k++) {
								int ny = cur_y + dy[k];
								int nx = cur_x + dx[k];
								if(ny >= 0 && ny < N && nx >= 0 && nx < M && !visited[ny][nx] && ices[ny][nx] > 0) {
									que.add(new Co(ny, nx));
									visited[ny][nx] = true;
								}
							}
						}
						part++;
					}
				}
			}
			if(part >= 2) {
				flag = true;
				break;
			}
			
			if(part == 0) break;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					for (int j2 = 0; j2 < 4; j2++) {
						int ny = i + dy[j2];
						int nx = j + dx[j2];
						if (ices[i][j] > 0 && ny >= 0 && ny < N && nx >= 0 && nx < M && !visited[ny][nx]) {
							ices[i][j]--;
						}
					}
				}
			}
			days++;
		}
		if(flag) System.out.println(days);
		else System.out.println(0);
	}
}
