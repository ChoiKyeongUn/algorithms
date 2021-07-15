package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class JUNGOL_1106_장기 {
	
	static int n, m, goalY, goalX;
	static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2}, dx = {1, 2, 2, 1, -1, -2, -2, -1};
	static boolean visited[][];
	
	public static void main(String[] args) throws Exception {
		Queue<int[]> q = input();
		bfs(q);
	}

	private static void bfs(Queue<int[]> q) {
		int result = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			while(size-- > 0) {
				int[] cur = q.poll();
				int curY = cur[0];
				int curX = cur[1];
				
				if(curY == goalY && curX == goalX) {
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
			result++;
		}
	}

	private static boolean isInRange(int y, int x) {
		return 0 <= y && y < n && 0 <= x && x < m;
	}

	private static Queue<int[]> input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<int[]> q = new LinkedList<>();
		n = stoi(st.nextToken());
		m = stoi(st.nextToken());
		visited = new boolean[n][m];
		st = new StringTokenizer(br.readLine());
		int y = stoi(st.nextToken());
		int x = stoi(st.nextToken());
		visited[y][x] = true;
		q.offer(new int[] {y, x});
		goalY = stoi(st.nextToken());
		goalX = stoi(st.nextToken());
		
		return q;
	}
	
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
