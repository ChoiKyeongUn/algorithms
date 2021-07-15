import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3197_백조의_호수 {
	
	static int R, C, result = 0, dy[] = {-1, 1, 0, 0}, dx[] = {0, 0, -1, 1};
	static char[][] map;
	
	public static void main(String[] args) throws Exception {
		input();
		solve();
		System.out.println(result);
	}

	private static void solve() {
		while(!bfs()) {
			++result;
		}
	}

	private static boolean bfs() {
		
		boolean[][] visited = new boolean[R][C];
		Queue<int[]> q = new LinkedList<int[]>();
		
		outer:
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(!visited[i][j] && map[i][j] == 'L') {
					visited[i][j] = true;
					q.offer(new int[] {i, j});
					
					int cnt = 0;
					
					while(!q.isEmpty()) {
						int[] cur = q.poll();
						int curY = cur[0];
						int curX = cur[1];
						
						if(map[curY][curX] == 'L') {
							++cnt;
						}
						if(cnt == 2) {
							return true;
						}
						
						for (int k = 0; k < 4; k++) {
							int nY = curY + dy[k];
							int nX = curX + dx[k];
							
							if(isInRange(nY, nX) && !visited[nY][nX] && map[nY][nX] != 'X') {
								q.offer(new int[] {nY, nX});
								visited[nY][nX] = true;
							}
						}
					}
					break outer;
				}
			}
		}
		melt();
		
		return false;
	}

	private static void melt() {
		boolean[][] visited = new boolean[R][C];
		Queue<int[]> q = new LinkedList<int[]>();
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(!visited[i][j] && map[i][j] == '.') {
					visited[i][j] = true;
					q.offer(new int[] {i, j});
					
					while(!q.isEmpty()) {
						int[] cur = q.poll();
						int curY = cur[0];
						int curX = cur[1];
						
						for (int k = 0; k < 4; k++) {
							int nY = curY + dy[k];
							int nX = curX + dx[k];
							if(isInRange(nY, nX) && !visited[nY][nX]) {
								visited[nY][nX] = true;
								if(map[nY][nX] == 'X') {
									map[nY][nX] = 'z';
								} else if(map[nY][nX] == '.') {
									q.offer(new int[] {nY, nX});
								}
							}
						}
					}
				}
			}
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] == 'z') {
					map[i][j] = '.';
				}
			}
		}
	}

	private static boolean isInRange(int nY, int nX) {
		return 0 <= nY && nY < R && 0 <= nX && nX < C;
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = stoi(st.nextToken());
		C = stoi(st.nextToken());
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String temp = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = temp.charAt(j);
			}
		}
	}

	private static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
