package JUNGOL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JUNGOL_1733_오목2 {
	private static int answerColor = 0;
	static int[][] m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		m = new int[19+2][19+2];
		String temp;
		for (int i = 1; i <= 19; i++) {
			temp = br.readLine();
			for (int j = 1, index = 0; j <= 19; j++, index += 2)
				m[i][j] = temp.charAt(index) - '0';
		}
		
		for (int i = 1; i <= 19; i++) {
			for (int j = 1; j <= 19; j++) {
				if (m[i][j] == 0) continue;
				if (complete(i, j)) {
					System.out.println(answerColor);
					System.out.println(i+" "+j);
					return;
				}
			}
		}
		System.out.println(answerColor);
	}
	
	private static int[] dy = {-1, 0, 1, 1};
	private static int[] dx = {1, 1, 1, 0};
	
	/** r,c 좌표애서 시작하는 오목이 되었는지 확인하고, 오목이면 true / 아니면 false 리턴 메서드*/
	public static boolean complete(int i, int j) {
		int color = m[i][j];
dir:	for (int k = 0; k < 4; k++) {
			
			if (m[i - dy[k]][j - dx[k]] == color) continue; // 이전 칸은 다른 색인지
			for (int k2 = i; k2 < 5; k2++) { // 오목인지 확인
				if (m[i + dy[k] * k2][j + dx[k] * k2] != color)
					continue dir;
			}
			if (m[i + dy[k] * 5][j + dx[k] * 5] == color) continue; // 이후 칸은 다른 색인지
			
			// 오목임
			answerColor = color;
			return true;
		}
		return false; // 오목 아님
	}
	
	
}
