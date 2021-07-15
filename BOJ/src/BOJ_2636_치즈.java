

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2636_치즈 {
	static class Loc {
		int y, x;
		public Loc(int y, int x) { this.y = y; this.x = x; }
		public String toString() { return "[y = " + y + ", x = " + x + "]"; }
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int height = Integer.parseInt(st.nextToken()); 
		int width = Integer.parseInt(st.nextToken());
		int[][] cheese = new int[height][width];
		boolean[][] visited = new boolean[height][width];
		int[] dy = {-1, 0, 1, 0};
		int[] dx = {0, 1, 0, -1};
		
		Queue<Loc> temp_q = new LinkedList<Loc>();
		int total = 0;
		for (int i = 0; i < height; i++) {
			String temp = br.readLine();
			for (int j = 0, idx = 0; j < width; j++, idx+=2) {
				cheese[i][j] = temp.charAt(idx) - '0';
				if(cheese[i][j] == 1) ++total;
			}
		}
		
		temp_q.offer(new Loc(0, 0));
		visited[0][0] = true;
		Queue<Loc> real_q = new LinkedList<>();
		while(!temp_q.isEmpty()) {
			Loc cur = temp_q.poll();
			int cur_y = cur.y;
			int cur_x = cur.x;
			
			for (int i = 0; i < 4; i++) {
				int ny = cur_y + dy[i];
				int nx = cur_x + dx[i];
				if(ny >= 0 && ny < height && nx >= 0 && nx < width && !visited[ny][nx] && cheese[ny][nx] == 0) {
					visited[ny][nx] = true;
					temp_q.offer(new Loc(ny, nx));
					for (int j = 0; j < 4; j++) {
						int nny = ny + dy[j];
						int nnx = nx + dx[j];
						if(nny >= 0 && nny < height && nnx >= 0 && nnx < width && !visited[nny][nnx] && cheese[nny][nnx] == 1) {
							real_q.offer(new Loc(ny, nx));
							break;
						}
					}
				}
			}
		}
		int time = 0;
		int remain = 0;
		while(!real_q.isEmpty()) {
			time++;
			remain = 0;
			int q_size = real_q.size();
			for (int i = 0; i < q_size; i++) {
				Loc cur = real_q.poll();
				int cur_y = cur.y;
				int cur_x = cur.x;
				for (int j = 0; j < 4; j++) {
					int ny = cur_y + dy[j];
					int nx = cur_x + dx[j];
					if(ny >= 0 && ny < height && nx >= 0 && nx < width && !visited[ny][nx] && cheese[ny][nx] == 1) {
						remain++;
						cheese[ny][nx] = 0;
						visited[ny][nx] = true;
						
					}
				}
			}
			
			visited = new boolean[height][width];
			temp_q.offer(new Loc(0, 0));
			visited[0][0] = true;
			while(!temp_q.isEmpty()) {
				Loc cur = temp_q.poll();
				int cur_y = cur.y;
				int cur_x = cur.x;
				
				for (int i = 0; i < 4; i++) {
					int ny = cur_y + dy[i];
					int nx = cur_x + dx[i];
					if(ny >= 0 && ny < height && nx >= 0 && nx < width && !visited[ny][nx] && cheese[ny][nx] == 0) {
						visited[ny][nx] = true;
						temp_q.offer(new Loc(ny, nx));
						for (int j = 0; j < 4; j++) {
							int nny = ny + dy[j];
							int nnx = nx + dx[j];
							if(nny >= 0 && nny < height && nnx >= 0 && nnx < width && !visited[nny][nnx] && cheese[nny][nnx] == 1) {
								real_q.offer(new Loc(ny, nx));
								break;
							}
						}
					}
				}
			}
		}
		System.out.println(time);
		System.out.println(remain);
	}
}