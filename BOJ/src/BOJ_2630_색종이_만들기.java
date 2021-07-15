

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2630_색종이_만들기 {
	static int N;
	static int[][] paper;
	static int cnt_white = 0;
	static int cnt_blue = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		paper = new int[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				paper[i][j] = Integer.parseInt(st.nextToken());
		}
		divide(0, 0, N);
		System.out.println(cnt_white);
		System.out.println(cnt_blue);
	}
	
	static boolean same(int x, int y, int N) {
		for (int i = x; i < x+N; i++)
			for (int j = y; j < y+N; j++)
				if (paper[x][y] != paper[i][j]) return false;
		return true;
	}
	
	static void divide(int x, int y, int N) {
		if (same(x, y, N)) {
			if (paper[x][y] == 0) cnt_white++;
			else cnt_blue++;
			return;
		}
		
		int size = N/2;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				divide(x+i*size, y+j*size, size);
			}
		}
	}
}
