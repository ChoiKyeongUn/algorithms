package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JUNGOL_1335_색종이_만들기_영역구분 {
	static int n, paper[][], cnt[] = new int[2];
	
	public static void main(String[] args) throws Exception {
		input();
		solve(0, 0, n);
		System.out.println(cnt[0]);
		System.out.println(cnt[1]);
	}

	private static void solve(int y, int x, int size) {
		if(same(y, x, size)) {
			++cnt[paper[y][x]];
			return;
		}
		int nextSize = size / 2;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				solve(y + nextSize * i, x + nextSize * j, nextSize);
			}
		}
	}

	private static boolean same(int y, int x, int size) {
		int temp = paper[y][x];
		for (int i = y; i < y+size; i++) {
			for (int j = x; j < x+size; j++) {
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
