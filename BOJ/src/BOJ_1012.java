

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class BOJ_1012_coor {
	int y, x;

	public BOJ_1012_coor(int y, int x) {
		super();
		this.y = y;
		this.x = x;
	}
}

public class BOJ_1012 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[][] cabbages = new int[N][M];
			boolean[][] visited = new boolean[N][M];
			int x, y;
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				cabbages[y][x] = 1;
			}
			int cnt = 0;
			int present_y, present_x;
			Queue<BOJ_1012_coor> que = new LinkedList<BOJ_1012_coor>();
			for (int i = 0; i < N; i++)
				for (int j = 0; j < M; j++)
					if (cabbages[i][j] == 1 && !visited[i][j]) {
						visited[i][j] = true;
						que.add(new BOJ_1012_coor(i, j));
						cnt++;
						while (!que.isEmpty()) {
							BOJ_1012_coor present = que.poll();
							present_y = present.y;
							present_x = present.x;
							if (present_y < N - 1 && cabbages[present_y + 1][present_x] == 1
									&& !visited[present_y + 1][present_x]) {
								visited[present_y + 1][present_x] = true;
								que.add(new BOJ_1012_coor(present_y + 1, present_x));
							}
							if (present_y > 0 && cabbages[present_y - 1][present_x] == 1
									&& !visited[present_y - 1][present_x]) {
								visited[present_y - 1][present_x] = true;
								que.add(new BOJ_1012_coor(present_y - 1, present_x));
							}
							if (present_x < M - 1 && cabbages[present_y][present_x + 1] == 1
									&& !visited[present_y][present_x + 1]) {
								visited[present_y][present_x + 1] = true;
								que.add(new BOJ_1012_coor(present_y, present_x + 1));
							}
							if (present_x > 0 && cabbages[present_y][present_x - 1] == 1
									&& !visited[present_y][present_x - 1]) {
								visited[present_y][present_x - 1] = true;
								que.add(new BOJ_1012_coor(present_y, present_x - 1));

							}
						}
					}
			System.out.println(cnt);
		}
	}
}
