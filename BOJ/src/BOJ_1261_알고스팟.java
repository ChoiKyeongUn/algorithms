

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1261_알고스팟 {
	static class Loc {
		int y, x, block;
		public Loc(int y, int x, int block) {
			this.y = y;
			this.x = x;
			this.block = block;
		}
		@Override
		public String toString() {
			return "Loc [y=" + y + ", x=" + x + ", block=" + block + "]";
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][] miro = new int[N][M];
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < M; j++) {
				miro[i][j] = temp.charAt(j) - '0';
			}
		}

		int[] dy = {-1, 1, 0, 0}, dx = {0, 0, 1, -1};
		
		
		boolean[][] visited = new boolean[N][M];
		int[][] distance = new int[N][M];
		
		final int INF = 15000;
		for (int i = 0; i < N; i++) for (int j = 0; j < M; j++) distance[i][j] = INF; 
		distance[0][0] = 0;
		
		for (int i = 0; i < N*M; i++) {
			int min = INF;
			int y = -1;
			int x = -1;
			
			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < M; j2++) {
					if(!visited[j][j2] && distance[j][j2] < min) {
						min = distance[j][j2];
						y = j;
						x = j2;
					}
				}
			}
				
			visited[y][x] = true;
			
			for (int j = 0; j < 4; j++) {
				int ny = y + dy[j];
				int nx = x + dx[j];
				if(ny < 0 || ny >= N || nx < 0 || nx >= M || visited[ny][nx]) {
					continue;
				}
				distance[ny][nx] = Math.min(distance[ny][nx], min + miro[ny][nx]);
			}
		}
		
		System.out.println(distance[N-1][M-1]);
		
	}
}
