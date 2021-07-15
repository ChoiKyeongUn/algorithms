

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3109_빵집 {
	static int R, C;
	static char[][] map;
	static int[] dy = { -1, 0, 1 };
	static int result = 0;
	static boolean flag;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String temp = br.readLine();
			for (int j = 0; j < C; j++)
				map[i][j] = temp.charAt(j);
		}

		for (int i = 0; i < R; i++) {
			flag = false;
			dfs(i, 0);
		}
		System.out.println(result);
	}

	private static void dfs(int i, int j) {
		if (j == C - 1) {
			++result;
			flag = true;
			return;
		}
		if(flag) return;
		int nx = j + 1;
		for (int j2 = 0; j2 < 3; j2++) {
			if(flag) return;
			int ny = i + dy[j2];
			if (ny >= 0 && ny < R && map[ny][nx] == '.') {
				map[ny][nx] = 'x';
				dfs(ny, nx);
			}
		}
	}
}
