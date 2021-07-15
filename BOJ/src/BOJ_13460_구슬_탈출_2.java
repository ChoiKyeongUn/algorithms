

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13460_구슬_탈출_2 {
	static int N, M;
	static char[][] board;
	static Loc red, blue, hole;
	static int[] dy = {0, 0, -1, 1}, dx = {-1, 1, 0, 0};
	static boolean[][][] visited;
	static int result = -1;
	
	static class Loc {
		int y, x, dir;
		public Loc(int y, int x, int dir) {
			this.y = y;
			this.x = x;
			this.dir = dir;
		}
	}
	
	public static void main(String[] args) throws Exception  {
		input();
		bfs();
		System.out.println(result);
	}
	
	private static void bfs() {
		Queue<Loc> qr = new LinkedList<Loc>();
		Queue<Loc> qb = new LinkedList<Loc>();
		qr.offer(red);
		qb.offer(blue);
		visited[red.y][red.x][0] = true;
		
		while(!qr.isEmpty()) {
			Loc cur_red = qr.poll();
			int cur_red_y = cur_red.y;
			int cur_red_x = cur_red.x;
			
			Loc cur_blue = qb.poll();
			int cur_blue_y = cur_blue.y;
			int cur_blue_x = cur_blue.x;
			
			int cur_dir = cur_red.dir;
			
			
		}
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new char[N][M];
		visited = new boolean[N][M][4];
		
		for (int i = 0; i < N; i++) {
			String temp = br.readLine(); 
			for (int j = 0; j < M; j++) {
				board[i][j] = temp.charAt(j);
				if(board[i][j] == 'R') red = new Loc(i, j, 0);
				if(board[i][j] == 'B') blue = new Loc(i, j, 0);
				if(board[i][j] == 'O') hole = new Loc(i, j, 0);
			}
		}
	}
}
