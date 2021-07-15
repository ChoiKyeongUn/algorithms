package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JUNGOL_3560_색종이_만들기2_4진트리 {
	static int n, paper[][];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		input();
		solve(0, 0, n);
		System.out.println(sb.toString());
	}

	private static void solve(int y, int x, int size) {
		if(same(y, x, size)) {
			sb.append(paper[y][x]);
			return;
		}
		sb.append('X');
		int half = size / 2;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				solve(y + half * i, x + half * j, half);
			}
		}
	}

	private static boolean same(int y, int x, int size) {
		int temp = paper[y][x];
		for (int i = y; i < y + size; i++) {
			for (int j = x; j < x + size; j++) {
				if(paper[i][j] != temp) {
					return false;
				}
			}
		}
		return true;
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = stoi(br.readLine());
		paper = new int[n][n];
		for (int i = 0; i < n; i++) {
			String temp = br.readLine();
			for (int j = 0, idx = 0; j < n; j++, idx+=2) {
				paper[i][j] = temp.charAt(idx) - '0';
			}
		}
	}
	
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
