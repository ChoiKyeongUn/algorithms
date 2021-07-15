package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class JUNGOL_1111_등산로_찾기 {
	
	static int n, map[][], minDistance[][], hy, hx, dy[] = {-1, 1, 0, 0}, dx[] = {0, 0, -1, 1};
	static boolean visited[][];
	static final int INF = 50 * 50 * 101 * 101;
	
	public static void main(String[] args) throws Exception {
		input();
		dijkstra();
//		printTest();
		int ry = hy, rx = hx;
		int result = INF;
		for (int i = 0; i < n; i++) {
			if(result > minDistance[0][i] + map[0][i] * map[0][i]) {
				result = minDistance[0][i] + map[0][i] * map[0][i];
				ry = 0; rx = i;
			}
			if(result > minDistance[n-1][i] + map[n-1][i] * map[n-1][i]) {
				result = minDistance[n-1][i] + map[n-1][i] * map[n-1][i];
				ry = n-1; rx = i;
			}
			if(result > minDistance[i][n-1] + map[i][n-1] * map[i][n-1]) {
				result = minDistance[i][n-1] + map[i][n-1] * map[i][n-1];
				ry = i; rx = n-1;
			}
			if(result > minDistance[i][0] + map[i][0] * map[i][0]) {
				result = minDistance[i][0] + map[i][0] * map[i][0];
				ry = i; rx = 0;
			}
		}
//		System.out.println(ry);
//		System.out.println(rx);
		System.out.println(result);
	}

	private static void printTest() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.printf("%4d ", map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.printf("%4d ", minDistance[i][j]);
			}
			System.out.println();
		}
	}

	private static void dijkstra() {
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o1[2] - o2[2]));
		pq.offer(new int[] {hy, hx, 0});
		minDistance[hy][hx] = 0;
		int cur[], cy, cx, cd, ny, nx, nd;
		while(!pq.isEmpty()) {
			cur = pq.poll();
			cy = cur[0];
			cx = cur[1];
			if(visited[cy][cx]) {
				continue;
			}
			
			visited[cy][cx] = true;
			cd = cur[2];
			minDistance[cy][cx] = cd;
			
			for (int dir = 0; dir < 4; dir++) {
				ny = cy + dy[dir];
				nx = cx + dx[dir];
				if(isInRange(ny, nx)) {
					nd = getDistance(cy, cx, ny, nx);
					if(minDistance[ny][nx] > cd + nd) {
						pq.offer(new int[] {ny, nx, cd + nd});
						minDistance[ny][nx] = cd + nd;
					}
				}
			}
		}
	}

	private static int getDistance(int cy, int cx, int ny, int nx) {
		if(map[cy][cx] == map[ny][nx]) {
			return 0;
		} else if(map[cy][cx] < map[ny][nx]) {
			return map[ny][nx] - map[cy][cx];
		}
		int temp = map[cy][cx] - map[ny][nx]; 
		return temp * temp;
	}

	private static boolean isInRange(int y, int x) {
		return 0 <= y && y < n && 0 <= x && x < n;
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = stoi(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		hy = stoi(st.nextToken()) - 1;
		hx = stoi(st.nextToken()) - 1;
		map = new int[n][n];
		minDistance = new int[n][n];
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			st = new  StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = stoi(st.nextToken());
				minDistance[i][j] = INF;
			}
		}
	}
	
	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
