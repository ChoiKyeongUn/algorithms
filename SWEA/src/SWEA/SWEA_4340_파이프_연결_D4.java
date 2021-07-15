package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_4340_파이프_연결_D4 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static Queue<int[]> queue = new LinkedList<>();

	static int result, N, pipes[][];
	static boolean inStraight, outStraight, visited[][][];

	static int dy[][] = { {}, { 0, 0 }, { -1, 1 }, { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 } };
	static int dx[][] = { {}, { -1, 1 }, { 0, 0 }, { 0, 1 }, { -1, 0 }, { -1, 0 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		int T = stoi(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			input();
			solve();
			saveResult(tc);
		}
		System.out.println(sb);
	}

	private static void solve() {
		queue.clear();
		if (inStraight) {
			if (pipes[0][1] <= 2) {
				queue.offer(new int[] { 0, 0, 0, 1, 1 });
			} else {
				queue.offer(new int[] { 0, 0, 0, 1, 4 });
			}
		} else {
			if (pipes[0][1] <= 2) {
				queue.offer(new int[] { 0, 0, 0, 1, 2 });
			} else {
				queue.offer(new int[] { 0, 0, 0, 1, 6 });
			}
		}

		while (!queue.isEmpty()) {
			int size = queue.size();
			++result;
			while (size-- > 0) {
				int[] cur = queue.poll();
				int prevY = cur[0];
				int prevX = cur[1];
				int curY = cur[2];
				int curX = cur[3];
				int curDir = cur[4];

				if (isConnectedFinal(curY, curX, curDir)) {
					return;
				}

				switch (curDir) {
				case 1:
				case 2:
					for (int dir = 1; dir <= 2; dir++) {
						for (int i = 0; i < 2; i++) {
							int nY = curY + dy[dir][i];
							int nX = curX + dx[dir][i];

							if (isInRange(nY, nX) || (nY == prevY && nX == prevX) || pipes[nY][nX] == 0
									|| visited[nY][nX][dir])
								continue;
							visited[nY][nX][dir] = true;
							queue.offer(new int[] { curY, curX, nY, nX, dir });
						}
					}
					break;
				default:
					for (int dir = 3; dir <= 6; dir++) {
						for (int i = 0; i < 2; i++) {
							int nY = curY + dy[dir][i];
							int nX = curX + dx[dir][i];

							if (isInRange(nY, nX) || (nY == prevY && nX == prevX) || pipes[nY][nX] == 0
									|| visited[nY][nX][dir])
								continue;
							visited[nY][nX][dir] = true;
							queue.offer(new int[] { curY, curX, nY, nX, dir });
						}
					}
				}
			}
		}
	}

	private static boolean isConnectedFinal(int y, int x, int dir) {
		if (outStraight) {
			if (y == N - 1 && x == N - 2) {
				for (int i = 0; i < 2; i++) {
					int ny = y + dy[dir][i];
					int nx = x + dx[dir][i];

					if (ny == N - 1 && nx == N - 1) {
						return true;
					}
				}
				return false;
			} else {
				return false;
			}
		} else {
			if (y == N - 2 && x == N - 1) {
				for (int i = 0; i < 2; i++) {
					int ny = y + dy[dir][i];
					int nx = x + dx[dir][i];

					if (ny == N - 1 && nx == N - 1) {
						return true;
					}
				}
				return false;
			} else {
				return false;
			}
		}
	}

	private static boolean isInRange(int y, int x) {
		return 0 <= y && y < N && 0 <= x && x < N;
	}

	private static void input() throws Exception {
		N = stoi(br.readLine());
		pipes = new int[N][N];
		visited = new boolean[N][N][7];
		for (int i = 0; i < 7; i++) {
			visited[0][0][i] = true;
			visited[0][1][i] = true;
		}
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				pipes[i][j] = stoi(st.nextToken());
			}
		}
		result = 2;

		if (pipes[0][0] == 1) {
			inStraight = true;
		} else {
			inStraight = false;
		}

		if (pipes[N - 1][N - 1] == 1) {
			outStraight = true;
		} else {
			outStraight = false;
		}
	}

	private static void saveResult(int tc) {
		sb.append("#").append(tc).append(" ").append(result).append("\n");
	}

	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
