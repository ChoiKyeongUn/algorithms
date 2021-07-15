package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_5656_벽돌_깨기 {
	
	static class Block {
		int y, x, value;
		public Block(int y, int x, int value) {
			this.y = y;
			this.x = x;
			this.value = value;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, W, H, block[][], copy_block[][], result, selected[], dy[] = {-1, 1, 0, 0}, dx[] = {0, 0, -1, 1};
	static StringBuilder sb = new StringBuilder();
	static boolean[][] visited;
	static Queue<Block> queue = new LinkedList<Block>();
	
	public static void main(String[] args) throws Exception { 
		int T = stoi(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			input();
			perm(0);
			saveResult(tc);
		}
		System.out.println(sb);
	} 
	
	private static void perm(int cnt) {
		if(cnt == N) {
			drop();
			return;
		}
		
		for (int i = 0; i < W; i++) {
			if(block[H-1][i] == 0) continue;
			selected[cnt] = i;
			perm(cnt+1);
		}
	} 

	private static void drop() {
		copy();
		for (int i = 0; i < N; i++) {
			int cur_w = selected[i];
			for (int j = 0; j < H; j++) {
				if(copy_block[j][cur_w] != 0) {
					bomb(j, cur_w);
					move();
					break;
				}
			}
		}
		
		update();
	}

	private static void update() {
		int total = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if(copy_block[i][j] != 0) ++total;
			}
		}
		result = Math.min(total, result);
	}

	private static void print_Arr() {
		for (int i = 0; i < H; i++) {
			System.out.println(Arrays.toString(copy_block[i]));
		}
		System.out.println();
	}

	private static void copy() {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				copy_block[i][j] = block[i][j];
			}
		}
	}

	private static void move() {
		for (int i = 0; i < W; i++) {
			Queue<Integer> tmp_q = new LinkedList<Integer>();
			for (int j = H-1; j >= 0; j--) {
				if(copy_block[j][i] != 0) {
					tmp_q.offer(copy_block[j][i]);
					copy_block[j][i] = 0;
				}
			}
				
			
			int idx = H-1;
			while(!tmp_q.isEmpty()) {
				copy_block[idx--][i] = tmp_q.poll();
			}
		}
	}

	private static void bomb(int y, int x) {
		visited = new boolean[H][W];
		visited[y][x] = true;
		queue.offer(new Block(y, x, copy_block[y][x]));
		
		while(!queue.isEmpty()) {
			Block cur = queue.poll();
			int cur_y = cur.y;
			int cur_x = cur.x;
			int cur_value = cur.value;
			copy_block[cur_y][cur_x] = 0;
			
			for (int i = 0; i < 4; i++) {
				for (int j = 1; j <= cur_value-1; j++) {
					int ny = cur_y + j*dy[i];
					int nx = cur_x + j*dx[i];
					if(isInRange(ny, nx) && !visited[ny][nx] && copy_block[ny][nx] != 0) {
						visited[ny][nx] = true;
						queue.offer(new Block(ny, nx, copy_block[ny][nx]));
					}
				}
			}
		}
	}

	private static boolean isInRange(int y, int x) {
		return 0 <= y && y < H && 0 <= x && x < W;
	}

	private static void saveResult(int tc) {
		sb.append("#").append(tc).append(" ").append(result).append("\n");
	}

	private static void input() throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		W = stoi(st.nextToken());
		H = stoi(st.nextToken());
		block = new int[H][W];
		copy_block = new int[H][W];
		selected = new int[N];
		for (int i = 0; i < H; i++) {
			String temp = br.readLine();
			for (int j = 0, idx = 0; j < W; j++, idx+=2) {
				block[i][j] = temp.charAt(idx) - '0';
			}
		}
		result = H*W;
	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}
} 
