package Programmers;

import java.util.Arrays;

public class Programmers_경주로_건설 {
	
	static final int INF = 500*625+10000;
	static int[] dy = {-1, 1, 0, 0}, dx = {0, 0, -1, 1};
	static int N;
	static int[][] minCost;
	static boolean[][] visited;
	
	public static int solution(int[][] board) {
		N = board.length;
		visited = new boolean[N][N];
		minCost = new int[N][N];
		visited[0][0] = true;
		for (int i = 0; i < N; i++) {
			Arrays.fill(minCost[i], INF);
		}
		dfs(0, 0, -1, 0);
		
		return 0;
	}
	
	private static void dfs(int y, int x, int prevDir, int totalCost) {
		if(y == N-1 && x == N-1) {
			return;
		}
		
		for(int dir = 0; dir < 4; dir++) {
			int ny = y + dy[dir];
			int nx = x + dx[dir];
			if(isInRange(ny, nx) && !visited[ny][nx]) {
				if(prevDir == -1) {
					visited[ny][nx] = true;
					dfs(ny, nx, dir, 100);
					visited[ny][nx] = false;
				} else if(prevDir == dir) {
					
				} else {
					
				}
			}
		}
	}

	private static boolean isInRange(int ny, int nx) {
		return 0 <= ny && ny < N && 0 <= nx && nx < N;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[][] {{0, 0, 0},
												 {0, 0, 0},
												 {0, 0, 0}}));
		
		System.out.println(solution(new int[][] {{0,0,0,0,0,0,0,1},
		                                         {0,0,0,0,0,0,0,0},
		                                         {0,0,0,0,0,1,0,0},
		                                         {0,0,0,0,1,0,0,0},
		                                         {0,0,0,1,0,0,0,1},
		                                         {0,0,1,0,0,0,1,0},
		                                         {0,1,0,0,0,1,0,0},
		                                         {1,0,0,0,0,0,0,0}}));
		
		System.out.println(solution(new int[][] {{0, 0, 1, 0},
												 {0, 0, 0, 0},
												 {0, 1, 0, 1},
												 {1, 0, 0, 0}}));
		
		System.out.println(solution(new int[][] {{0, 0, 0, 0, 0, 0},
												 {0, 1, 1, 1, 1, 0},
												 {0, 0, 1, 0, 0, 0},
												 {1, 0, 0, 1, 0, 1},
												 {0, 1, 0, 0, 0, 1},
												 {0, 0, 0, 0, 0, 0}}));
	}
}
