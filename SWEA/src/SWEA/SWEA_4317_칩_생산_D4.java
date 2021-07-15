package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4317_칩_생산_D4 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int H, W, board[][], result;
	static boolean used[][];
	
	public static void main(String[] args) throws Exception {
		int T = stoi(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			input();
			result = getMaxChip(0);
			saveResult(tc);
		}
		System.out.println(sb);
	}
	
	private static int getMaxChip(int stage) {
		int dy = stage / W;
		int dx = stage % W;
		
		int max = 0;
		
		if(dy == H-2 && dx == W-1) return 0;
		
		if(isClean(dy, dx)) {
			setNemo(dy, dx, 1);
			int ret = getMaxChipCnt(stage + 1);
			if(ret > max) max = ret;
			setNemo(dy, dx, 0);
		}
		
		int ret = getMaxChipCnt(stage + 1);
		if(ret > max) max = ret;
		
		return max;
	}

	private static int getMaxChipCnt(int i) {
		// TODO Auto-generated method stub
		return 0;
	}

	private static boolean isClean(int dy, int dx) {
		if(dx >= W-1) return true;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				if(used[dy+i][dx+j] || board[dy+i][dx+j] > 0) return false;
			}
		}
		return true;
	}

	private static void setNemo(int dy, int dx, int val) {
		used[dy][dx] = used[dy][dx+1] = used[dy+1][dx] = used[dy+1][dx+1] = true;
	}

	private static void saveResult(int t) {
		sb.append("#").append(t).append(" ").append(result).append("\n");
	}

	private static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		H = stoi(st.nextToken());
		W = stoi(st.nextToken());
		board = new int[H][W];
		used = new boolean[H][W];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				board[i][j] = stoi(st.nextToken());
			}
		}
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
