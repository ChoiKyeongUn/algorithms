

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576_토마토 {
	public static class Co {
		int y, x;
		public Co(int y, int x) {
			this.y = y;
			this.x = x;
		}
		@Override
		public String toString() {
			return "Co [y=" + y + ", x=" + x + "]";
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][] tomato = new int[N][M];
		Queue<Co> que = new LinkedList<Co>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				tomato[i][j] = Integer.parseInt(st.nextToken());
				if (tomato[i][j] == 1) que.add(new Co(i, j));
			}
		}
		int day = 0;
		int[] dy = {-1, 0, 1, 0};
		int[] dx = {0, 1, 0, -1};
		while(!que.isEmpty()) {
			int size = que.size();
			for (int i = 0; i < size; i++) {
				Co cur = que.poll();
				for (int j = 0; j < 4; j++) {
					int ny = cur.y + dy[j];
					int nx = cur.x + dx[j];
					if(ny >= 0 && ny < N && nx >= 0 && nx < M && tomato[ny][nx] == 0) {
						que.add(new Co(ny, nx));
						tomato[ny][nx] = 1;
					}
				}
			}
			day++;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (tomato[i][j] == 0) {
					System.out.println(-1);
					return;
				}
			}
		}
		System.out.println(day-1);
	}
}
