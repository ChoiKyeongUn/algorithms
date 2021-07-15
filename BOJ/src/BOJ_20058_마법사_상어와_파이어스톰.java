

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_20058_마법사_상어와_파이어스톰 {
	static int N, Q, SIZE, total = 0, space = 0,
			   ices[][], L[], dy[] = {-1, 1, 0, 0}, dx[] = {0, 0, -1, 1};
	static boolean[][] visited;
	public static void main(String[] args) throws Exception {
		input();
		solve();
		printResult();
	}

	private static void printResult() {
		System.out.println(total);
		System.out.println(space);
	}

	private static void solve() {
		for (int l : L) {
			int size = 1<<l;
			for (int i = 0; i < SIZE; i+=size) {
				for (int j = 0; j < SIZE; j+=size) {
					rotate(i, j, size);

				}
			}
			melt();
		}
		
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				total += ices[i][j];
				if(!visited[i][j] && ices[i][j] > 0) {
					bfs(i, j);
				}
			}
		}
	}

	private static void bfs(int i, int j) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {i, j});
		visited[i][j] = true;
		int cnt = 0;
		while(!queue.isEmpty()) {
			++cnt;
			int[] cur = queue.poll();
			int cur_y = cur[0];
			int cur_x = cur[1];
			
			for (int k = 0; k < 4; k++) {
				int ny = cur_y + dy[k];
				int nx = cur_x + dx[k];
				if(isInRange(ny, nx) && !visited[ny][nx] && ices[ny][nx] > 0) {
					visited[ny][nx] = true;
					queue.offer(new int[] {ny, nx});
				}
			}
		}
		space = Math.max(space, cnt);
	}

	private static void melt() {
		int[][] copy_ices = new int[SIZE][SIZE];
		copy(copy_ices);
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if(ices[i][j] > 0) {
					int cnt = 0;
					for (int k = 0; k < 4; k++) {
						int ny = i + dy[k];
						int nx = j + dx[k];
						if(isInRange(ny, nx) && copy_ices[ny][nx] > 0) {
							++cnt;
						}
					}
					if(cnt < 3) {
						--ices[i][j];
					}
				}
			}
		}
	}

	private static void copy(int[][] copy_ices) {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				copy_ices[i][j] = ices[i][j];
			}
		}
	}

	private static boolean isInRange(int ny, int nx) {
		return 0 <= ny && ny < SIZE && 0 <= nx && nx < SIZE;
	}

	private static void rotate(int i, int j, int size) {
		int[][] temp = new int[size][size];
		for (int k = i; k < i+size; k++) {
			for (int k2 = j; k2 < j+size; k2++) {
				temp[k2-j][size-1+i-k] = ices[k][k2];
			}
		}
		for (int k = 0; k < size; k++) {
			for (int k2 = 0; k2 < size; k2++) {
				ices[i+k][j+k2] = temp[k][k2];
			}
		}
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		Q = stoi(st.nextToken());
		SIZE = 1<<N;
		ices = new int[SIZE][SIZE];
		for (int i = 0; i < SIZE; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < SIZE; j++) {
				ices[i][j] = stoi(st.nextToken());
			}
		}
		L = new int[Q];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < Q; i++) {
			L[i] = stoi(st.nextToken());
		}
		
		visited = new boolean[SIZE][SIZE];
	}

	private static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
