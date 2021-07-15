package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JUNGOL_1824_스도쿠 {
	
	static int board[][], loc[][], size;
	static boolean[][] width, height, box;
	static boolean flag = false;
	
	public static void main(String[] args) throws Exception {
		input();
		solve(0);
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void solve(int i) {
		if(i == size) {
			flag = true;
			return;
		}
		
		int y = loc[i][0];
		int x = loc[i][1];
		if(flag) {
			return;
		}
		for (int j = 0; j < 9; j++) {
			if(flag) {
				return;
			}
			if(!width[y][j] && !height[x][j] && !box[y / 3 * 3 + x / 3][j]) {
				width[y][j] = true;
				height[x][j] = true;
				box[y / 3 * 3 + x / 3][j] = true;
				board[y][x] = j + 1;
				solve(i + 1);
				width[y][j] = false;
				height[x][j] = false;
				box[y / 3 * 3 + x / 3][j] = false;
			}
		}
	}

	private static void input() throws Exception {
		board = new int[9][9];
		loc = new int[81][2];
		size = 0;
		width = new boolean[9][9];
		height = new boolean[9][9];
		box = new boolean[9][9];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 9; i++) {
			String temp = br.readLine();
			for (int j = 0, idx = 0; j < 9; j++, idx+=2) {
				board[i][j] = temp.charAt(idx) - '0';
				if(board[i][j] == 0) {
					loc[size][0] = i;
					loc[size++][1] = j;
				} else {
					width[i][board[i][j] - 1] = true;					
					height[j][board[i][j] - 1] = true;
					box[i / 3 * 3 + j / 3][board[i][j] - 1] = true;
				}
			}
		}
	}
}
