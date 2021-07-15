package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class JUNGOL_1840_치즈 {
	static int n, m, cheese[][], times = 0, cnt = 0, dy[] = {-1, 1, 0, 0}, dx[] = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		input();
		solve();
	}

	private static void solve() {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited;
		int c, cur[], curY, curX, nY, nX;
		while(true) {
			if(noCheese()) {
				System.out.println(times);
				System.out.println(cnt);
				return;
			}
			++times;
			visited = new boolean[n][m];
			q.offer(new int[] {0, 0});
			visited[0][0] = true;
			c = 0;
			while(!q.isEmpty()) {
				cur = q.poll();
				curY = cur[0];
				curX = cur[1];
				
				for (int dir = 0; dir < 4; dir++) {
					nY = curY + dy[dir];
					nX = curX + dx[dir];
					if(!isInRange(nY, nX) || visited[nY][nX]) {
						continue;
					}
					visited[nY][nX] = true;
					if(cheese[nY][nX] == 0) {
						q.offer(new int[] {nY, nX});
					} else {
						++c;
						cheese[nY][nX] = 0;
					}
				}
			}
			cnt = c;
		}
	}

	private static boolean isInRange(int y, int x) {
		return 0 <= y && y < n && 0 <= x && x < m;
	}

	private static boolean noCheese() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(cheese[i][j] == 1) {
					return false;
				}
			}
		}
		return true;
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = stoi(st.nextToken());
		m = stoi(st.nextToken());
		cheese = new int[n][m];
		
		String in;
		for (int i = 0; i < n; i++) {
			in = br.readLine();
			for (int j = 0, idx = 0; j < m; j++, idx+=2) {
				cheese[i][j] = in.charAt(idx) - '0';
				if(cheese[i][j] == 1) {
					++cnt;
				}
			}
		}
	}
	
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
