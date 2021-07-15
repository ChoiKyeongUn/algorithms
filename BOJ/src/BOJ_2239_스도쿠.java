

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2239_스도쿠 {
	static int board[][] = new int[9][9],
			   zeros[][] = new int[81][2],
			   size = 0;
	static boolean width[][] = new boolean[9][9],
				   height[][] = new boolean[9][9],
				   box[][] = new boolean[9][9];
	static boolean flag = false;
	public static void main(String[] args) throws Exception {
		input();
		dfs(0);
		printBoard();
	}

	private static void printBoard() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}

	private static void dfs(int i) {
		if(i == size) {
			flag = true;
			return;
		}
		if(flag) return;
		int cur_y = zeros[i][0];
		int cur_x = zeros[i][1];
		
		for (int j = 1; j <= 9; j++) {
			if(flag) return;
			
			if(width[cur_y][j-1])  continue;
			if(height[cur_x][j-1])  continue;
			if(box[cur_y/3*3 + cur_x/3][j-1]) continue;
			
			width[cur_y][j-1] = true;
			height[cur_x][j-1] = true;
			box[cur_y/3*3 + cur_x/3][j-1] = true;
			board[cur_y][cur_x] = j;
			
			dfs(i+1);
			
			width[cur_y][j-1] = false;
			height[cur_x][j-1] = false;
			box[cur_y/3*3 + cur_x/3][j-1] = false;
		}
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 9; i++) {
			String temp = br.readLine();
			for (int j = 0; j < 9; j++) {
				board[i][j] = temp.charAt(j) - '0';
				if(board[i][j] == 0) {
					zeros[size][0] = i;
					zeros[size++][1] = j;
				} else {
					width[i][board[i][j]-1] = true;
					height[j][board[i][j]-1] = true;
					box[i/3*3 + j/3][board[i][j]-1] = true;
				}
			}
		}
	}
}
