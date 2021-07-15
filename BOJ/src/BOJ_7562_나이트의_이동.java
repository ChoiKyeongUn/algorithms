

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7562_나이트의_이동 {
	static class Co {
		int y, x;
		public Co(int y, int x) { this.y = y; this.x = x; }
		@Override
		public String toString() { return "Co [y=" + y + ", x=" + x + "]"; }
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		outer:
		for (int tc = 0; tc < TC; tc++) {

			int I = Integer.parseInt(br.readLine());
			boolean[][] visited = new boolean[I][I];
			StringTokenizer st = new StringTokenizer(br.readLine());
			Co src = new Co(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			st = new StringTokenizer(br.readLine());
			int dst_y = Integer.parseInt(st.nextToken());
			int dst_x = Integer.parseInt(st.nextToken());
			visited[src.y][src.x] = true;
			Queue<Co> que = new LinkedList<Co>();
			que.add(src);
			int trys = 0;

			int[] dy = { -2, -1, 1, 2, 2, 1, -1, -2 };
			int[] dx = { 1, 2, 2, 1, -1, -2, -2, -1 };

			while (!que.isEmpty()) {
				int size = que.size();
				for (int j = 0; j < size; j++) {
					Co cur = que.poll();
					int cur_y = cur.y;
					int cur_x = cur.x;
					if(cur_y == dst_y && cur_x == dst_x) {
						System.out.println(trys);
						continue outer;
					}
					for (int k = 0; k < 8; k++) {
						int ny = cur_y + dy[k];
						int nx = cur_x + dx[k];
						if (ny >= 0 && ny < I && nx >= 0 && nx < I && !visited[ny][nx]) {
							visited[ny][nx] = true;
							que.add(new Co(ny, nx));
						}
					}
				}
				trys++;
			}
		}
	}
}