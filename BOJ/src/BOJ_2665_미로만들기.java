

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BOJ_2665_미로만들기 {
	static final int INF = 100;
	static int n, result = 0, miro[][], min_distance[][], dy[] = {-1, 1, 0, 0}, dx[] = {0, 0, -1, 1};
	static boolean visited[][];
	public static void main(String[] args) throws Exception {
		input();
		dijkstra();
		System.out.println(min_distance[n-1][n-1]);
	}

	private static void dijkstra() {
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((o1, o2) -> (o1[2] - o2[2]));
		pq.offer(new int[] {0, 0, 0});
		
		while(!pq.isEmpty()) {
			if(visited[n-1][n-1]) break;
			
			int[] cur = pq.poll();
			int cur_y = cur[0];
			int cur_x = cur[1];
			if(visited[cur_y][cur_x]) continue;
			
			visited[cur_y][cur_x] = true;
			int cur_dist = cur[2];
			
			for (int i = 0; i < 4; i++) {
				int ny = cur_y + dy[i];
				int nx = cur_x + dx[i];
				if(isInRange(ny, nx) && !visited[ny][nx] && min_distance[ny][nx] > cur_dist + miro[ny][nx]) {
					min_distance[ny][nx] = cur_dist + miro[ny][nx];
					pq.offer(new int[] {ny, nx, min_distance[ny][nx]});
				}
			}
		}
	}

	private static boolean isInRange(int ny, int nx) {
		return 0 <= ny && ny < n && 0 <= nx && nx < n;
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = stoi(br.readLine());
		miro = new int[n][n];
		for (int i = 0; i < n; i++) {
			String temp = br.readLine();
			for (int j = 0; j < n; j++) {
				miro[i][j] = (temp.charAt(j) - '0' + 1) % 2;
			}
		}
		min_distance = new int[n][n];
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(min_distance[i], INF);
		}
		min_distance[0][0] = 0;
	}

	private static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
