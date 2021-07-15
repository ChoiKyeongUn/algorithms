

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2563 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] paper = new int[100][100];
		int width, height, cnt = 0;
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			width = Integer.parseInt(st.nextToken());
			height = Integer.parseInt(st.nextToken());
			for (int j = 0; j < 10; j++)
				for (int j2 = 0; j2 < 10; j2++)
					paper[height + j][width + j2] = 1;
		}
		
		for (int i = 0; i < paper.length; i++)
			for (int j = 0; j < paper[0].length; j++)
				if (paper[i][j] == 1) cnt++;
		
		System.out.println(cnt);

	}
}
