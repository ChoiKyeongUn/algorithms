package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class JUNGOL_1457_영역_구하기 {
	static int n, m, k, back[][], dy[] = {-1, 1, 0, 0}, dx[] = {0, 0, -1, 1};
	static boolean visited[][];
	static List<Integer> result = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		input();
		bfs();
	}

	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		int cur[], curY, curX, nY, nX, add;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(back[i][j] == 1 || visited[i][j]) {
					continue;
				}
				
				add = 1;
				visited[i][j] = true;
				q.offer(new int[] {i, j});
				while(!q.isEmpty()) {
					cur = q.poll();
					curY = cur[0];
					curX = cur[1];
					
					for (int dir = 0; dir < 4; dir++) {
						nY = curY + dy[dir];
						nX = curX + dx[dir];
						
						if(isInRange(nY, nX) && back[nY][nX] == 0 && !visited[nY][nX]) {
							++add;
							visited[nY][nX] = true;
							q.offer(new int[] {nY, nX});
						}
					}
				}
				result.add(add);
			}
		}
		Collections.sort(result);
		System.out.println(result.size());
		for(int a: result) {
			System.out.print(a + " ");
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
		k = stoi(st.nextToken());
		back = new int[n][m];
		visited = new boolean[n][m];
		
		int sy, ey, sx, ex;
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			sx = stoi(st.nextToken());
			sy = stoi(st.nextToken());
			ex = stoi(st.nextToken());
			ey = stoi(st.nextToken());
			for (int y = sy; y < ey; y++) {
				for (int x = sx; x < ex; x++) {
					back[y][x] = 1;
				}
			}
		}
	}
	
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
