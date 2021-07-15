

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_16236_아기_상어 {
	static class Co {
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

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] space = new int[N][N];
		String temp = null;
		int shark_size = 2, feed = 0;
		int cur_x = 0, cur_y = 0;
		int[] dy = {-1, 0, 0, 1};
		int[] dx = {0, -1, 1, 0};
		for (int i = 0; i < N; i++) {
			temp = br.readLine();
			for (int j = 0, idx = 0; j < N; j++, idx+=2) {
				space[i][j] = temp.charAt(idx) - '0';
				if(space[i][j] == 9) {
					cur_y = i; cur_x = j;
					space[i][j] = 0;
				}
			}
		}
		int result = 0;
		Queue<Co> queue = new LinkedList<>();
		boolean[][] visited;
		while(true) {
			boolean flag = false;
			queue.clear();
			visited = new boolean[N][N];
			visited[cur_y][cur_x] = true;
			queue.offer(new Co(cur_y, cur_x));
			int time = 0;
			if(feed == shark_size) {
				feed = 0;
				++shark_size;
			}
			sub:
			while(!queue.isEmpty()) {
				int size = queue.size();
				Co[] feed_array = new Co[size];
				int idx = 0;
				boolean flag2 = false;
				for (int i = 0; i < size; i++) {
					Co cur = queue.poll();
					int c_y = cur.y, c_x = cur.x;
					if(space[c_y][c_x] > 0 && space[c_y][c_x] < shark_size) {
//						++feed;
//						flag = true;
//						cur_y = c_y; cur_x = c_x;
//						result += time;
//						space[c_y][c_x] = 0;
//						break sub;
						feed_array[idx++] = cur;
						flag2 = true;
					}
					
					if(!flag2) {
						for (int j = 0; j < 4; j++) {
							int ny = c_y + dy[j], nx = c_x + dx[j];
							if(ny >= 0 && ny < N && nx >= 0 && nx < N && !visited[ny][nx] && space[ny][nx] <= shark_size) {
									visited[ny][nx] = true;
									queue.offer(new Co(ny, nx));
								
							}
						}
					}
				}
				if(flag2) {
					int min_y = Integer.MAX_VALUE, min_x = Integer.MAX_VALUE;
					int select = -1;
					for (int i = 0; i < idx; i++) {
						int yy = feed_array[i].y, xx = feed_array[i].x;
						if(min_y > yy) {
							select = i; min_y = yy; min_x = xx;
						} else if (min_y == yy) {
							if(min_x > xx) {
								select = i; min_x = xx;
							}
						}
					}
					++feed;
					flag = true;
					cur_y = feed_array[select].y; cur_x = feed_array[select].x;
					result += time;
					space[cur_y][cur_x] = 0;
					break sub;
				}
				++time;
			}
			if(!flag) break;
		}
		System.out.println(result);
	}
}
