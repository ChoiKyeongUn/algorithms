

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2447_별_찍기_10 {
	static char[][] star;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		star = new char[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(star[i], ' ');
		}
		
		func(0, 0, N);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) sb.append(star[i][j]);
			sb.append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.print(sb);
	}
	
	private static void func(int i, int j, int len) {
		if(len == 1) {
			star[i][j] = '*';
			return;
		}
		
		int sub_len = len/3;
		for (int k = 0; k < 3; k++)	for (int k2 = 0; k2 < 3; k2++) {
			if(k == 1 && k2 == 1) continue;
			func(i+k*sub_len, j+k2*sub_len, sub_len);
		}
	}
}