

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7569_토마토 {
	static class Co_3D {
		int z, y, x;

		public Co_3D(int z, int y, int x) {
			this.z = z;
			this.y = y;
			this.x = x;
		}
		@Override
		public String toString() {
			return "Co_3D [z=" + z + ", y=" + y + ", x=" + x + "]";
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int[][][] tomatos = new int[H][N][M];
		boolean[][][] visited = new boolean[H][N][M];
		Queue<Co_3D> queue = new LinkedList<Co_3D>();
		for (int i = 0; i < H; i++)
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int j2 = 0; j2 < M; j2++) {
					tomatos[i][j][j2] = Integer.parseInt(st.nextToken());
					if (tomatos[i][j][j2] == 1) {
						queue.add(new Co_3D(i, j, j2));
						visited[i][j][j2] = true;
					}
				}
			}
		int[] dz = { -1, 1, 0, 0, 0, 0 };
		int[] dy = { 0, 0, 0, 0, 1, -1 };
		int[] dx = { 0, 0, 1, -1, 0, 0 };
		
		int days = 0;
		while(!queue.isEmpty()) {
			days++;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Co_3D cur = queue.poll();
				int cur_z = cur.z;
				int cur_y = cur.y;
				int cur_x = cur.x;
				for (int j = 0; j < 6; j++) {
					int nz = cur_z + dz[j];
					int ny = cur_y + dy[j];
					int nx = cur_x + dx[j];
					if (nz >= 0 && nz < H && ny >= 0 && ny < N && nx >= 0 && nx < M && !visited[nz][ny][nx] && tomatos[nz][ny][nx] == 0) {
						visited[nz][ny][nx] = true;
						tomatos[nz][ny][nx] = 1;
						queue.add(new Co_3D(nz, ny, nx));
					}
				}
			}
		}
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < M; j2++) {
					if (tomatos[i][j][j2] == 0) {
						System.out.println(-1);
						return;
					}
				}
			}
		}
		System.out.println(days-1);
	}
}
