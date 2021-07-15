package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SWEA_1868_파핑파핑_지뢰찾기_D4 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static int N, result, dy[] = {-1, -1, 0, 1, 1, 1, 0, -1}, dx[] = {0, 1, 1, 1, 0, -1, -1, -1};
	static int[][] board;
	static boolean[][] visited;
	static Queue<int[]> q = new LinkedList<int[]>();
	
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
		result = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j] && board[i][j] == 0) {
					++result;
					bfs(i, j);
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j] && board[i][j] > 0) {
					++result;
				}
			}
		}
	}

	private static void bfs(int i, int j) {
		q.clear();
		visited[i][j] = true;
		q.offer(new int[] {i, j});
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int curY = cur[0];
			int curX = cur[1];
			
			for (int k = 0; k < 8; k++) {
				int ny = curY + dy[k];
				int nx = curX + dx[k];
				if(isInRange(ny, nx) && !visited[ny][nx] && board[ny][nx] != -1) {
					visited[ny][nx] = true;
					if(board[ny][nx] == 0) {
						q.offer(new int[] {ny, nx});
					} 
				}
			}
		}
	}

	private static boolean isInRange(int nY, int nX) {
		return 0 <= nY && nY < N && 0 <= nX && nX < N;
	}

	private static void input() throws Exception {
		N = stoi(br.readLine());
		board = new int[N][N];
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < N; j++) {
				char c = temp.charAt(j);
				if(c == '*') {
					for (int k = 0; k < 8; k++) {
						int ny = i + dy[k];
						int nx = j + dx[k];
						if(isInRange(ny, nx) && board[ny][nx] != -1) ++board[ny][nx];
					}
					board[i][j] = -1;
				}
			}
		}
		visited = new boolean[N][N];
	}

	private static void saveResult(int tc) {
		sb.append("#").append(tc).append(" ").append(result).append("\n");
	}

	private static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
