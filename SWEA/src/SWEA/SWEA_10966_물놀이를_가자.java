package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_10966_물놀이를_가자 {
	static class Co {
		int y, x;
		public Co(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int[] dy = {-1, 1, 0 ,0};
		int[] dx = {0, 0, -1, 1};
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			char[][] pool = new char[N][M];
			boolean[][] visited = new boolean[N][M];
			List<Co> list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				String temp = br.readLine();
				for (int j = 0; j < M; j++) {
					pool[i][j] = temp.charAt(j);
					if(pool[i][j] == 'W') list.add(new Co(i, j));
				}
			}
			int[][] distance = new int[N][M];
			int cnt = 0;
			
			Queue<Co> queue = new LinkedList<>();
			int list_size = list.size();
			
			for (int i = 0; i < list_size; i++) {
				Co temp = list.get(i);
				queue.offer(temp);
				visited[temp.y][temp.x] = true;
			}
			int dist = 1;
			while(!queue.isEmpty()) {
				int size = queue.size();
				for (int i = 0; i < size; i++) {
					Co cur = queue.poll();
					int cur_y = cur.y, cur_x = cur.x;
					for (int j = 0; j < 4; j++) {
						int ny = cur_y + dy[j];
						int nx = cur_x + dx[j];
						if(ny >= 0 && ny < N && nx >= 0 && nx < M && !visited[ny][nx] && pool[ny][nx] == 'L') {
							visited[ny][nx] = true;
							distance[ny][nx] = dist;
							queue.offer(new Co(ny, nx));
						}
					}
				}
				++dist;
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					cnt += distance[i][j];
				}
			}

			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
}