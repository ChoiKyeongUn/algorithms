

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17136_색종이_붙이기 {
	static int[][] paper = new int[10][10];
	static boolean[][] checked = new boolean[10][10];
	static int cnt = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++)
				paper[i][j] = Integer.parseInt(st.nextToken());
		}
		
//		for (int i = 0; i < 10; i++) System.out.println(Arrays.toString(paper[i]));
//		for (int i = 0; i < 10; i++) System.out.println(Arrays.toString(checked[i]));

	}
}
