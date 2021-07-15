

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2638_치즈 {
	static class Loc {
		int y, x;
		public Loc(int y, int x) { this.y = y; this.x = x; }
		public String toString() { return "[y = " + y + ", x = " + x + "]"; }
	}
	static int N, M;
	static int[][] cheese, cnt;
	static int time = 0;
	static int[] dy = {-1, 0, 1, 0}, dx = {0, 1, 0, -1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cheese = new int[N][M];
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0, idx = 0; j < M; j++, idx+=2) {
				cheese[i][j] = temp.charAt(idx) - '0';
				if(cheese[i][j] == 1) cheese[i][j] = 4;
			}
		}
		
		while(bfs() > 0) {
			++time;
		}
		
		System.out.println(time);
	}
	
	private static int bfs() {
		boolean[][] visited = new boolean[N][M];
		Queue<Loc> queue = new LinkedList<>();
		queue.offer(new Loc(0, 0));
		visited[0][0] = true;
		int cnt = 0;
		
		while(!queue.isEmpty()) {
			Loc cur = queue.poll();
			int cur_y = cur.y;
			int cur_x = cur.x;
			for (int i = 0; i < 4; i++) {
				int ny = cur_y + dy[i];
				int nx = cur_x + dx[i];
				if(ny >= 0 && ny < N && nx >= 0 && nx < M) {
					if(!visited[ny][nx] && cheese[ny][nx] == 0) {
						visited[ny][nx] = true;
						queue.add(new Loc(ny, nx));
					} 
					if(cheese[ny][nx] != 0){
						if(cheese[ny][nx] > 3) --cheese[ny][nx];
						else {
							cnt++;
							cheese[ny][nx] = 0;
							visited[ny][nx] = true;
						}
					}
				}
			}
		}
		for (int i = 0; i < N; i++) for (int j = 0; j < M; j++)
			if(cheese[i][j] != 0) cheese[i][j] = 4;

		return cnt;
	}
}