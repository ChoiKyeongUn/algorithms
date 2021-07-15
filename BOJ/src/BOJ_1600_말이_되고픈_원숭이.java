

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1600_말이_되고픈_원숭이 {
	static int K, W, H;
	static int[][] land;
	static boolean[][][] visited;
	static int[] dy_knight = {-1, -2, -2, -1, 1, 2, 2, 1}, dx_knight = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int[] dy = {-1, 0, 1, 0}, dx = {0, 1, 0, -1};
	
	static class Loc {
		int y, x, k;
		public Loc(int y, int x, int k) { this.y = y; this.x = x; this.k = k; }
		public String toString() { return "Loc [y=" + y + ", x=" + x + ", k=" + k + "]"; }
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		land = new int[H][W];
		visited = new boolean[H][W][K+1];
		for (int i = 0; i < H; i++) {
			String temp = br.readLine();
			for (int j = 0, idx = 0; j < W; j++, idx+=2)
				land[i][j] = temp.charAt(idx) - '0';
		}
		
		Queue<Loc> queue = new LinkedList<>();
		visited[0][0][K] = true;
		queue.offer(new Loc(0, 0, K));
		
		int time = 0;
		while(!queue.isEmpty()) {
			int queueSize = queue.size();
			for (int i = 0; i < queueSize; i++) {
				Loc cur = queue.poll();
				int cur_y = cur.y;
				int cur_x = cur.x;
				int cur_k = cur.k;
				if(cur_y == H-1 && cur_x == W-1) {
					System.out.println(time);
					return;
				}
				for (int j = 0; j < 4; j++) {
					int ny = cur_y + dy[j];
					int nx = cur_x + dx[j];
					if(ny >= 0 && ny < H && nx >= 0 && nx < W && !visited[ny][nx][cur_k] && land[ny][nx] != 1) {
						queue.offer(new Loc(ny, nx, cur_k));
						visited[ny][nx][cur_k] = true;
					}
				}
				if(cur_k > 0)
					for (int j = 0; j < 8; j++) {
						int ny = cur_y + dy_knight[j];
						int nx = cur_x + dx_knight[j];
						if(ny >= 0 && ny < H && nx >= 0 && nx < W && !visited[ny][nx][cur_k-1] && land[ny][nx] != 1) {
							queue.offer(new Loc(ny, nx, cur_k-1));
							visited[ny][nx][cur_k-1] = true;
						}
					}
			}
			++time;
		}
		System.out.println(-1);
	}
}
