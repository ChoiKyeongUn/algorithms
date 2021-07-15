package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class JUNGOL_4189_장기2 {
	
	static int n, m, start[] = new int[2], end[] = new int[2], result = 0;
	static boolean visited[][];
	static int dy[] = {-2, -1, 1, 2, 2, 1, -1, -2}, dx[] = {1, 2, 2, 1, -1, -2, -2, -1};
	
	public static void main(String[] args) throws Exception {
		input();
		solve();
	}

	private static void solve() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(start);
		
		while(!q.isEmpty()) {
			int size = q.size();
			while(size-- > 0) {
				 int cur[] = q.poll();
				 int curY = cur[0];
				 int curX = cur[1];
				 
				 if(curY == end[0] && curX == end[1]) {
					 System.out.println(result);
					 return;
				 }
				 
				 for (int dir = 0; dir < 8; dir++) {
					int nY = curY + dy[dir];
					int nX = curX + dx[dir];
					
					if(isInRange(nY, nX) && !visited[nY][nX]) {
						visited[nY][nX] = true;
						q.offer(new int[] {nY, nX});
					}
				}
			}
			++result;
		}
	}

	private static boolean isInRange(int y, int x) {
		return 0 <= y && y < n && 0 <= x && x < m;
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = stoi(st.nextToken());
		m = stoi(st.nextToken());
		visited = new boolean[n][m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 2; i++) {
			start[i] = stoi(st.nextToken()) - 1;
		}
		visited[start[0]][start[1]] = true;
		for (int i = 0; i < 2; i++) {
			end[i] = stoi(st.nextToken()) - 1;
		}
	}
	
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
