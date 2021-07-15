package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class JUNGOL_1695_단지번호붙이기 {
	static int N, apt[][], dy[] = {-1, 1, 0, 0}, dx[] = {0, 0, -1, 1};
	static boolean visited[][];
	static List<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		input();
		bfs();
	}
	
	private static void bfs() {
		int add, cur[], curY, curX, nY, nX;
		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(apt[i][j] == 0 || visited[i][j]) {
					continue;
				}
				
				visited[i][j] = true;
				add = 1;
				q.offer(new int[] {i, j});
				
				while(!q.isEmpty()) {
					cur = q.poll();
					curY = cur[0];
					curX = cur[1];
					
					for (int dir = 0; dir < 4; dir++) {
						nY = curY + dy[dir]; 
						nX = curX + dx[dir];
						if(isInRange(nY, nX) && apt[nY][nX] == 1 && !visited[nY][nX]) {
							visited[nY][nX] = true;
							++add;
							q.offer(new int[] {nY, nX});
						}
					}
				}
				list.add(add);
			}
		}
		Collections.sort(list);
		System.out.println(list.size());
		for(int a: list) {
			System.out.println(a);
		}
	}

	private static boolean isInRange(int y, int x) {
		return 0 <= y && y < N && 0 <= x && x < N;
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = stoi(br.readLine());
		apt = new int[N][N];
		visited = new boolean[N][N];
		String in;
		for (int i = 0; i < N; i++) {
			in = br.readLine();
			for (int j = 0; j < N; j++) {
				apt[i][j] = in.charAt(j) - '0';
			}
		}
	}
	
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
