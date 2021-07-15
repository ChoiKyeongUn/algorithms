

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1987_알파벳 {
	static int R, C, result = 0;
	static char[][] board;
	static boolean[] visited;
	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, 1, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		board = new char[R][];
		visited = new boolean[26];
		for (int i = 0; i < R; i++) board[i] = br.readLine().toCharArray();
		
		visited[board[0][0] - 'A'] = true;
		dfs(0, 0, 1);
		System.out.println(result);
	}
	
	static void dfs(int r, int c, int cnt) {
		result = Math.max(result, cnt);
		for (int i = 0; i < 4; i++) {
			int nr = r + dy[i];
			int nc = c + dx[i];
			if(nr < 0 || nr >= R || nc < 0 || nc >= C || visited[board[nr][nc] - 'A']) continue;
			visited[board[nr][nc] - 'A'] = true;
			dfs(nr, nc, cnt+1);
			visited[board[nr][nc] - 'A'] = false;
		}
	}
}
